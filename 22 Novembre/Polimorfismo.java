public class Polimorfismo {
    public static void main(String[] args) {
        Animal myPig = new Pig();
        Animal myDog = new Dog();
        myPig.animalSound();
        myDog.animalSound();
    }
}

class Animal{
    public void animalSound(){
        System.out.println("The animal makes sound");
    }
}

class Pig extends Animal{
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal{
    public void animalSound(){
        System.out.println("The dog says: bow bow");
    }
}


