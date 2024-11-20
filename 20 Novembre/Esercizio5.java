
public class Esercizio5{
    int x = 5;
    public static void main(String[] args){
        Esercizio5 myObj = new Esercizio5();
        System.out.println(myObj.x);

    
    }


    public class Auto{
        public String modello;
        public String colore;
        public int velocità;
    
        public Auto(String modello, String colore){
            this.modello = modello;
            this.colore = colore;
            this.velocità = 0;
        }
    
        public void accelera(int incremento){
            velocità += incremento;
            System.out.println("L'auto " + modello + "ha accelerato. Velocità attuale: " + velocità + "Km/h.");
        }
    
        public void frena(int decremento){
            velocità -= decremento;
            if (velocità<0){
                velocità = 0;
            }
            System.out.println("L'auto " + modello + "ha frenato. Velocità attuale: " + velocità + "km/h.");
        }
    }
    
}


