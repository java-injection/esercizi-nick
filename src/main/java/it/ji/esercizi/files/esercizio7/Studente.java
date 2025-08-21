package it.ji.esercizi.files.esercizio7;

public class Studente {
    private int matricola;
    private String cognome;
    private String nome;
    private int voto;
    private String giudizio; // "ammesso" oppure  "non ammesso"  o "" (vuoto)

    public Studente(int matricola, String cognome, String nome, int voto, String giudizio) {
        this.matricola = matricola;
        this.cognome = cognome;
        this.nome = nome;
        this.voto = voto;
        this.giudizio = giudizio;
    }

    public Studente(int matricola, String cognome, String nome, int voto) {
        this(matricola, cognome, nome, voto, "");
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getGiudizio() {
        return giudizio;
    }

    public void setGiudizio(String giudizio) {
        this.giudizio = giudizio;
    }

    public String getNomeCompleto() {
        return cognome + " " + nome;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", voto=" + voto +
                ", giudizio='" + giudizio + '\'' +
                '}';
    }
}
