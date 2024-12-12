package it.eng.corso.dip.scenario2;

public class Client {

    public void miaLogica(){
        Service service = ServiceLocator.getInstance().getService();
        service.saluta();
    }
}
