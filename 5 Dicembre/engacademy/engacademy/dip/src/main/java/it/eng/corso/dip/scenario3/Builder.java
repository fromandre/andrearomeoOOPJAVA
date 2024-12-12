package it.eng.corso.dip.scenario3;

public class Builder {

    private static Builder instance;

    private Client client;
    private Service service;

    private Builder(){
        service = new Service2Impl("aaa","sss");
        client = new Client();
        client.setService(service);
    }

    public static Builder getInstance(){
        if( instance == null )
           instance = new Builder();

        return instance;
    }

    public Service getService(){
        return service;
    }

    public Client getClient() {
        return client;
    }
}
