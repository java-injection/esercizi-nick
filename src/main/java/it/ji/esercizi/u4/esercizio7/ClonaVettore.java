package it.ji.esercizi.u4.esercizio7;

import java.util.Vector;

public class ClonaVettore extends Vector {

//    Scrivi un metodo aggiuntivo per la classe Vector che come valore di ritorno produca una copia del
//    vettore in input, senza modificarlo, con il seguente prototipo: Vector clone(Vector).

    Vector clone(Vector vettore) {
        return new Vector(vettore); //Il costruttore di Vector già esegue una copia del contenuto del vettore in un nuovo vettore
    }

    Vector clone2(Vector vettore) {
        Vector vettoreClone = new Vector(vettore.size());
        for (int i = 0; i < vettore.size(); i++) {
            vettoreClone.add(vettore.get(i));
        }
        return vettoreClone;
    }
}
