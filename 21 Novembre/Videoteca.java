import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Videoteca {
    //DEFINISCO DUE ARRAYLIST PER LA CLASSE VIDEOTECA
    ArrayList<Utente> utenti = new ArrayList<>();
    ArrayList<Film> film = new ArrayList<>();

    public static void main(String[] args){
        //CREO UN'ISTANZA DI VIDEOTECA
        Videoteca main = new Videoteca();

        //INIZIALIZZO SCANNER E FLAG
        Scanner stringa = new Scanner(System.in);
        boolean flag = true;
        main.aggiungiFilm("Il padrino", 2000);

        //Inizio il ciclo per menù
        while (flag){
            int scelta = menu();
            switch (scelta){

                //Nel primo caso sviluppo interfaccia utente
                case 1:
                    System.out.println("\nInserisci il nome utente: ");
                    String nomeu = stringa.nextLine();
                    Utente u = main.trovaUtente(nomeu);

                    //Se l'utente non esiste do la possibilità di crearlo tramite un altro menù;
                    if (u == null){
                        int reg = menuRegistrazione();
                        switch(reg){
                            case 1:
                                System.out.println("\nInserisci nome utente: ");
                                String nuovonome = stringa.nextLine();
                                main.aggiungiUtente(nuovonome, main.numeroCasuale(0, 500));
                                System.out.println("\nUtente aggiunto correttamente.");
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("\nCaso non gestito.");
                                break;
                        }
                    } 
                    //Altrimenti effettuo il login senza controlli
                    else {

                        //Mostro il menù di scelta per l'utente
                        int menuFilm = menuFilm();
                            switch (menuFilm){
                                case 1:

                                    //Visualizzo tutti i film disponibili
                                    main.stampaFilm();
                                    break;
                                case 2:

                                    //Do la possibilità di scegliere un film da noleggiare
                                    System.out.println("\nQual è il nome del film che vuoi noleggiare?");
                                    String filmNoleggio = stringa.nextLine();
                                    Film tmp = main.trovaFilm(filmNoleggio);
                                    if (tmp != null){
                                        main.aggiungiNoleggio(u, tmp);
                                        System.out.println("\nFilm aggiunto alla tua lista noleggiati.");
                                    } else{
                                        System.out.println("\nFilm non trovato");
                                    }
                                    break;
                                case 3:
                                    System.out.println("\nArrivederci!");
                                    break;
                                default:
                                    System.out.println("\n Caso non gestito");
                                    break;
                        }
                    }
                    break;

                    //Sviluppo l'interfaccia per l'amministratore di sistema
                case 2:
                    int sceltaAdmin = menuAdmin();
                    switch(sceltaAdmin){
                        case 1:

                            //Stampo tutti gli utenti registrati alla videoteca
                            main.stampaUtenti();
                            break;
                        case 2:

                            //Possibilità di inserire un nuovo film
                            Scanner filmnuovo = new Scanner(System.in);
                            Scanner filmanno = new Scanner(System.in);
                            System.out.println("\nInserisci il titolo: ");
                            String tmp = filmnuovo.nextLine();
                            System.out.println("\nInserisci anno di uscita: ");
                            int tmp2 = filmanno.nextInt();
                            main.aggiungiFilm(tmp, tmp2);
                            break;
                        case 3:

                            //Stampo la lista noleggi di un Utente scelto
                            Scanner utentetmp = new Scanner(System.in);
                            System.out.println("Inserisci il nome utente di cui vuoi verificare la lista noleggi: ");
                            String utente = utentetmp.nextLine();
                            Utente ricerca = main.trovaUtente(utente);
                            ricerca.elencoNoleggi();
                            break;
                        case 4:
                            System.out.println("Arrivederci");
                            break;
                    }
                    break;
                case 3: 
                    System.out.println("\nArrivederci!");
                    flag = false;
                    break;
                default:
                    System.out.println("\nScelta non prevista.");
                    break;
            }
        }
    
    }



    public void aggiungiUtente(String n, int i){
        for (Utente u:utenti){
            if (u.nome.equalsIgnoreCase(n)){
                System.out.println("\nE' già presente nel sistema un utente con questo nome.");
                return;
            }
        }
        Utente nuovo = new Utente(n, i);
        this.utenti.add(nuovo);
    }

    public void stampaFilm(){
        for (Film t:this.film){
            t.stampaFilm();
        }
    }
    
    public void stampaUtenti(){
        for (Utente u:this.utenti){
            u.stampaUtente();
        }
    }

    public void aggiungiNoleggio(Utente u, Film f){
        u.listaNoleggiati.add(f);
    }

    public void rimuoviNoleggio(Utente u, Film f){
        u.listaNoleggiati.remove(f);
    }

    public Utente trovaUtente(String nome){
        for (Utente tmp:this.utenti){
            if (tmp.nome.equalsIgnoreCase(nome)){
                return tmp;
            }
        }
        System.out.println("\nUtente non trovato!");
        return null;
    }

    public Film trovaFilm(String titolo){
        for (Film tmp:this.film){
            if (tmp.titolo.equalsIgnoreCase(titolo)){
                return tmp;
            }
        }
        System.out.println("\nFilm non trovato!");
        return null;
    }

    public void aggiungiFilm(String t, int a){
        Film tmp = new Film(t, a);
        boolean flag = true;
        for (Film f:this.film){
            if (f.titolo.equals(t) && f.annoUscita == a){
                flag = false;
                System.out.println("\nFilm già in catalogo!");
                return;
            }
        }
        if (flag){
        this.film.add(tmp);
        }
    }

    public void rimuoviFilm(String t){
        boolean flag = true;
        for (Film f:this.film){
            if(f.titolo.equalsIgnoreCase(t)){
                this.film.remove(f);
                flag = false;
                System.out.println("\nFilm rimosso correttamente!");
            }
        }
        if (flag){
            System.out.println("\nFilm non trovato in catalogo!");
        }
    }

    public class Film{
        String titolo;
        int annoUscita;

        public Film(String t, int a){
            this.titolo = t;
            this.annoUscita = a;
        }

        public String getTitolo(){
            return this.titolo;
        }

        public void setTitolo(String tmp){
            this.titolo = tmp;
        }

        public int getAnno(){
            return this.annoUscita;
        }

        public void setAnno(int t){
            this.annoUscita = t;
        }

        public void stampaFilm(){
            System.out.println("\nTitolo film: " + this.titolo + "\nAnno di uscita: " + this.annoUscita);
        }

        }
    
    public class Utente{

        int id;
        String nome;
        ArrayList<Film> listaNoleggiati = new ArrayList();

        public Utente(String nome, int id){
            this.id = id;
            this.nome = nome;
        }

        public void noleggiaFilm(Film film){
            listaNoleggiati.add(film);
        }

        public void elencoNoleggi(){
            for (int i=0; i<listaNoleggiati.size(); ++i){
                listaNoleggiati.get(i).stampaFilm();
            }
        }

        public void stampaUtente(){
            System.out.println("\nNome utente: " + this.nome + "\nID: " + this.id);
        }
    }

    public static int menu(){
        Scanner scelta = new Scanner(System.in);
        System.out.println("\nMenù di selezione: \n 1 - Login Utente \n 2 - Login amministratore \n 3 - Esci dal programma.");
        int tmp = scelta.nextInt();
        return tmp;
    }

    public static int menuRegistrazione(){
        Scanner scelta = new Scanner(System.in);
        System.out.println("\nMenù di selezione: \n 1 - Registra\n 2 - Esci");
        int tmp = scelta.nextInt();
        return tmp;
    }

    public static int menuFilm(){
        Scanner scelta = new Scanner(System.in);
        System.out.println("\nMenù di selezione: \n 1 - Lista film disponibili \n 2 - Noleggia un film \n 3 - Esci");
        int tmp = scelta.nextInt();
        return tmp;
    }

    public static int menuAdmin(){
        Scanner scelta = new Scanner(System.in);
        System.out.println("\nMenù di selezione: \n 1 - Mostra utenti \n 2 - Aggiungi un film \n 3 - Mostra film noleggiati da un utente \n 4 - Esci");
        int tmp = scelta.nextInt();
        return tmp;
    }

    public int numeroCasuale(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
