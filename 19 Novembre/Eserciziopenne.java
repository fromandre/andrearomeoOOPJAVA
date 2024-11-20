import java.util.ArrayList;
import java.util.Scanner;

public class Eserciziopenne{
    
    public static void main(String[] args){
            ArrayList<ArrayList<Integer>> ship = inizializzasistema();
            boolean flag = true;
            while(flag){
                int scelta = menu();
                switch (scelta){
                    case 1:
                        aggiungispedizione(ship);
                        break;
                    case 2:
                        mostraspedizioni(ship);
                        break;
                    case 3:
                        totalecolore(ship);
                        break;
                    case 4:
                        cercaspedizione(ship);
                        break;
                    case 5:
                        System.out.println("\nArrivederci!");
                        flag = false;
                        break;
                    default:
                        System.out.println("\nScelta non valida! Si prega di scegliere una funzione valida.");
                        break;
                }
            }
        }   

            //Inizializzo le liste relative ad ogni tipo di penna e la lista spedizioni che contiene le liste di ogni penna
        public static ArrayList<ArrayList<Integer>> inizializzasistema(){
            ArrayList<Integer> rosso = new ArrayList<Integer>();
            ArrayList<Integer> verde = new ArrayList<Integer>();
            ArrayList<Integer> blu = new ArrayList<Integer>();
            ArrayList<Integer> nero = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
            spedizioni.add(rosso);
            spedizioni.add(verde);
            spedizioni.add(blu);
            spedizioni.add(nero);
            return spedizioni;
        }


            //Funzione che stampa una determinata spedizione basandosi sul valore di un indice
        public static void printsped(int i, ArrayList<ArrayList<Integer>> sped){
            System.out.println("\n Spedizione numero "+i+"\nNumero penne rosse: "+sped.get(0).get(i)+"\nNumero penne verdi: "+sped.get(1).get(i)+"\nNumero penne blu: "+sped.get(2).get(i)+"\nNumero penne nere: "+sped.get(3).get(i));
        }

            //Funzione che controlla che il valore di un intero sia compreso fra 0 e 100
        public static boolean checkadd(int a){
            if (a >= 0 || a <= 100){
                return true;
            } else {
                return false;
            }
        }

            //Funzione che permette l'aggiunta di una spedizione con una quantità di penne per ogni colore
        public static void aggiungispedizione(ArrayList<ArrayList<Integer>> sped){
            Scanner penne = new Scanner(System.in);
            int tmp;
            
            //Richiama la funzione checkadd() per effettuare un controllo sull'input
            System.out.println("Inserisci la quantità di penne rosse da ordinare: ");
            tmp = penne.nextInt();
            if (checkadd(tmp)){
                sped.get(0).add(tmp);
            } else {
                System.out.println("Il valore che hai inserito non è valido!");
                return;
            }
            System.out.println("Inserisci la quantità di penne verdi da ordinare: ");
            tmp = penne.nextInt();
            if (checkadd(tmp)){
                sped.get(1).add(tmp);
            } else  {
                System.out.println("Il valore che hai inserito non è valido!");
                return;
            }
            System.out.println("Inserisci la quantità di penne blu da ordinare: ");
            tmp = penne.nextInt();
            if (checkadd(tmp)){
                sped.get(2).add(tmp);
            } else  {
                System.out.println("Il valore che hai inserito non è valido!");
                return;
            }
            System.out.println("Inserisci la quantità di penne nere da ordinare: ");
            tmp = penne.nextInt();
            if (checkadd(tmp)){
                sped.get(3).add(tmp);
            } else  {
                System.out.println("Il valore che hai inserito non è valido!");
                return;
            }
        }

            //Funzione che mostra il totale delle penne spedite divise per colore
        public static void mostraspedizioni(ArrayList<ArrayList<Integer>> sped){
            int lung = sped.get(0).size();
            for (int i=0; i<lung; ++i){
                printsped(i, sped);
            }
        }

