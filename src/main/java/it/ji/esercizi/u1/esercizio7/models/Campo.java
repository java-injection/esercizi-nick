package it.ji.esercizi.u1.esercizio7.models;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private String nome;
    private int id;
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    public Campo(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void addPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    //metodo equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Campo) {
            Campo campo = (Campo) obj;
            return campo.getId() == id && campo.getNome().equals(nome);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Campo{" + "nome=" + nome + ", id=" + id + ", prenotazioni=" + prenotazioni + '}';
    }





}
