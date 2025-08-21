package it.ji.matrici;

public class MatriciRipasso {

    public static void main(String[] args) {

        int [][] matrice = {
                {-1,2,3},
                {4,5,-6},
                {7,8,9}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + " | ");
            }
            System.out.println();
        }

        int counterNegativi = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(matrice[i][j] < 0){
                    counterNegativi++;
                }
            }
        }

        int rigaSelezionata = 1;

        for (int j = 0; j < 3; j++) {
            if(matrice[rigaSelezionata][j] < 0){
                counterNegativi++;
            }
        }

        //stampare la diagonale
        for (int i = 0; i < 3; i++) {
            System.out.println(matrice[i][i]);
        }

    }
}
