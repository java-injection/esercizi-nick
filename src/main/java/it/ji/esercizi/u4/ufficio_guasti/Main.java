package it.ji.esercizi.u4.ufficio_guasti;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    L’ufficio guasti di un’azienda riceve un certo numero di richieste di intervento al giorno, che devono
//    essere soddisfatte in ordine di data di arrivo. Realizza un programma che consenta all’operatore di
//    memorizzare tali richieste secondo l’ordine di arrivo, archiviando i dati necessari per il tecnico che
//    dovrà eseguire l’intervento.
    public static void main(String[] args) {

        List<Intervento> interventi = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("Ufficio Guasti");
        System.out.println("1 ) Inserisci richiesta di intervento");
        System.out.println("2 ) Visualizza richieste di intervento");
        System.out.println("3 ) Esci");
        System.out.println("================================");
        System.out.println("Inserisci il numero di richieste di interventi: ");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Inserisci il nome del cliente: ");
                String nome = sc.next();
                System.out.println("Inserisci il cognome del cliente: ");
                String cognome = sc.next();
                System.out.println("Inserisci la descrizione del problema: ");
                String descrizione = sc.next();
                System.out.println("Inserisci la marca della macchina: ");
                String marca = sc.next();
                System.out.println("Inserisci il modello della macchina: ");
                String modello = sc.next();
                System.out.println("Inserisci l'anno della macchina: ");
                int anno = sc.nextInt();
                System.out.println("Inserisci il preventivo: ");
                double preventivo = sc.nextDouble();
                Macchina macchina = new Macchina(marca, modello, anno);
                Cliente cliente = new Cliente(nome, cognome);
                Intervento intervento = new Intervento(
                        descrizione,
                        new java.util.Date(),
                        preventivo,
                        macchina,
                        cliente);
                interventi.add(intervento); //aggiungiamo l'intervento alla lista

                break;
            case 2:
                System.out.println("-------------- ELENCO INTERVENTI --------------");
                for (Intervento i : interventi) {
                    System.out.println(i);
                }
                break;
            case 3:
                System.out.println("Chiusura in corso...");
                System.exit(0);
                break;
            default:
                break;
        }

    }
}
