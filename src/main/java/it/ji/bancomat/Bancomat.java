package it.ji.bancomat;


import java.util.Scanner;

public class Bancomat {
    public static void main(String[] args) {
        Banca banca = new Banca();
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Benvenuto al Bancomat");
        while(true) {
            System.out.println("1) inserisci carta");
            System.out.println("2) esci");
            System.out.println("-------------------------");
            int scelta = in.nextInt();
            switch (scelta) {
                default:
                    System.out.println("Scelta non valida");
                case 1:
                    System.out.println("Inserisci il codice della carta");
                    String codice = in.nextLine();
                    Carta carta = banca.getCardByCode(codice);
                    if(carta == null) {
                        System.out.println("Carta non trovata");
                        break;
                    }else{
                        System.out.println("Inserisci il pin della carta");
                        int pin = in.nextInt();
                        if (pin == carta.getPin()) {
                            System.out.println("Benvenuto " + carta.getNome() + " " + carta.getCognome());
                            boolean consultazioneCarta = true;
                            while (consultazioneCarta) {
                                System.out.println("1) Deposito");
                                System.out.println("2) Preleva");
                                System.out.println("3) Saldo");
                                System.out.println("4) Esci");
                                int scelta2 = in.nextInt();
                                switch (scelta2) {
                                    case 1:
                                        System.out.println("Inserisci l'importo da depositare");
                                        float importo = in.nextFloat();
                                        carta.setSaldo(carta.getSaldo() + importo);
                                        break;
                                    case 2:
                                        System.out.println("Inserisci l'importo da prelevare");
                                        importo = in.nextFloat();
                                        if (carta.getSaldo() >= importo) {
                                            carta.setSaldo(carta.getSaldo() - importo);
                                        } else {
                                            System.out.println("Saldo insufficiente");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Saldo attuale:" + carta.getSaldo());
                                        break;
                                    case 4:
                                        System.out.println("Chiusura in corso...");
                                        consultazioneCarta = false;
                                        break;
                                    default:
                                        System.out.println("Scelta non valida");
                                }
                            }
                        } else {
                            System.out.println("Pin errato");
                        }
                    }

                    break;
                case 2:
                    System.out.println("Chiusura in corso...");
                    return;

            }
        }
     /*
        Quando si accede al bancomat compare un menù con le seguenti opzioni:
1) Inserisci Carta
2) Esci
-------------------------
Se l'utente seleziona 1: Si chiede di inserire un codice numerico di 8 cifre e poi il PIN  relativo.
        I dati di ogni utente sono immagazzinati in un array di dimensione 4 di tipo User. User è una
        lista che contiene il codice della carta, il relativo pin di 4 cifre numerico, il nome e cognome dell'utente
        e il saldo attuale. Se il codice della carta da 8 cifre non è presente nell'array, si deve dare un messaggio di
        errore e il programma deve ripresentare il menù iniziale. Se invece esiste, si deve chiedere il PIN che deve
        corrispondere. Se non corrisponde si deve dire che il pin è errato e si ritorna al menù iniziale. Se Codice
        carta e Pin corrispondo comparirà un sottomenù così fatto:
    1) Visualizza Saldo
    2) Preleva
    3) Ultimi 3 movimenti
    4) Indietro.
    ------------------
    Se l'utente seleziona 1: Viene visualizzato il saldo corrispondente con un messaggio che include il nome e cognome
        dell'utente
    Se l'utente seleziona 2: Viene chiesto l'importo da prelevare. Se l'importo è disponibile si manda un messaggio
        di feedback e si aggiorna il saldo. Successivamente si ritorna il menù secondario.
    Se l'utente seleziona 3: Si mostrano gli ultimi 3 prelievi effettuati in ordine temporale dal più recente al
        meno recente.
    Se l'utente seleziona 4: Si ritorna al menù primario, scollegando i dati dell'utente.
Se l'utente seleziona 0: Si Esce dal programma
        */
    }

}
