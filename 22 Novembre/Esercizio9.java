public class Esercizio9 {
    public static void main(String[] args) {
        Persona pirata = new Pirata("Jack Sparrow", 25);
        pirata.saluta();
    }


}

class Persona{
    private String nome;

    public String getNome(){
        return this.nome;
    }

    public Persona(String n){
        this.nome = n;
    }

    public void saluta(){
        System.out.println("Ciao! Il mio nome è: " + this.getNome());
    }
}


class Pirata extends Persona{
    private int anni;

    public Pirata(String nome, int anni){
        super(nome);
        this.anni = anni;
    }

    public void saluta(){
        System.out.println("Ciao! Io sono un pirata, il mio nome è: " + this.getNome() + " ho " + this.anni + " anni");
    }
}


