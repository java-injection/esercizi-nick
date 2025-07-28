package it.ji.esercizi.u1.esercizio7.models;

import it.ji.esercizi.u1.esercizio7.exceptions.CampoNotFoundException;
import it.ji.esercizi.u1.esercizio7.exceptions.ConflictReservationException;
import it.ji.esercizi.u1.esercizio7.exceptions.WrongReservationParamsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TennisManager {
    private String nome;
    private List<Campo> campi = new ArrayList<>();
    private Map<String, Cliente> clienti = new HashMap<>();
    private List<Prenotazione> prenotazioni = new ArrayList<>();
    public static final int ORARIO_APERTURA = 8;
    public static final int ORARIO_CHIUSURA = 22;


    //la mappa ha 2 parametri generici: chiave e valore
    //Map<K, V> -> chiave, valore

    public TennisManager(String nome) {
        this.nome = nome;
    }

    public boolean isClientExisting(String telefono) {
        return clienti.containsKey(telefono);
    }

    public void addCliente(Cliente cliente) {
        clienti.put(cliente.getTelefono(), cliente);
        //il metodo put di una mappa prende 2 argomenti, il primo è la chiave e il secondo è il valore
    }

    public Cliente getClienteByTelefono(String telefono) {
        return clienti.get(telefono);
    }

    public String getNome() {
        return nome;
    }

    public void addCampo(Campo campo) {
        campi.add(campo);
    }

    // VARARGS
    public void addCampo(Campo ... campi) {
        for (Campo campo : campi) {
            this.campi.add(campo);
        }
    }

    public List<Campo> getCampi() {
        return campi;
    }

    public Campo getCampoById(int id) throws CampoNotFoundException {
        for (Campo campo : campi) {
            if (campo.getId() == id) {
                return campo;
            }
        }
        throw new CampoNotFoundException(id);
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void addPrenotazione(Prenotazione prenotazione) throws WrongReservationParamsException,ConflictReservationException {
        int oraInizio = prenotazione.getInizio();
        int oraFine = prenotazione.getFine();
        if(oraInizio < ORARIO_APERTURA || oraFine > ORARIO_CHIUSURA || oraFine < ORARIO_APERTURA+1 || oraInizio > oraFine) {
            throw new WrongReservationParamsException("Prenotazione non valida: parametri errati, verificare");
        }

        if(prenotazioni.isEmpty()) {
            prenotazioni.add(prenotazione);
        }else{
            for(Prenotazione pe : prenotazioni) {
                if(!pe.getCampo().equals(prenotazione.getCampo())) {
                    continue;
                }
                if(oraInizio >= pe.getInizio() && oraInizio <= pe.getFine() ||
                        oraFine >= pe.getInizio() && oraFine <= pe.getFine()) {
                    throw new ConflictReservationException("Prenotazione rifiutata perché in conflitto con altre prenotazioni");
                }
            }
            prenotazioni.add(prenotazione);
        }

    }
}
