/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.ji.esercizi.u1.esercizio5;

/**
 Definisci una classe Libro contenente i seguenti attributi: nome del libro, prezzo, numero di scaffale,
 numero di pagine, casa editrice.
 */
public class Libro {
    private String nome;
    private float prezzo;
    private int scaffale;
    private int pagine;
    private String casaEditrice;

    public Libro(String nome, float prezzo, int scaffale, int pagine, String casaEditrice) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.scaffale = scaffale;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getScaffale() {
        return scaffale;
    }

    public void setScaffale(int scaffale) {
        this.scaffale = scaffale;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    @Override
    public String toString() {
        return "Libro{" + "nome=" + nome + ", prezzo=" + prezzo + ", scaffale=" + scaffale + ", pagine=" + pagine + ", casaEditrice=" + casaEditrice + '}';
    }
   /*
    Definisci una classe Libro contenente i seguenti attributi: nome del libro, prezzo, numero di scaffale,
 numero di pagine, casa editrice.
   Definisci inoltre i metodi inizializza(), stampa(), applicaSconto(), che hanno i seguenti compiti:
   – inizializzare i campi dati dell’oggetto classe;
   – stampare tutti i dati dell’oggetto;
   – diminuire del x% il prezzo del libro in oggetto.
    */ 
    public void applicaSconto(float x){
     prezzo = prezzo - (prezzo / 100 * x);
     prezzo = Math.round(prezzo); // arrotonda a due decimali
    }
    // gli altri metodi sono già presenti (costrutore e tostring)
}
