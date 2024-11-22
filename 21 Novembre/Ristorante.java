
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ristorante {

    private ArrayList<String> piatti = new ArrayList<>();
    private ArrayList<Integer> valutazioni = new ArrayList<>();

    public void aggiungiPiatto(String piatto){
        this.piatti.add(piatto);
    }

    public void aggiungiValutazione(int valu){
        this.valutazioni.add(valu);
    }

    public void getPiatti(){
        System.out.println("\nLista piatti: ");
        for (String a:this.piatti){
            System.out.println("\n" + a);
        }
    }

    public float numeroCasuale(float min, float max) {
        Random random = new Random();
        float randomfloat = min + random.nextFloat() * (max - min);
        return randomfloat;
    }

    public static void main(String[] args) {
                Ristorante main = new Ristorante();
                Scanner tmp = new Scanner(System.in);
                Scanner inttmp = new Scanner(System.in);
                Random random = new Random();
                boolean flag = true;
                ArrayList<Utente> utenti = new ArrayList<>();

                System.out.println("\nMenù: \n 1 - Registra utente. \n 2 - Visualizza profili. \n 3 - Aggiungi piatto(Chef) \n 4 - Aggiungi valutazione(Critico)");
                while(flag){
                    int scelta = inttmp.nextInt();
                    switch(scelta){
                        case 1:
                            System.out.print("\nInserisci nome: ");
                            String nome = tmp.nextLine();
                            System.out.print("\nInserisci Email: ");
                            String email = tmp.nextLine();
                            Utente utentetmp = new Utente(email, nome);
                            utenti.add(utentetmp);
                            System.out.println("Utente creato con successo!");
                            break;
                        case 2:
                            for (Utente u:utenti){
                                u.getUtente();
                            }
                            break;
                        case 3:
                            System.out.print("\nInserisci nome Chef: ");
                            String nomechef = tmp.nextLine();
                            System.out.print("\nInserisci Email: ");
                            String emailchef = tmp.nextLine();
                            Chef cheftmp = new Chef(emailchef, nomechef);
                            utenti.add(cheftmp);
                            System.out.println("\nNome piatto da aggiungere: ");
                            String piatto = tmp.nextLine();
                            cheftmp.aggiungiPiatto(piatto);
                            System.out.println("Utente creato con successo!");
                            break;
                        case 4:
                            System.out.print("\nInserisci nome Critico: ");
                            String nomecritico = tmp.nextLine();
                            System.out.print("\nInserisci Email: ");
                            String emailcritico = tmp.nextLine();
                            Critico criticotmp = new Critico(emailcritico, nomecritico);
                            utenti.add(criticotmp);
                            System.out.println("\nInserisci valutazione: ");
                            int valutazione = inttmp.nextInt();
                            criticotmp.aggiungiValutazione(valutazione);
                            System.out.println("Utente creato con successo!");
                            break;
                        case 5:
                            main.getPiatti();
                            break;
                        case 6:
                            System.out.println("Arrivederci!");
                            flag = false;
                            break;
                        default:
                            System.out.println("\nCaso non gestito.");
                            break;  
                    }
            }
            
    }

}

class Utente extends Ristorante{
    private String email;
    private String nome;
    private float soldi;

    public Utente(String mail, String name){
        this.email = mail;
        this.nome = name;
        this.soldi = numeroCasuale(0, 999);
    }

    public float getSaldo(){
        return this.soldi;
    }

    public void getUtente(){
        System.out.println("\nEmail: " + this.email + "\nNome: " + this.nome);
    }
}

class Chef extends Utente{

    public Chef(String nome, String email) {
        super(email, nome);
    }

    public void aggiungiPiatto(String piatto){
        super.aggiungiPiatto(piatto);
        System.out.println("\nPiatto aggiunto!");
    }
}

class Critico extends Utente{

    public Critico(String nome, String email){
        super(email, nome);
    }

    public void aggiungiValutazione(int v){
        super.aggiungiValutazione(v);
        System.out.println("\nValutazione aggiunta!");
    }

}

