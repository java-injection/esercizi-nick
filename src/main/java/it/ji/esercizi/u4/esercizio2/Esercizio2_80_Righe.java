package it.ji.esercizi.u4.esercizio2;

import java.util.Vector;

//Scrivi un programma che legga un testo costituito da un numero indefinito di righe
// (ciascuna composta
// da 80 caratteri) una alla volta, inserisca ciascuna riga in uno stack e poi vuoti
// lo stack trasferendo le righe una per una in un secondo stack. Lo stack sarà poi vuotato,
// trasferendo le righe in uscita nello stesso ordine nel quale sono state lette.
// Il programma di prova verifica anche che le funzioni testa e poprichiamate su uno stack vuoto producano un’eccezione.
public class Esercizio2_80_Righe {

    public static void main(String[] args) {
        String text = """
                Riga 1 lsadasdjiand asdasdasidjaskdnaskdnas
                Riga 2 lsadasdjiand asdasdasidjaskdnaskdnas
                Riga 3 lsadasdjiand asdasdasidjaskdnaskdnas
                """;
        Stack stack = new Stack();
        int lunghezzaTesto = text.length();
        boolean continua = true;
        while(continua){
            int currentLength = 0;
            char [] riga = new char[80];
            for (int i = 0; i < 80; i++) {
                riga[i] = text.charAt(i);
                currentLength++;
                if(currentLength == lunghezzaTesto){
                    continua = false;
                    break;
                }
            }
            stack.push(riga);

        }

        Stack stack2 = new Stack();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }

        //  G
        //  H
        //  F

        // G, H , F

       // Lo stack sarà poi vuotato,
        // trasferendo le righe in uscita nello stesso ordine nel quale sono state lette
        // 1 ) svuotare lo stack e accumulare le righe in una lista di righe
        // 2 ) ciclare la lista di righe e inserirle dalla prima a l'ultima nello stack di nuovo
        Vector<char[]> righe = new Vector<>();
        while(!stack2.isEmpty()){
            righe.add(stack2.pop());
        }
        for(char[] r : righe){
            stack2.push(r);
        }


    }

}
