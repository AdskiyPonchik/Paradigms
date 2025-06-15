package Blatt_5;
/*
Kontext ist der Zustand außerhalb der Funktion, 
z.B. globale Variablen.
Scala beispiel:
var x = 5
def add(n: Int): Int = n + x


Seiteneffekte sind Änderungen außerhalb der Funktion, 
z.B. das Schreiben in eine Datei oder das Verändern einer globalen Variable.
val list = List(1, 2, 3)

list.map(n => {
  println(n) // seiteneffekt
  n * 2
})

 */
public class NonFunctional {
    public static final int BIN = 0;
    public static final int OCT = 1;
    public static final int DEC = 2;
    public static final int HEX = 3;

    private static int codec = DEC;
    private static int number = 0;

    public static void setNumber(int newNumber){
        number = newNumber;
    }

    public static void printNumber(){
        printNumber(number);
    }

    private static void printNumber(int printNumber){
        switch(codec){
            case BIN:
                System.out.format("0b%s\n", Integer.toBinaryString(printNumber));
                return;
            case OCT:
                System.out.format("0o%s\n",Integer.toOctalString(printNumber));
                return;
            case DEC:
                System.out.format("%d\n",printNumber);
                return;
            case HEX:
                System.out.format("0x%s\n",Integer.toHexString(printNumber));
                return;
            default:
                System.err.format("unknown codec '%d'\n",codec);
        }
    }

    public static void setCodec(int newCodec){
        codec = newCodec;
    }

    public static void main(String[] args){
        printNumber();
        setNumber(1337);
        setCodec(BIN);
        printNumber();
        setCodec(OCT);
        printNumber();
        setCodec(DEC);
        printNumber();
        setCodec(HEX);
        printNumber();
    }
}
