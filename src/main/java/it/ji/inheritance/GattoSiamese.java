package it.ji.inheritance;

public class GattoSiamese extends Animale{

    public GattoSiamese(String nome) {
        super(nome, 4, "Gatto Siamese");
    }

    public void verso() {
        System.out.println("MIAO in SIAMESE");
    }

}
