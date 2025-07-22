package it.ji.equals;

public class Gatto {

    private String nome;
    private String razza;

    public Gatto(String nome, String razza) {
        this.nome = nome;
        this.razza = razza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Stessi riferimenti
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Oggetto nullo o di tipo diverso
        }

        Gatto gatto = (Gatto) obj;
        return nome.equals(gatto.nome) && razza.equals(gatto.razza); // Confronto dei campi
    }
}
