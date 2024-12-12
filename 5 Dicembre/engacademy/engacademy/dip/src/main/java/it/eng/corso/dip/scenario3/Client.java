package it.eng.corso.dip.scenario3;

public class Client {

    private Service service;

    public void setService( Service service ){
        this.service = service;
    }

    public void miaLogica(){
       service.saluta();
    }
}
