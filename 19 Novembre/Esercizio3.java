
public class Esercizio3{
    public static void main(String[] args){
        int[] giorni = {1, 2, 3, 4, 5, 6, 7};
        for(int i=0; i<giorni.length; i++){
            int a = giorni[i];
            switch(a){
                case 1:
                    System.out.println("Lunedì");
                    break;
                case 2:
                    System.out.println("Martedì");
                    break;
                case 3:
                    System.out.println("Mercoledì");
                    break;
                case 4:
                    System.out.println("Giovedì");
                    break;
                case 5:
                    System.out.println("Venerdì");
                    break;
                case 6:
                    System.out.println("Sabato");
                    break;
                case 7:
                    System.out.println("Domenica");
                    break;
                default:
                    break;
            }
        }
        System.out.println("Fine ciclo.");
        }
    }



