package it.ji.inheritance;

//1. una volta che una classe è astratta, non puo essere istanziata
//2. se una classe astratta ha dei metodi astratti, la classe che la estende deve implementarli
public abstract class Animale {

    private String nome;
    private String razza;
    private int numeroZampe;

    public Animale() {}

    public Animale(String nome) {
        this.nome = nome;
        this.numeroZampe = 0;
        this.razza = "sconosciuto";
    }

    public Animale(String nome, int numeroZampe) {
        this.nome = nome;
        this.numeroZampe = numeroZampe;
        this.razza = "sconosciuto";
    }

    public Animale(String nome, int numeroZampe, String razza) {
        this.nome = nome;
        this.numeroZampe = numeroZampe;
        this.razza = razza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroZampe() {
        return numeroZampe;
    }

    public void setNumeroZampe(int numeroZampe) {
        this.numeroZampe = numeroZampe;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public abstract void verso();
}