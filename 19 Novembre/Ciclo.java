public class Ciclo{
    public static void main(String[] args){

        //WHILE CON CONDIZIONE MATEMATICA
        int i = 1;
        while (i<=5){
            i++;
            System.out.println(i);
        }
        boolean cond = true;

        //WHILE CON CONFRONTO BOOLEANO
        i = 0;
        while (cond){
            System.out.println("Iterazione controllo bool: " + i);
            i++;
            if(i==5){
                cond = false;
            }
            }

        //WHILE CON BREAK 
        i = 0;
        cond = true;
        while (cond){
            System.out.println("Iterazione controllo con break: " + i);
            i++;
            if(i==5){
                break;
            }
            }


        //CICLO FOR
        for (int b=0;i<=10;i++){
            System.out.println("Ciclo for: " +i);
        }

        //CICLO FOREACH
        int[] arr = {1, 2, 3, 4, 5};
        for(int a:arr){
            System.out.println("Iterazione foreach: " + a);
        }
  

        }
    }


