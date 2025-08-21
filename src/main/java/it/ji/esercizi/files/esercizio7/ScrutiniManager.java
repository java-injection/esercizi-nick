package it.ji.esercizi.files.esercizio7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class ScrutiniManager {

    public static final String FILE_SCRUTINI = "scrutini.txt";

    public static void salvaStudenti(Vector<Studente> studenti) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(FILE_SCRUTINI));
            for (int i = 0; i < studenti.size(); i++) {
                Studente s = studenti.elementAt(i);
                // in inserimento il giudizio rimane vuoto
                String riga = s.getMatricola() + ";" + s.getCognome() + " " + s.getNome() + ";" + s.getVoto() + ";";
                out.println(riga);
            }
            out.flush();
            System.out.println("File '" + FILE_SCRUTINI + "' creato/aggiornato con successo.");
        } catch (IOException e) {
            System.out.println("Errore in scrittura file: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static Vector<Studente> leggiStudenti() {
        Vector<Studente> elenco = new Vector<Studente>();
        File f = new File(FILE_SCRUTINI);
        if (!f.exists()) {
            return elenco;
        }
        Scanner sc = null;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String riga = sc.nextLine();
                if (riga.trim().length() == 0) {
                    continue;
                }
                String[] campi = riga.split(";");
                if (campi.length < 3) {
                    continue;
                }
                int matricola = 0;
                int voto = 0;
                try {
                    matricola = Integer.parseInt(campi[0]);
                    voto = Integer.parseInt(campi[2]);
                } catch (Exception e) {
                    continue;
                }
                String nomeCompleto = campi[1];
                String cognome = nomeCompleto;
                String nome = "";
                int spazio = nomeCompleto.indexOf(' ');
                if (spazio >= 0) {
                    cognome = nomeCompleto.substring(0, spazio);
                    nome = nomeCompleto.substring(spazio + 1);
                }
                String giudizio = "";
                if (campi.length >= 4) {
                    giudizio = campi[3];
                }
                elenco.add(new Studente(matricola, cognome, nome, voto, giudizio));
            }
        } catch (Exception e) {
            System.out.println("Errore in lettura: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return elenco;
    }

    public static void elaboraFileEStampa() {
        Vector<Studente> studenti = leggiStudenti();
        if (studenti.size() == 0) {
            System.out.println("Il file è vuoto o non esiste.");
            return;
        }

        int totaleStudenti = 0;
        int numeroNonAmmessi = 0;
        Vector<Integer> matricoleAmmessi = new Vector<Integer>();

        for (int i = 0; i < studenti.size(); i++) {
            Studente s = studenti.elementAt(i);
            String giudizio = "";
            if (s.getVoto() >= 6) {
                giudizio = "ammesso";
                matricoleAmmessi.add(s.getMatricola());
            } else {
                giudizio = "non ammesso";
                numeroNonAmmessi = numeroNonAmmessi + 1;
            }
            s.setGiudizio(giudizio);
            totaleStudenti = totaleStudenti + 1;
        }

        // riscrive file con giudizi
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(FILE_SCRUTINI));
            for (int i = 0; i < studenti.size(); i++) {
                Studente s = studenti.elementAt(i);
                String riga = s.getMatricola() + ";" + s.getCognome() + " " + s.getNome() + ";" + s.getVoto() + ";" + s.getGiudizio();
                out.println(riga);
            }
            out.flush();
        } catch (IOException e) {
            System.out.println("Errore in scrittura file: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }

        // stampa risultati richiesti
        System.out.println("Numero totale di studenti: " + totaleStudenti);
        System.out.println("Matricole degli alunni ammessi:");
        for (int i = 0; i < matricoleAmmessi.size(); i++) {
            System.out.println(matricoleAmmessi.elementAt(i));
        }
        double percentualeNonAmmessi = (numeroNonAmmessi * 100.0) / (double) totaleStudenti;
        System.out.printf("Percentuale di studenti non ammessi: %.2f%%\n", percentualeNonAmmessi);
    }
}
