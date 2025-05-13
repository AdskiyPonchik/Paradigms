package woche3;
// Класс продукта
class Pizza {
    private String teig;
    private String sauce;
    private String belag;
    private String käse;

    private Pizza(String teig, String sauce, String belag, String käse) {
        this.teig = teig;
        this.sauce = sauce;
        this.belag = belag;
        this.käse = käse;
    }
    public static class Builder {
        private String teig;
        private String sauce;
        private String belag;
        private String käse;

        public Builder setTeig(String teig) {
            this.teig = teig;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setBelag(String belag) {
            this.belag = belag;
            return this;
        }

        public Builder setKäse(String käse) {
            this.käse = käse;
            return this;
        }

        public Pizza build() {
            return new Pizza(teig, sauce, belag, käse);
        }
    }


    public void anzeigen() {
        System.out.println("Pizza mit:");
        System.out.println("- Teig: " + teig);
        System.out.println("- Sauce: " + sauce);
        System.out.println("- Belag: " + belag);
        System.out.println("- Käse: " + käse);
    }

    public static void main(String[] args) {
        // Создание пиццы с помощью билдера
        Pizza pizza = new Pizza.Builder()
                .setTeig("Dünner Boden")
                .setSauce("Tomatensauce")
                .setBelag("Salami")
                .setKäse("Mozzarella")
                .build();

        // Вывод результата
        pizza.anzeigen();
    }
}

/*
+ Ermöglicht die schrittweise Erstellung von Produkten.
+ Derselbe Code kann zur Erstellung verschiedener Produkte verwendet werden.
+ Trennt komplexen Erstellungsprozess vom Hauptgeschäftslogik des Produkts.
- Erhöht die Komplexität des Programms durch zusätzliche Klassen.
- Der Client ist an konkrete Builder-Klassen gebunden, da die Direktor-Schnittstelle möglicherweise keine Methode zur Ergebnisrückgabe enthält.

*/