package it.eng.corso.dip.scenario3;

public class ServiceImpl implements Service {

    private String nome;

    public ServiceImpl(String nome ){
        this.nome = nome;
    }

    public void saluta(){
        System.out.println(nome + "ciao sono Service di scenario 2");
    }
}
