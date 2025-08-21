package it.ji.esercizi.files.esercizio3;

import java.io.File;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class PioggiaStatistiche {
    private static final File FILE = new File("Pioggia.dat");
    private static final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;

    public static void readFromFile() {
        Vector<Pioggia> records = readAllVector();
        if (records.size() == 0) {
            System.out.println("Nessun dato presente in Pioggia.dat");
            return;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < records.size(); i++) {
            Pioggia p = records.elementAt(i);
            System.out.println(fmt.format(p.getData()) + " " + p.getQuantity());
        }
    }

    public static void media() {
        Vector<Pioggia> records = readAllVector();
        if (records.size() == 0) {
            System.out.println("Media: nessun dato");
            return;
        }
        long sum = 0;
        for (int i = 0; i < records.size(); i++) {
            Pioggia p = records.elementAt(i);
            sum += p.getQuantity();
        }
        double avg = sum / (double) records.size();
        System.out.printf("Media giornaliera: %.2f mm\n", avg);
    }

    public static void max() {
        Vector<Pioggia> records = readAllVector();
        if (records.size() == 0) {
            System.out.println("Massimo: nessun dato");
            return;
        }
        Pioggia max = null;
        for (int i = 0; i < records.size(); i++) {
            Pioggia p = records.elementAt(i);
            if (max == null || p.getQuantity() > max.getQuantity()){
                max = p;
            }
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Massimo giornaliero: " + max.getQuantity() + " mm il " + fmt.format(max.getData()));
    }

    public static void periodoSiccita() {
        Vector<Pioggia> records = readAllVector();
        if (records.size() == 0) {
            System.out.println("Periodo di siccità: nessun dato");
            return;
        }
        // File già ordinato temporalmente: scorro e conto solo zeri consecutivi giorno per giorno
        int longest = 0;
        int current = 0;
        Date prevZeroDate = null; // ultima data con pioggia=0 nella sequenza corrente
        for (int i = 0; i < records.size(); i++) {
            Pioggia p = records.elementAt(i);
            if (p.getQuantity() == 0) {
                if (current == 0) {
                    current = 1;
                    prevZeroDate = p.getData();
                } else {
                    long diff = p.getData().getTime() - prevZeroDate.getTime();
                    if (diff == MILLIS_PER_DAY) {
                        current++;
                    } else {
                        current = 1; // nuova sequenza di siccità
                    }
                    prevZeroDate = p.getData();
                }
            } else {
                current = 0;
                prevZeroDate = null;
            }
            if (current > longest) {
                longest = current;
            }
        }
        System.out.println("Periodo di siccità più lungo: " + longest + " giorni consecutivi");
    }

    private static boolean areConsecutive(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return diff == MILLIS_PER_DAY;
    }

    private static Vector<Pioggia> readAllVector() {
        Vector<Pioggia> v = new Vector<Pioggia>();
        if (!FILE.exists()) {
            return v;
        }
        DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)));
            while (true) {
                try {
                    long ts = in.readLong();
                    int qty = in.readInt();
                    v.addElement(new Pioggia(new Date(ts), qty));
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file Pioggia.dat");
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Errore nella chiusura del file Pioggia.dat");
                    e.printStackTrace();
                }
            }
        }
        return v;
    }
}
