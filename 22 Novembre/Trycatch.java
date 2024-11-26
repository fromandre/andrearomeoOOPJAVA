public class Trycatch {
    public static void main(String[] args) {
        try {
            int[] myNumbers = {1, 2, 3, 4};
            System.out.println(myNumbers[12]);
        } catch (Exception e) {
            System.out.println("Qualcosa non è andato");
        } finally {
            System.out.println("Il try catch e' finito");
        }

        checkAge(15);


    }

    static void checkAge(int age){
        if (age < 18){
            throw new ArithmeticException("Access denied - You must be at least 18 years old");
        }
        else {
            System.out.println("Access granted - You are old enough!");
        }

    }
}

