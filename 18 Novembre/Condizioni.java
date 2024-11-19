public class Condizioni {
    public static void main(String[] args) {

        //CONDIZIONE IF 
        if (4 > 5){
            System.out.println("Mai eseguito");
            }
        String uno = "Ciao";
        String due = "Ciao";

        //CONDIZIONE IF FRA DUE STRING, NON ACCETTA > < >= <=
        if (uno == due){
            System.out.println("Verificata");
        } else if(uno.length() == due.length()){
            System.out.println("Lunghezze uguali, stringhe diverse");
        } else {
            System.out.println("Non verificata");
        }

        

        //CONDIZIONE SWITCH

        int day = 6;
        switch (day){
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
                System.out.println("Giorno non esistente");
                break;
        }

        //CICLO
    }
    }

