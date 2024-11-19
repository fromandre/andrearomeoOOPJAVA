import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio4 {
    
    public static void main(String[] args){
        boolean cond = true;
        ArrayList<String> prenotazione = new ArrayList<String>();
        boolean[][] posti = matriceposti(3, 8);

        //FINCHE' LA CONDIZIONE RIMANE TRUE NON ESCE DAL CICLO
        while(cond){
            int scelta = menu();
            Scanner numero = new Scanner(System.in);
            switch (scelta){
                case 1:
                    int riga;
                    int colonna;
                    boolean cond2 = true;
                    while (cond2){
                        System.out.println("Sono disponibili 3 righe e 8 colonne.\nSeleziona la riga: ");
                        int tmp = numero.nextInt() - 1;
                        if (tmp >= 1 && tmp <= 3){
                            riga = tmp;
                            cond2 = false;
                        } else {
                            System.out.println("Riga non valida! Inserisci una riga valida.");
                        }
                    }
                    cond2 = true;
                    while (cond2){
                        System.out.println("Sono disponibili 8 colonne.\nSeleziona la colonna: ");
                        int tmp = numero.nextInt() - 1;
                        if (tmp >= 1 && tmp <= 8){
                            colonna = tmp;
                            cond2 = false;
                        } else {
                            System.out.println("Colonna non valida! Inserisci una colonna valida.");
                        }
                    }

                    

                    






                case 5:
                    System.out.println("\n Arrivederci!");
                    cond = false;
                    break;
                default:
                    break;
            }


        }
        }


        public static int menu(){
            Scanner scelta = new Scanner(System.in);
            System.out.println("Menù di selezione: \n 1 - Prenota un posto. \n 2 - Cerca una prenotazione \n 3 - Visualizza i prodotti liberi. \n 4 - Percentuale posti prenotati. \n 5 - Chiudi il programma.");
            int tmp = scelta.nextInt();
            return tmp;
        }

        public static boolean[][] matriceposti(int righe, int colonne){
            boolean[][] posti = new boolean[righe][colonne];
            for (int i=0;i<posti.length;++i){
                for(int j=0;j<posti[i].length;++j){
                    posti[i][j] = true;
                    System.out.println(posti[i][j]);
                }
            }
            return posti;
        }
}
