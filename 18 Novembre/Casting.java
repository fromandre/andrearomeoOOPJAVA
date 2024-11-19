import java.util.Scanner;

public class Casting {
    public static void main(String[] args) {
        Scanner myString = new Scanner(System.in);
        Scanner myInt = new Scanner(System.in);
        Scanner myFloat = new Scanner(System.in);
        System.out.println("Insert username: ");   //Chiede un username in input
        String user = myString.nextLine();  
        System.out.println("User is : " + user);   
        System.out.println("Insert age: ");   //Chiede un numero intero in input
        float age = myInt.nextInt();            
        System.out.println("Age is now float: " + age);
        System.out.println("Insert age in float: ");   //Chiede un numero intero in input
        int agefloat = (int)myFloat.nextFloat();         
        System.out.println("Age is now int: " + agefloat);
    }
}
