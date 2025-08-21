package it.ji.esercizi.files.esercizio3;

import java.io.File;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
        // Salva il record in formato binario su Pioggia.dat: [long timestamp][int quantity]
        File pioggiaFile = new File("Pioggia.dat");
        if (!pioggiaFile.exists()) {
            System.out.println("Il file Pioggia.dat non esiste, lo creo");
            try {
                pioggiaFile.createNewFile();
                System.out.println("File creato con successo");
            } catch (IOException e) {
                System.err.println("Errore nella creazione del file Pioggia.dat");
                e.printStackTrace();
            }
        }
        // Append del record binario (senza try-with-resources)
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(pioggiaFile, true)));
            out.writeLong(this.data.getTime());
            out.writeInt(this.quantity);
            out.flush();
            System.out.println("Dati salvati con successo su Pioggia.dat");
        } catch (IOException e) {
            System.err.println("Errore nella scrittura del file Pioggia.dat");
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("Errore nella chiusura del file Pioggia.dat");
                    e.printStackTrace();
                }
            }
        }
    }
}
