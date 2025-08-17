package it.ji.esercizi.u4.esercizio4;


import java.util.Scanner;
import java.util.Vector;

//Scrivi un programma che legga in input una sequenza di numeri terminanti con uno 0. Successivamente
//scrivi una funzione che analizza il vettore e restituisce il valore true se ciascun elemento è presente
//almeno due volte.
public class NumeriTerminantiCon0 {
//eccomi
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci una sequenza di numeri terminanti con 0: , digitare -1 per terminare");
        Vector<Integer> vettore = new Vector<>();
        while(true){
            int num = in.nextInt();
            if(num == -1){
                break;
            }
            if(num % 10 != 0){
                System.out.println("Numero errato: non termina con 0");
                continue;
            }
            vettore.add(num);
            //10 30 50 10 50 70 40 40 30 80 90 10
            //    i
            // j
        }

        boolean vettoreOK = true;
        // VERIFICA DEL VETTORE facciamola qui
        for(int i = 0; i < vettore.size(); i++){
            int numeroDaVerificare = vettore.get(i);
            for(int j = i + 1; j < vettore.size(); j++) {
                if(j != i && vettore.get(j) == numeroDaVerificare){
                    System.out.println("Ok il numero " + numeroDaVerificare + " si ripete");
                    break;
                }
            }
            vettoreOK = false;
            break;
        }


        if(vettoreOK){
            System.out.println("Il vettore è ok");
        }else{
            System.out.println("Il vettore non è ok");
        }
    }//meglio, ti cchiamo io


}
