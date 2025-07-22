package it.ji.equals;

public class EqualsExample {

    public static void main(String[] args) {

        Gatto gatto1 = new Gatto("Micio", "Siamese");
        Gatto gatto2 = new Gatto("Micio", "Siamese");

        // Confronto tra riferimenti
        if (gatto1 == gatto2) {
            System.out.println("I riferimenti ai gatti sono uguali.");
        } else {
            System.out.println("I riferimenti ai gatti sono diversi.");
        }

        // Confronto usando equals
        if (gatto1.equals(gatto2)) {
            System.out.println("I gatti sono uguali secondo equals.");
        } else {
            System.out.println("I gatti sono diversi secondo equals.");
        }


    }
}
