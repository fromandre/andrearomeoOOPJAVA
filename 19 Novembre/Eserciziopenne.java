import java.util.ArrayList;
import java.util.Scanner;

public class Eserciziopenne{
    
    public static void main(String[] args){
            ArrayList<ArrayList<Integer>> ship = inizializzasistema();
            //INSERISCO 3 SPEDIZIONI 
            aggiungispedizione(ship);
            aggiungispedizione(ship);
            aggiungispedizione(ship);

            //MOSTRO A SCHERMO TUTTE LE SPEDIZIONI INSERITE
            mostraspedizioni(ship);


            //CALCOLO IL TOTALE DELLE PENNE SPEDITE SCEGLIENDO PER COLORE
            totalecolore(ship);


            //MOSTRO LA PRIMA SPEDIZIONE CON ALMENO UNA PENNA DI QUEL COLORE
            cercaspedizione(ship);


        }   

   
        public static ArrayList<ArrayList<Integer>> inizializzasistema(){
            //Inizializzo le liste relative ad ogni tipo di penna e la lista spedizioni che contiene le liste di ogni penna
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

        public static void aggiungispedizione(ArrayList<ArrayList<Integer>> sped){
            Scanner penne = new Scanner(System.in);
            int tmp;
            System.out.println("Inserisci la quantità di penne rosse da ordinare: ");
            tmp = penne.nextInt();
            sped.get(0).add(tmp);
            System.out.println("Inserisci la quantità di penne verdi da ordinare: ");
            tmp = penne.nextInt();
            sped.get(1).add(tmp);
            System.out.println("Inserisci la quantità di penne blu da ordinare: ");
            tmp = penne.nextInt();
            sped.get(2).add(tmp);
            System.out.println("Inserisci la quantità di penne nere da ordinare: ");
            tmp = penne.nextInt();
            sped.get(3).add(tmp);
        }

        public static void mostraspedizioni(ArrayList<ArrayList<Integer>> sped){
            int lung = sped.get(0).size();
            for (int i=0; i<lung; ++i){
                System.out.println("\n Spedizione numero "+i+"\nNumero penne rosse: "+sped.get(0).get(i)+"\nNumero penne verdi: "+sped.get(1).get(i)+"\nNumero penne blu: "+sped.get(2).get(i)+"\nNumero penne nere: "+sped.get(3).get(i));
            }
        }

        public static void printsped(int i, ArrayList<ArrayList<Integer>> sped){
            System.out.println("\n Spedizione numero "+i+"\nNumero penne rosse: "+sped.get(0).get(i)+"\nNumero penne verdi: "+sped.get(1).get(i)+"\nNumero penne blu: "+sped.get(2).get(i)+"\nNumero penne nere: "+sped.get(3).get(i));
        }

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

        public static boolean checkcolore(int indice, ArrayList<ArrayList<Integer>> sped){
            for(int i=0; i<sped.get(indice).size(); ++i){
                if (sped.get(0).get(i) > 0){
                    System.out.println("\nLa prima spedizione che ha almeno una penna del colore richiesto: ");
                    printsped(i, sped);
                    return true;
                }
            }
            return false;
        }

        public static void cercaspedizione(ArrayList<ArrayList<Integer>> sped){
            Scanner colore = new Scanner(System.in);
            System.out.println("\nCalcolo totale delle penne spedite.\nSeleziona il colore:\n");
            String col = colore.nextLine();
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
        }

    
