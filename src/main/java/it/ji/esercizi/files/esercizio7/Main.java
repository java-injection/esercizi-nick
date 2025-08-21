package it.ji.esercizi.files.esercizio7;


//Nel file di testo scrutini.txt devono essere inseriti la matricola (int), il cognome e nome dell’alunno,
//il voto (int) finale di ammissione alla maturità e un campo vuoto (giudizio).
//Scrivi un programma che, dopo aver riempito tale file, lo rilegga sostituendo al giudizio la voce
// “ammesso”, oppure “non ammesso”, a seconda del voto presente. Infine stampi a video:
//        – il numero totale di studenti;
//       – la matricola degli alunni ammessi;
//       – la percentuale di studenti non ammessi.
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        while (true) {
            System.out.println("Scegli un'operazione e premi invio:");
            System.out.println("1) Inserisci studenti");
            System.out.println("2) Leggi il file, assegna giudizi e stampa risultati");
            System.out.println("0) Esci");

            int scelta = tastiera.nextInt();
            if (scelta == 0) {
                System.out.println("Chiusura in corso...");
                tastiera.close();
                return;
            } else if (scelta == 1) {
                inserisciStudenti(tastiera);
            } else if (scelta == 2) {
                elaboraScrutini();
            } else {
                System.out.println("Scelta non valida");
            }
        }
    }

    private static void inserisciStudenti(Scanner tastiera) {
        System.out.println("Quanti studenti vuoi inserire?");
        int numeroStudenti = tastiera.nextInt();
        if (numeroStudenti < 0) {
            numeroStudenti = 0;
        }

        Vector<Studente> studenti = new Vector<Studente>();

        for (int i = 0; i < numeroStudenti; i++) {
            System.out.println("Studente n." + (i + 1));

            System.out.println("Inserisci matricola:");
            int matricola = tastiera.nextInt();

            System.out.println("Inserisci cognome:");
            String cognome = tastiera.next();

            System.out.println("Inserisci nome:");
            String nome = tastiera.next();

            System.out.println("Inserisci voto:");
            int voto = tastiera.nextInt();

            Studente s = new Studente(matricola, cognome, nome, voto);
            studenti.add(s);
        }

        ScrutiniManager.salvaStudenti(studenti);
    }

    private static void elaboraScrutini() {
        ScrutiniManager.elaboraFileEStampa();
    }
}
