package it.ji.esercizi.u1.esercizio7;

import it.ji.esercizi.u1.esercizio7.exceptions.CampoNotFoundException;
import it.ji.esercizi.u1.esercizio7.models.Campo;
import it.ji.esercizi.u1.esercizio7.models.Cliente;
import it.ji.esercizi.u1.esercizio7.models.TennisManager;

/*
 Definisci una classe Prenotazione (di un campo da tennis) contenente il nome del cliente e l’ora
 della sua prenotazione; a tal fine implementa una classe Campo in cui ci siano i seguenti metodi:
   – public boolean addPren(int inizio, int fine, String unNomeCliente), per prenotare il campo, che
 controlla se i dati inseriti sono giusti e se il campo è disponibile e, quindi, salva la prenotazione e
 restituisce true se il campo è stato prenotato;
   – public boolean removePren (int inizio, int fine, String unNomeCliente), per cancellare una preno
tazione, che controlla se il campo è stato prenotato dal cliente che vuole cancellare la prenotazione
 e, quindi, la cancella e restituisce true se la prenotazione è stata cancellata;
   – public double utilizzo(), per trovare la percentuale di utilizzo del campo.
*/
public class Main {

    private static TennisManager init() {
        TennisManager tennisManager = new TennisManager("Tennis Italia");
        tennisManager.addCampo(
                new Campo("campo1", 1),
                new Campo("campo2", 2),
                new Campo("campo speciale", 3)
        );
        return tennisManager;
    }

    public static void main(String[] args) {

        TennisManager tennisManager = init();
        System.out.println("Esercizio 7");
        while (true) {
            System.out.println("Scegli cosa fare:");
            System.out.println("1) Prenota un campo");
            System.out.println("2) Rimuovi una prenotazione");
            System.out.println("3) Visualizza l'utilizzo del campo");
            System.out.println("0) Esci");
            int scelta = new java.util.Scanner(System.in).nextInt();
            switch (scelta) {
                case 0:
                    System.out.println("Chiusura in corso...");
                    return;
                case 1:
                     // 1 inserire il numero di telefono del cliente
                    System.out.println("Inserisci il numero di telefono del cliente:");
                    String telefono = new java.util.Scanner(System.in).nextLine();
                    Cliente cliente = null;
                    if(tennisManager.isClientExisting(telefono)){
                        cliente = tennisManager.getClienteByTelefono(telefono);
                    }else {
                        System.out.println("Inserisci il nome del cliente:");
                        String nome = new java.util.Scanner(System.in).nextLine();
                        System.out.println("Inserisci il cognome del cliente:");
                        String cognome = new java.util.Scanner(System.in).nextLine();
                        cliente = new Cliente(nome, cognome, telefono);
                        tennisManager.addCliente(cliente);
                    }
                    System.out.println("Il cliente selezionato e':");
                    System.out.println("Nome: \t\t\t" + cliente.getNome());
                    System.out.println("Cognome: \t\t" + cliente.getCognome());
                    System.out.println("Telefono: \t\t" + cliente.getTelefono());
                    System.out.println("------------------------------------");

                    //  2 mostriamo l'elenco dei campi disponibili
                    System.out.println("Elenco dei campi disponibili:");
                    for (Campo campo : tennisManager.getCampi()) {
                        System.out.println(campo.getId() + ") " + campo.getNome());
                    }

                    //  3 chiediamo all'utente di scegliere il campo da prenotare

                    System.out.println("Scegli il campo da prenotare:");
                    int campoId = new java.util.Scanner(System.in).nextInt();
                    Campo campo = null;
                    try {
                        campo = tennisManager.getCampoById(campoId);
                    } catch (CampoNotFoundException e) {
                        //TODO da implementare bene la gestione dell'eccezione
                        throw new RuntimeException(e);
                    }
                    System.out.println("Hai scelto il campo: " + campo.getNome());




                    //  4 chiediamo all'utente di inserire l'ora di inizio e di fine

                    // 5 verificare che il campo sia disponibile rispetto all'ora di inizio e di fine
                    // 6 se il campo non è disponibile, mostriamo un messaggio di errore
                    // 7 se il campo è disponibile, mostriamo un messaggio di conferma e prenotiamo il campo


                    System.out.println("Inserisci l'ora di inizio:");
                    int inizio = new java.util.Scanner(System.in).nextInt();
                    System.out.println("Inserisci l'ora di fine:");
                    int fine = new java.util.Scanner(System.in).nextInt();
                    System.out.println("Prenotazione effettuata!");
                default:
                    System.out.println("Il numero selezionato non è presente");
                    break;
            }

        }
    }

}
