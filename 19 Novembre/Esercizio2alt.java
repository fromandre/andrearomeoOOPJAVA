import java.util.Arrays;
import java.util.Scanner;

public class Esercizio2alt{
    public static void main(String[] args){
        
        //CREO SCANNER E CONDIZIONE
        Scanner inp = new Scanner(System.in);
        boolean cond = true;

        //FINCHE' LA CONDIZIONE RIMANE TRUE NON ESCE DAL CICLO
        while(cond){

            //ALL'INIZIO DI OGNI CICLO WHILE RICREO L'ARRAY E IL VALORE DELLA SOMMA
            int[] numeri = new int[5];
            int sum = 0;

            //CHIEDO TANTI INPUT QUANTO LA DIMENSIONE DELL'ARRAY
            for(int i=0; i<numeri.length; i++){
                System.out.println("Inserisci un numero: ");
                int tmp = inp.nextInt();
                numeri[i] = tmp;
                sum += tmp;
                if (tmp < 0) break;

            }
            
            //SE LA SOMMA E' POSITIVA FACCIO RIPARTIRE IL CICLO ALTRIMENTI STAMPO LA SOMMA E L'ARRAY
            if (sum >= 0){
                System.out.println("Erorre! La somma è positiva.");
            } else {
                System.out.println("La somma è negativa: " + sum + " l'array di numeri inseriti è: " + Arrays.toString(numeri));
                cond = false;
            }
        }
        }
    }


