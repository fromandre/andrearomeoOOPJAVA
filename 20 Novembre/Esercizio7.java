import java.util.ArrayList;


//[Vegetariana, Indiana, Francese, Italiana, Pesce]
//[Pasta, Pane, Pomodori, Radicchio, Patate]
public class Esercizio7 {
    public static void main(String[] args){


        ArrayList<String> listaing1 = new ArrayList();
        listaing1.add("Pane");
        listaing1.add("Pasta");
        ArrayList<String> listaing2 = new ArrayList();
        listaing2 = listaing1;
        listaing2.add("Radicchio");
        Chef chef1 = new Chef("Cannavacciuolo", "Italiana", listaing1);
        Chef chef2 = new Chef("Barbieri", "Italiana", listaing2);
        chef1.creapiatto();
        chef2.creapiatto();
    }


    public static class Chef{
        
        String nome;
        String tipo;
        ArrayList<String> ingredienti = new ArrayList();

        public Chef(String nomechef, String tipocucina, ArrayList<String> ingr){
            this.nome = nomechef;
            this.tipo = tipocucina;
            this.ingredienti = ingr;
        }

        public void creapiatto(){
            System.out.println("\nNome dello chef:" + this.nome + "\nTipo di cucina: " + this.tipo);
            for (int i=0; i<this.ingredienti.size(); ++i){
                switch(this.ingredienti.get(i).toLowerCase()){
                    case "pasta":
                        System.out.println("\nIngrediente presente nella lista: pasta. Piatto suggerito: pasta alla carbonara");
                        break;
                    case "pane":
                        System.out.println("\nIngrediente presente nella lista: pane. Piatto suggerito: bruschette alla pizzaiola");
                        break;
                    case "pomodori":
                        System.out.println("\nIngrediente presente nella lista: pomodori. Piatto suggerito: insalata caprese");
                        break;
                    case "radicchio":
                        System.out.println("\nIngrediente presente nella lista: radicchio. Piatto suggerito: risotto al radicchio");
                        break;
                    case "patate":
                        System.out.println("\nIngrediente presente nella lista: patate. Piatto suggerito: puré");
                        break;
                    default:
                        System.out.println("\nQuesto ingrediente estratto dalla lista non è stato riconosciuto: " + this.ingredienti.get(i));
                        break;
                }
            }
            }
        }
    }

