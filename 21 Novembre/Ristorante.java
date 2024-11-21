
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ristorante {

    private ArrayList<String> piatti = new ArrayList<>();
    private ArrayList<Integer> valutazioni = new ArrayList<>();

    public Utente login(){
        Scanner stringa = new Scanner(System.in);
        System.out.println("\nInserisci nome utente: ");
        String utente = stringa.nextLine();
        System.out.println("\nInserisci email: ");
        String email = stringa.nextLine();
        float saldo = numeroCasuale(0.0f, 999.999f);
        Utente attuale = new Utente(email, utente, saldo);
        return attuale;
    }

    public float numeroCasuale(float min, float max) {
        Random random = new Random();
        float randomfloat = min + random.nextFloat() * (max - min);
        return randomfloat;
    }

    public void aggiungiPiatto(){
        Scanner stringa = new Scanner(System.in);
        System.out.println("\nInserisci un piatto da aggiungere: ");
        String piatto = stringa.nextLine();
        this.piatti.add(piatto);
        System.out.println("\nPiatto aggiunto!");
    }

    public void aggiungiValutazion(){
        Scanner intero = new Scanner(System.in);
        System.out.println("\nInserisci una valutazione: ");
        int valutazione = intero.nextInt();
        this.valutazioni.add(valutazione);
        System.out.println("\nValutazione aggiunta!");

    }

    public static void main(String[] args) {
            Ristorante r1 = new Ristorante();
            Utente attuale = r1.login();
            
    }



    public class Utente extends Ristorante{
        private String email;
        private String nome;
        private float soldi;

        public Utente(String mail, String name,float saldo){
            this.email = mail;
            this.nome = name;
            this.soldi = saldo;
        }

        public float getSaldo(){
            return this.soldi;
        }

        public void setSaldo(float saldo){
            this.soldi = saldo;
        }

        public void menu(){
            Scanner tmp = new Scanner(System.in);
            System.out.println("\nVuoi effettuare il login? \n 1-Si. \n 2-No");
            int scelta = tmp.nextInt();
            switch(scelta){
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("\nArrivederci.");
                    break;
                default:
                    System.out.println("\nCaso non gestito.");
                    break;  
            }
        }
    }


   public class Chef extends Utente{
        private String domandaSicurezza = "Qual è l'ingrediente principale del purè?";
        public String risposta = "Patate";

        public void verifica(){

            System.out.println("\nVerifica.\n" + domandaSicurezza);
            
        }
    }



    }

