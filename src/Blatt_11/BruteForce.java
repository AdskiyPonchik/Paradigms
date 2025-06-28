package Blatt_11;

import java.util.Arrays;
import java.nio.ByteBuffer;
import java.math.BigInteger;

//the digestlib of java is odd we use our own
class MD5 {

    private static final int INIT_A = 0x67452301;
    private static final int INIT_B = (int)0xEFCDAB89L;
    private static final int INIT_C = (int)0x98BADCFEL;
    private static final int INIT_D = 0x10325476;

    private static final int[] SHIFT_AMTS = {
            7, 12, 17, 22,
            5,  9, 14, 20,
            4, 11, 16, 23,
            6, 10, 15, 21
    };

    private static final int[] TABLE_T = new int[64];

    static { // see, what we did here?
        for (int i = 0; i < 64; i++)
            TABLE_T[i] = (int)(long)((1L << 32) * Math.abs(Math.sin(i + 1)));
    }

    public static byte[] computeMD5(byte[] message) {
        int messageLenBytes = message.length;
        int numBlocks = ((messageLenBytes + 8) >>> 6) + 1; // unsigned shift: >>>
        int totalLen = numBlocks << 6;
        byte[] paddingBytes = new byte[totalLen - messageLenBytes];
        paddingBytes[0] = (byte)0x80;

        long messageLenBits = (long)messageLenBytes << 3;
        for (int i = 0; i < 8; i++) {
            paddingBytes[paddingBytes.length - 8 + i] = (byte)messageLenBits;
            messageLenBits >>>= 8;
        }

        int a = INIT_A;
        int b = INIT_B;
        int c = INIT_C;
        int d = INIT_D;
        int[] buffer = new int[16];
        for (int i = 0; i < numBlocks; i ++) {
            int index = i << 6;
            for (int j = 0; j < 64; j++, index++) {
                // This one is easy, simple and concise...
                buffer[j >>> 2] = ((int)((index < messageLenBytes) ? message[index] : paddingBytes[index - messageLenBytes]) << 24) | (buffer[j >>> 2] >>> 8);
            }
            int originalA = a;
            int originalB = b;
            int originalC = c;
            int originalD = d;
            for (int j = 0; j < 64; j++) {
                int div16 = j >>> 4;
                int f = 0;
                int bufferIndex = j;
                switch (div16) {
                    case 0: f = (b & c) | (~b & d);
                        break;
                    case 1: f = (b & d) | (c & ~d);
                        bufferIndex = (bufferIndex * 5 + 1) & 0x0F;
                        break;
                    case 2: f = b ^ c ^ d;
                        bufferIndex = (bufferIndex * 3 + 5) & 0x0F;
                        break;
                    case 3: f = c ^ (b | ~d);
                        bufferIndex = (bufferIndex * 7) & 0x0F;
                        break;
                }
                int temp = b + Integer.rotateLeft(a + f + buffer[bufferIndex] + TABLE_T[j], SHIFT_AMTS[(div16 << 2) | (j & 3)]);
                a = d;
                d = c;
                c = b;
                b = temp;
            }

            a += originalA;
            b += originalB;
            c += originalC;
            d += originalD;
        }

        byte[] md5 = new byte[16];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int n = (i == 0) ? a : ((i == 1) ? b : ((i == 2) ? c : d));
            for (int j = 0; j < 4; j++) {
                md5[count++] = (byte)n;
                n >>>= 8;
            }
        }
        return md5;
    }

    public static String toHexString(byte[] b)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(String.format("%02X", b[i] & 0xFF));
        }
        return sb.toString();
    }
}

class ReverseHashes implements Runnable {
    volatile static boolean found = false;
    private final byte[] targethash;
    private final long start, end;
    private long result = -1;

    public ReverseHashes(long start, long end, byte[] hash) {
        this.start = start;
        this.end = end;
        this.targethash = hash;
    }

    public void run() {
        if (found) return;

        for (long i = start; i <= end && !found; i++) {
            int iAsInt = (int)i;  // manual cast? possibly missing some data
            byte[] input = ByteBuffer.allocate(4).putInt(iAsInt).array();
            byte[] hash = MD5.computeMD5(input);

            if (Arrays.equals(hash, targethash)) {
                result = i;
                found = true;
                break;
            }
        }
    }

    public long getResult() {
        return result;
    }
}


class ParallelReverseHashes {

    // бляя сложно
    public static long parallelReverseHash(byte[] passhash, long startValue, long endValue) {
        int threads = Runtime.getRuntime().availableProcessors();
        long range = endValue - startValue + 1;
        long chunkSize = range / threads;

        Thread[] threadList = new Thread[threads];
        ReverseHashes[] workers = new ReverseHashes[threads];

        for (int i = 0; i < threads; i++) {
            long chunkStart = startValue + i * chunkSize;
            long chunkEnd = (i == threads - 1) ? endValue : chunkStart + chunkSize - 1;

            workers[i] = new ReverseHashes(chunkStart, chunkEnd, passhash);
            threadList[i] = new Thread(workers[i]);
            threadList[i].start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (ReverseHashes r : workers) {
            if (r.getResult() != -1) {
                return r.getResult();  // return only if found
            }
        }

        return -1; // no one found
    }
}

class BruteForce {
    public static void main(String[] args) {
        byte[] passhash = {45, 27, -67, -30, -84, -84, 10, -3, 7, 100, 109, -104, 21, 79, 64, 46};
        long start = 3_400_000_000L; 
        long end = 3_500_000_000L;

        long t0 = System.currentTimeMillis();
        long result = ParallelReverseHashes.parallelReverseHash(passhash, start, end);
        long t1 = System.currentTimeMillis();

        if (result != -1) {
            System.out.printf("Found: %d (0x%08X)\n", result, result);
        } else {
            System.out.println("Nothing found");
        }

        System.out.println("Time required:" + (t1 - t0) + " ms");
    }
}
