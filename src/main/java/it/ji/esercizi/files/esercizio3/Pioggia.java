package it.ji.esercizi.files.esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Pioggia {
    private Date data;
    private int quantity;

    public Pioggia(Date data, int quantity) {
        this.data = data;
        this.quantity = quantity;
    }

    public Date getData() {
        return data;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Pioggia [data=" + data + ", quantity=" + quantity + "]";
    }

    public void saveToFile() {
        // codice per salvare il dato nel file Pioggia.dat

        //controllare se il file esiste e se non esiste creare un file di testo con il nome Pioggia.dat
        File pioggiaFile = new File("Pioggia.txt");
        if (!pioggiaFile.exists()) {
            System.out.println("Il file Pioggia.dat non esiste, lo creo");
            try {
                pioggiaFile.createNewFile();
                System.out.println("File creato con successo");
            } catch (IOException e) {
                System.err.println("Errore nella creazione del file Pioggia.txt");
                e.printStackTrace();
            }
        }
        // salviamo i dati dentro [DATA] e [QUANTITY] separati da uno spazio
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(pioggiaFile);
            //format data into a string in the format "dd/MM/yyyy" using SimpleDateFormat
            String data = new java.text.SimpleDateFormat("dd/MM/yyyy").format(this.data);
            writer.println(data + " " + quantity);
            writer.close();
            System.out.println("Dati salvati con successo");
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file Pioggia.txt");
            e.printStackTrace();
        }
    }
}
