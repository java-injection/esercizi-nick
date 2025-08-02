package it.ji.bancomat;
import java.util.ArrayList;
import java.util.List;

public class Banca{
    private List<Carta> carte = new ArrayList<>();

    public Banca() {
    }
    private void init (){
        carte.add(new Carta("IT123456", 16744, "Nicolò", "Vecchio", 0.74f));
        carte.add(new Carta("IT67890", 13224, "Luca", "esistenteatratti", 11.01f));
    }
    public boolean codiceEsiste (String codice){
        for(int i=0;i<carte.size();i++){
            if (codice.equals(carte.get(i).getCodiceCarta())){
                return true;
            }
        }
        return false;
    }
}
