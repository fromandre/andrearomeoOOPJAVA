import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio6{

    public static void main(String[] args){
        Biblioteca b1 = new Biblioteca();
        Libro l1 = new Libro("Arthur Conan Doyle", 346);
        Libro l2 = new Libro("Edgar Alland Poe", 250);
        Libro l3 = new Libro("William Blake", 128);
        b1.aggiungilibro(l1);
        b1.aggiungilibro(l2);
        b1.aggiungilibro(l3);
        b1.stampalibri();
        b1.ricerca();
 
    }
    
    public static class Libro{
        public String autore;
        public int npagin;

        //Costruttore della classe
        public Libro(String autore, int pagine){
            this.autore = autore;
            this.npagin = pagine;
        }

        //Metodo di stampa richiamata in seguito
        public void stampa(){
            System.out.println("\nAutore: " + this.autore + "\nPagine: " + this.npagin);
        }
    }

    public static class Biblioteca{

        //Ogni classe biblioteca dispone di un arraylist di oggetti libro
        public ArrayList<Libro> libri = new ArrayList<>();

        //Aggiunge un oggetto libro all'arraylist
        public void aggiungilibro(Libro libtmp){
            this.libri.add(libtmp);
        }

        //Funzione che stampa tutti i libri della biblioteca
        public void stampalibri(){
            for (int i=0;i<this.libri.size(); ++i){
                this.libri.get(i).stampa();
            }
        }
        
        //Il metodo mostra un menù ricerca e attende risposta dall'utente
        public void ricerca(){
            Scanner stringhe = new Scanner(System.in);
            Scanner interi = new Scanner(System.in);
            System.out.println("\nSezione ricerca.\n1.Ricerca per nome.\n2.Ricerca per numero di pagine.");
            int scelta = interi.nextInt();
            switch (scelta){
                case 1:
                    System.out.println("\nInserisci il nome dell'autore: ");
                    String nome = stringhe.nextLine();
                    for (int i=0;i<this.libri.size(); ++i){
                        if (this.libri.get(i).autore.toLowerCase().contains(nome.toLowerCase())){
                            this.libri.get(i).stampa();
                            break;
                        }
                    }
                    System.out.println("\nLibro non trovato!");
                    break;
                case 2:
                    System.out.println("\nInserisci il numero di pagine massimo: ");
                    int pag = interi.nextInt();
                    for (int i=0;i<this.libri.size(); ++i){
                        if (this.libri.get(i).npagin < pag){
                            this.libri.get(i).stampa();
                            break;
                        }
                    } 
                    System.out.println("\nLa ricerca non ha prodotto risultati.");
                    break;
                default:
                    System.out.println("\nScelta non contemplata!");
                    break;
            }
        }

    }

}


