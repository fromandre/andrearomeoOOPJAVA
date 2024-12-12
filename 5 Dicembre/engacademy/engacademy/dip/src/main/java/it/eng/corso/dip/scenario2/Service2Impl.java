package it.eng.corso.dip.scenario2;

public class Service2Impl implements Service {

    private String nome;
    private String citta;

    public Service2Impl(String nome, String citta ){
        this.nome = nome;
        this.citta = citta;
    }

    public void saluta(){
        System.out.println(nome + "ciao sono Service di scenario 2. com'è il tempo a " + citta );
    }
}
