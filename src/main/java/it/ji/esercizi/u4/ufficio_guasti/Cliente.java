package it.ji.esercizi.u4.ufficio_guasti;

public class Cliente {
    private String nome;
    private String cognome;

    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cliente) {
            Cliente cliente = (Cliente) obj;
            return cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome);
        }
        return false;
    }

}
