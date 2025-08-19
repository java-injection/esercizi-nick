package it.ji.esercizi.u4.ufficio_guasti;

public class Macchina {
    private String marca;
    private String modello;
    private int anno;

    public Macchina(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String toString() {
        return marca + " " + modello + " " + anno;
    }
}
