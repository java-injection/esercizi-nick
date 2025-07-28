package it.ji.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cane> cani = new ArrayList<>();
        cani.add(new Volpino("Bella"));
        cani.add(new Volpino("Bella1"));
        cani.add(new PastoreTedesco("Milo"));
        cani.add(new Volpino("Bella2"));

        int numero_pastori = 0;
        String prova = "drogato";
        for (Cane cane : cani) {

            cane.verso();
            if (cane instanceof PastoreTedesco) {
                numero_pastori++;
                ((PastoreTedesco)cane).annusaMalvivente(prova);
            }

            //versione alternativa
            if (cane instanceof PastoreTedesco pt) {
                //numero_pastori++;
                pt.annusaMalvivente(prova);
            }
        }

        System.out.println("Numero di pastori tedeschi: " + numero_pastori);


    }
}
