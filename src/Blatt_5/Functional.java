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

public class Functional {

    enum Codec {
        BIN, OCT, DEC, HEX
    }

    // Funktion, die Zahl in passendes Format bringt
    public static String formatNumber(int number, Codec codec) {
        return switch (codec) {
            case BIN -> String.format("0b%s", Integer.toBinaryString(number));
            case OCT -> String.format("0o%s", Integer.toOctalString(number));
            case DEC -> String.format("%d", number);
            case HEX -> String.format("0x%s", Integer.toHexString(number));
        };
    }
    public static void main(String[] agrs){
        int number=16;
        Codec[] codecs = {Codec.DEC, Codec.BIN, Codec.OCT, Codec.HEX};
        for(Codec c: codecs){
            System.out.println(formatNumber(number, c));
        }
    }
}