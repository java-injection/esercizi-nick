package it.ji.inheritance;

public class PastoreTedesco extends Cane{

    public PastoreTedesco(String nome) {
        super(nome, "Pastore Tedesco");
    }

    public void verso(){
        System.out.println("BAU BAU IN TEDESCO");
    }

    public boolean annusaMalvivente(String malvivente) {
        if("drogato".equals(malvivente)) {
            return true;
        } else {
            return false;
        }
    }


}
