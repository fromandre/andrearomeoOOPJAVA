import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio4 {
    
    public static void main(String[] args){
        boolean cond = true;
        ArrayList<String> prenotazione = new ArrayList<String>();
        //ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        boolean[][] posti = matriceposti(3, 8);

        //FINCHE' LA CONDIZIONE RIMANE TRUE NON ESCE DAL CICLO
        while(cond){
            int scelta = menu();
            Scanner numero = new Scanner(System.in);
            Scanner stringa = new Scanner(System.in);
            switch (scelta){

                case 1:
                    int riga;
                    int colonna;
                    String nome;
                    boolean cond2 = true;

                    //Chiedo riga, colonna e nome in input
                    System.out.println("Ci sono 3 righe e 8 colonne.\nInserisci numero della riga: ");
                    riga = numero.nextInt();

                    //Verifico che la riga sia valida
                    if (riga < 1 || riga > 3){
                        System.out.println("Riga non valida!");
                        break;
                    }
                    System.out.println("Inserisci numero colonna: ");
                    colonna = numero.nextInt();

                    //Verifico che la colonna sia valida
                    if (colonna < 1 || colonna > 8){
                        System.out.println("Colonna non valida!");
                        break;
                    }

                    if (posti[riga-1][colonna-1] == false){
                        System.out.println("Il posto inserito e' già occupato!");
                    } else {
                        //Inserire nome
                        System.out.println("Inserisci un nome: ");
                        nome = stringa.nextLine();

                        //Segno il posto come occupato
                        posti[riga-1][colonna-1] = false;
                        String tmpprenot = nome + " " + riga + " " + colonna;
                        prenotazione.add(tmpprenot);    
                    }
                    break;
                case 2:
                    
                    ArrayList<String> risultato = new ArrayList<String>();
                    System.out.println("Inserisci il nome per verificare le prenotazioni: ");
                    String ricerca = stringa.nextLine();

                    //Cerco all'interno dell'arraylist prenotazione una prenotazione che contenga il nome inserito
                    for (String a:prenotazione){
                        if (a.toLowerCase().contains(ricerca.toLowerCase())) {
                            risultato.add(a);
                        }
                    }

                    //Stampo l'array dei risultati
                    System.out.println(risultato.toString());
                    break;
                case 3:
                    stampaposti(posti);
                    break;
                case 4:
                    rapporto(posti);
                    break;
                
                case 5:
                    System.out.println("\n Arrivederci!");
                    cond = false;
                    break;
                default:
                    break;
            }


        }
        }

        //Metodo che gestisce il meccanismo del menù
        public static int menu(){
            Scanner scelta = new Scanner(System.in);
            System.out.println("\nMenù di selezione: \n 1 - Prenota un posto. \n 2 - Cerca una prenotazione \n 3 - Visualizza i posti liberi e quelli prenotati. \n 4 - Percentuale posti prenotati. \n 5 - Chiudi il programma.");
            int tmp = scelta.nextInt();
            return tmp;
        }

        //Metodo che inizializza la matrice dei posti.
        public static boolean[][] matriceposti(int righe, int colonne){
            boolean[][] posti = new boolean[righe][colonne];
            for (int i=0;i<posti.length;++i){
                for(int j=0;j<posti[i].length;++j){
                    posti[i][j] = true;
                    //System.out.println(posti[i][j]);
                }
            }
            return posti;
        }

        public static void stampaposti(boolean[][] posti){
            
            for (int i=0;i<posti.length;++i){
                for(int j=0;j<posti[i].length;++j){
                    if (posti[i][j] == true){
                        System.out.println("\nPosto disponibile\nRiga: " + i + "\nColonna: " + j);
                    } else {
                        System.out.println("\nPosto OCCUPATO\nRiga: " + i + "\nColonna: ");

                    }                   
                }
            }
        }

        public static void rapporto(boolean[][] posti){
            float sumdisp = 0;
            float sumocc = 0;
            float rapportodisp = 0;
            float rapportoocc = 0;
            for (int i=0;i<posti.length;++i){
                for(int j=0;j<posti[i].length;++j){
                    if (posti[i][j] == true){
                        sumdisp++;
                    } else {
                        sumocc++;
                    }                   
                }
            }
            System.out.println(sumdisp + " " + sumocc);
            rapportodisp = (sumdisp * 100) / (sumdisp + sumocc);
            System.out.println("La percentuale di posti disponibili e': " + rapportodisp + "%");
            rapportoocc = (sumocc * 100) / (sumdisp + sumocc);
            System.out.println("La percentuale di posti occupati e': " + rapportoocc + "%");
        }
}
