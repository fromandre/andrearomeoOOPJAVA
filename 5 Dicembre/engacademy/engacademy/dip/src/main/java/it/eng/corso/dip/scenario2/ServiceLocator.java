package it.eng.corso.dip.scenario2;

public class ServiceLocator {

    private static ServiceLocator instance;

    private Service service;

    private Client client;

    private ServiceLocator(){
        client = new Client();
        service = new Service2Impl("Pasqualino", "Roma");
    }

    public static ServiceLocator getInstance(){
        if( instance == null )
           instance = new ServiceLocator();

        return instance;
    }

    public Service getService(){
        return service;
    }
    public Client getClient(){
        return client;
    }
}
