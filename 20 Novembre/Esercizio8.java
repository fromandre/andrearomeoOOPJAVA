import java.util.ArrayList;
import java.util.Random;
public class Esercizio8{


    public static void main(String[] args){
        Squadra squad1 = new Squadra();
        squad1.stampasquadra();
    }


    public static class Calciatore{
        String nome;
        int ruolo;

        public Calciatore(String nomec, int ruoloc){
            this.nome = nomec;
            this.ruolo = ruoloc;
        }

        public int getruolo(){
            return this.ruolo;
        }

    }


    public static class Squadra{
        String[] nomiposs = {"Marco", "Mario", "Antonio", "Alex", "Andrea", "Alessandro", "Piero", "Claudio", "Simone", "Antonello", "Vittorio", "Biagio"};
        ArrayList<Calciatore> rosa = new ArrayList();
        Random random = new Random();

        public Squadra(){
            boolean flag = true;
            boolean flag2 = false;
            int start = 1;
            int end = 12;
            while(true){
                int numerorandom = random.nextInt(end - start + 1) + start;
                int nomerandom = random.nextInt(end - start + 1) + start;
                System.out.println(numerorandom + " " + nomerandom);
                
                for (int i=0; i<this.rosa.size(); ++i){
                    if (this.rosa.get(i).ruolo == numerorandom && this.rosa.get(i).nome.toLowerCase().contains(nomiposs[nomerandom - 1])){
                        flag2 = true;
                    }
                }
                if (!flag2){
                    Calciatore tmp = new Calciatore(nomiposs[nomerandom - 1], numerorandom);
                    this.rosa.add(tmp);
                    flag = false;
                }
            }
        }

        public void stampasquadra(){
            for (int i=0; i<this.rosa.size(); ++i){
                System.out.println("\nNome giocatore: " + this.rosa.get(i).nome + "\nRuolo: " + this.rosa.get(i).ruolo);
            }
        }


    }



}


