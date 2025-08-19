package it.ji.esercizi.u4.ufficio_guasti;

import java.util.Date;

public class Intervento {

    private String descrizione;
    private Date data;
    private double costo;
    private Macchina macchina;
    private Cliente cliente;

    public Intervento(String descrizione, Date data, double costo, Macchina macchina, Cliente cliente) {
        this.descrizione = descrizione;
        this.data = data;
        this.costo = costo;
        this.macchina = macchina;
        this.cliente = cliente;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public Macchina getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Intervento [descrizione=" + descrizione + ", data=" + data + ", costo=" + costo + ", macchina=" + macchina + ", cliente=" + cliente + "]";
    }


}
