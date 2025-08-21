package it.ji.esercizi.files.esercizio3;

import java.io.File;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PioggiaStatistiche {
    private static final File FILE = new File("Pioggia.dat");
    private static final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;

    public static void readFromFile() {
        List<Pioggia> records = readAll();
        if (records.isEmpty()) {
            System.out.println("Nessun dato presente in Pioggia.dat");
            return;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        for (Pioggia p : records) {
            System.out.println(fmt.format(p.getData()) + " " + p.getQuantity());
        }
    }

    public static void media() {
        List<Pioggia> records = readAll();
        if (records.isEmpty()) {
            System.out.println("Media: nessun dato");
            return;
        }
        long sum = 0;
        for (Pioggia p : records) {
            sum += p.getQuantity();
        }
        double avg = sum / (double) records.size();
        System.out.printf("Media giornaliera: %.2f mm\n", avg);
    }

    public static void max() {
        List<Pioggia> records = readAll();
        if (records.isEmpty()) {
            System.out.println("Massimo: nessun dato");
            return;
        }
        Pioggia max = null;
        for (Pioggia p : records) {
            if (max == null || p.getQuantity() > max.getQuantity()){
                max = p;
            }
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Massimo giornaliero: " + max.getQuantity() + " mm il " + fmt.format(max.getData()));
    }

    public static void periodoSiccita() {
        List<Pioggia> records = readAll();
        if (records.isEmpty()) {
            System.out.println("Periodo di siccità: nessun dato");
            return;
        }
        // Ordina per data crescente
        records.sort(Comparator.comparing(Pioggia::getData));
        int longest = 0;
        int current = 0;
        for (int i = 0; i < records.size(); i++) {
            Pioggia p = records.get(i);
            if (p.getQuantity() == 0) {
                if (i == 0) {
                    current = 1;
                } else {
                    Pioggia prev = records.get(i - 1);
                    boolean consecutiveDay = areConsecutive(prev.getData(), p.getData());
                    if (consecutiveDay && prev.getQuantity() == 0) {
                        current += 1;
                    } else {
                        current = 1;
                    }
                }
            } else {
                current = 0;
            }
            if (current > longest) longest = current;
        }
        System.out.println("Periodo di siccità più lungo: " + longest + " giorni consecutivi");
    }

    private static boolean areConsecutive(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return diff == MILLIS_PER_DAY;
    }

    private static List<Pioggia> readAll() {
        List<Pioggia> list = new ArrayList<>();
        if (!FILE.exists()) {
            return list;
        }
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
            while (true) {
                try {
                    long ts = in.readLong();
                    int qty = in.readInt();
                    list.add(new Pioggia(new Date(ts), qty));
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file Pioggia.dat");
            e.printStackTrace();
        }
        return list;
    }
}
