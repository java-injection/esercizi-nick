package it.ji.esercizi.u1.esercizio7.models;

public class Prenotazione {

    private Cliente cliente;
    private int inizio;
    private int fine;

    public Prenotazione(Cliente cliente, int inizio, int fine) {
        this.cliente = cliente;
        this.inizio = inizio;
        this.fine = fine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getInizio() {
        return inizio;
    }

    public int getFine() {
        return fine;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Prenotazione [cliente=" + cliente + ", inizio=" + inizio + ", fine=" + fine + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Prenotazione) {
            Prenotazione prenotazione = (Prenotazione) obj;
            return prenotazione.getCliente().equals(cliente) && prenotazione.getInizio() == inizio && prenotazione.getFine() == fine;
        }
        return false;
    }


}
