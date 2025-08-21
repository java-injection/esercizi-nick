package it.ji.esercizi.files.rubrica;
import java.util.Scanner;
public class EsercizioFile {

    //Inserire nome, cognome, age, in un file, e poi fare una funzione di lettura della rubrica
    // trovare il più vecchio e stamparne i dati
    public static void main(String[] args) {
        int x = 0;
        System.out.println("scegli e premi invio:");
        System.out.println("1) inserisci dati");
        System.out.println("2) leggi dati");
        System.out.println("3) trova il piu vecchio");
        System.out.println("0) esci");
        Scanner in = new Scanner(System.in);
        int scelta = in.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("inserisci il nome:");
                String nome = in.nextLine();
                System.out.println("inserisci il cognome:");
                String cognome = in.nextLine();
                System.out.println("inserisci l'eta:");
                int eta = in.nextInt();
                Persona persona = new Persona(nome, cognome, eta);
                Rubrica.salvaPersona(persona);
                break;
            case 2:
                Rubrica.stampaRubrica();
                break;
            case 3:
                Rubrica.trovaPersonaPiuVecchia();
                break;
            case 0:
                System.out.println("chiusura in corso");
                System.exit(0);
            default:
                System.out.println("scelta non valida");
        }

    }
}
