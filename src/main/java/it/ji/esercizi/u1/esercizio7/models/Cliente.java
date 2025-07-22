package it.ji.esercizi.u1.esercizio7.models;

public class Cliente {

    private String nome;
    private String cognome;
    private int telefono;

    public Cliente(String nome, String cognome, int telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cliente) {
            Cliente cliente = (Cliente) obj;
            return cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome) && cliente.getTelefono() == telefono;
        }
        return false;
    }
}
