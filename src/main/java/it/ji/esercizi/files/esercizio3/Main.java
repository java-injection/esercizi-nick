package it.ji.esercizi.files.esercizio3;

import java.text.ParseException;
import java.util.Date;

public class Main {

//    Scrivi un programma per salvare, giorno per giorno, su un file binario di nome Pioggia.dat, la
//    quantità in millimetri di pioggia caduta. Successivamente, leggi i dati registrati nel file Pioggia.dat
//    e calcola:
//        – la quantità di pioggia mediamente caduta al giorno;
//       – la quantità massima di pioggia caduta in un giorno;
//       – il periodo (numero di giorni consecutivi) più lungo di siccità.

    //APPUNTI
//    FileOutputStream destinazione =newFileOutputStream(“out.dat”);
//    ObjectOutputStream utF=new ObjectOutputStream (destinazione);
//
//    FileInputStream sorgente =new FileInputStream(“in.dat”);
//    ObjectInputStream inF =new ObjectInputStream (sorgente);
    public static void main(String[] args) {

        while(true) {

            System.out.println("Seleziona l'operazione da eseguire");
            System.out.println("1) Salva");
            System.out.println("2) Leggi");
            System.out.println("3) Calcola la media");
            System.out.println("4) Calcola la massima");
            System.out.println("5) Calcola il periodo di siccita");
            System.out.println("0) Esci");

            int scelta = new java.util.Scanner(System.in).nextInt();
            switch (scelta) {
                case 0:
                    System.out.println("Chiusura in corso");
                    return;
                case 1:
                    System.out.println("Salva");
                    System.out.println("Inserisci la data di oggi nel formato gg/mm/aaaa");
                    String data = new java.util.Scanner(System.in).nextLine();
                    // create a util.Date parsing the string in the forma "dd/MM/yyyy"
                    //use the java formatter for the Format "dd/MM/yyyy"
                    Date date = null;
                    try {
                        date = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(data);
                    } catch (ParseException e) {
                        System.out.println("Formato data errato");
                        break;
                    }

                    System.out.println("DATE " + date);

                    System.out.println("Inserisci la quantita di pioggia in mm");
                    int quantita = new java.util.Scanner(System.in).nextInt();
                    Pioggia pioggia = new Pioggia(date, quantita);
                    System.out.println( " ------------ saving to file ---------------");
                    pioggia.saveToFile();
                    System.out.println( " ------------ saved to file ---------------");
                    break;
                case 2:
                    System.out.println("Leggi");
                    PioggiaStatistiche.readFromFile();
                    break;
                case 3:
                    System.out.println("Calcola la media");
                    PioggiaStatistiche.media();
                    break;
                case 4:
                    System.out.println("Calcola la massima");
                    PioggiaStatistiche.max();
                    break;
                case 5:
                    System.out.println("Calcola il periodo di siccita");
                    PioggiaStatistiche.periodoSiccita();
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }

    }
}