            //Funzione che stampa il totale delle penne spedite di un determinato colore
        public static void totalecolore(ArrayList<ArrayList<Integer>> sped){
            int lung, sum;
            Scanner colore = new Scanner(System.in);
            System.out.println("\nCalcolo totale delle penne spedite.\nSeleziona il colore:\n");
            String col = colore.nextLine();
            col = col.toLowerCase();
            switch(col){
                case "rosso":
                    sum = 0;
                    lung = sped.get(0).size();
                    for (int i=0;i<lung;++i){
                        sum += sped.get(0).get(i);
                    }
                    System.out.println("\nIl numero totale di penne rosse ordinate è: " + sum);
                    break;
                case "verde":
                    sum = 0;
                    lung = sped.get(1).size();
                    for (int i=0;i<lung;++i){
                        sum += sped.get(1).get(i);
                    }
                    System.out.println("\nIl numero totale di penne verdi ordinate è: " + sum);
                    break;
                case "blu":
                    sum = 0;
                    lung = sped.get(2).size();
                    for (int i=0;i<lung;++i){
                        sum += sped.get(2).get(i);
                    }
                    System.out.println("\nIl numero totale di penne blu ordinate è: " + sum);
                    break;
                case "nero":
                    sum = 0;
                    lung = sped.get(3).size();
                    for (int i=0;i<lung;++i){
                        sum += sped.get(3).get(i);
                    }
                    System.out.println("\nIl numero totale di penne nere ordinate è: " + sum);
                    break;
                default:
                    System.out.println("Il colore inserito non è disponibile o errato!");
                    break;
                }
        }

            //Funzione che cerca all'interno dell'ArrayList di un determinato colore la prima spedizione che ha almeno un valore maggiore di 0
        public static boolean checkcolore(int indice, ArrayList<ArrayList<Integer>> sped){
            for(int i=0; i<=sped.get(indice).size(); ++i){
                if (sped.get(0).get(i) >= 1){
                    System.out.println("\nLa prima spedizione che ha almeno una penna del colore richiesto: ");
                    printsped(i, sped);
                    return true;
                }
            }
            return false;
        }

            //Funzione che in base al colore scelto dall'utente cerca la prima spedizione con valore maggiore di 0 di quel colore
        public static void cercaspedizione(ArrayList<ArrayList<Integer>> sped){
            Scanner colore = new Scanner(System.in);
            System.out.println("\nCalcolo totale delle penne spedite.\nSeleziona il colore:\n");
            String col = "";
            col = colore.nextLine();
            col = col.toLowerCase();
            int ind;
            boolean flag;
            switch(col){
                case "rosso":
                        ind = 0;
                        flag = checkcolore(ind, sped);
                        if (!flag){
                            System.out.println("\nNessun risultato alla ricerca!");
                            
                        }
                        break;
                case "verde":
                        ind = 1;
                        flag = checkcolore(ind, sped);
                        if(!flag){
                            System.out.println("\nNessun risultato alla ricerca!");
                           
                        }
                        break;
                case "blu":
                        ind = 2;
                        flag = checkcolore(ind, sped);
                        if(!flag){
                            System.out.println("\nNessun risultato alla ricerca!");
                        }
                        break;
                case "nero":
                        ind = 3;
                        flag = checkcolore(ind, sped);
                        if(!flag){
                            System.out.println("\nNessun risultato alla ricerca!");
                        }
                        break;
                default:
                        System.out.println("Il colore ricercato non è disponibile o è stato inserito in modo errato.");
                        break;
                    }


            }


            //Metodo che gestisce il meccanismo del menù utente.
        public static int menu(){
            Scanner scelta = new Scanner(System.in);
            System.out.println("\nMenù di selezione: \n 1 - Aggiungi una spedizione. \n 2 - Mostra tutte le spedizioni. \n 3 - Calcola il totale di penne spedite di un colore. \n 4 - Stampa la prima spedizione con una quantità minima di penne ordinate. \n 5 - Chiudi il programma.");
            int tmp = scelta.nextInt();
            return tmp;
        }
        
    }

    
