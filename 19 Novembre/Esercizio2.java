import java.util.Scanner;

public class Esercizio2{
    public static void main(String[] args){
        
        //CREO LO SCANNER E LA CONDIZIONE
        Scanner inp = new Scanner(System.in);
        boolean cond = true;


        while (cond){

            //PRENDO IL NUMERO IN INPUT
            System.out.println("Inserisci un numero intero: ");
            int a = inp.nextInt();
            
            //CONTROLLO SE IL VALORE E' PARI O DISPARI
            if(a >= 0){
                if (a % 2 == 0){
                    System.out.println("Il numero che hai inserito è pari ed è: " + a);
                } else {
                    System.out.println("Il numero che hai inserito è dispari ed è: " + a);
                }
            } 
            //SE IL NUMERO INSERITO E' NEGATIVO INTERROMPO IL CICLO
            else if(a <0){
                cond = false;
            }
        }
        System.out.println("Fine ciclo.");
        }
    }


