using System;

public class Program{
    public static void Main(string[] args){
        List<ProdottoSoftware> prodotti = new List<ProdottoSoftware>();

        ProdottoSoftware prodotto1 = new WebApp("Sito web di cucina", 12.31m, 6, 4.6m);
        ProdottoSoftware prodotto2 = new WebApp("Sito web di auto", 16.4m, 6, 2.6m);
        ProdottoSoftware prodotto3 = new MobileApp("Gioco dell'oca", 8.3m, 4.6m);
        ProdottoSoftware prodotto4 = new MobileApp("Puzzle", 3.2m, 1.2m);

        prodotti.Add(prodotto1);
        prodotti.Add(prodotto2);
        prodotti.Add(prodotto3);
        prodotti.Add(prodotto4);

        decimal totale = 0m;
        foreach(ProdottoSoftware s in prodotti){
            totale += s.CalcolaGuadagno();
        }

        Console.Write($"Il guadagno totale è: {totale}");
    }
}


public abstract class ProdottoSoftware{
    private string nome;
    
    public string Nome{
        get { return nome; }
        set { nome = value; }
    }

    private decimal prezzovendita;

    public decimal PrezzoVendita{
        get { return prezzovendita; }
        set { prezzovendita = value; }
    }

    public abstract decimal CalcolaGuadagno();


}

public class WebApp : ProdottoSoftware{

    public WebApp(string n, decimal p, int u, decimal c){
        Nome = n;
        PrezzoVendita = p;
        UtentiAttivi = u;
        CostiMantenimento = c;
    }
    private int utentiattivi;
    public int UtentiAttivi{
        get { return utentiattivi; }
        set { utentiattivi = value;}
    }

    private decimal costimantenimento;

    public decimal CostiMantenimento{
        get { return costimantenimento; }
        set { costimantenimento = value;}
    }

    public override decimal CalcolaGuadagno(){
        decimal totale;
        totale = PrezzoVendita - CostiMantenimento;
        return totale;
    }    
}


public class MobileApp : ProdottoSoftware {
    public MobileApp(string n, decimal p, decimal c){
        Nome = n;
        PrezzoVendita = p;
        CostoStore = c;
    }

    private decimal costostore;
    public decimal CostoStore {
        get { return costostore; }
        set {costostore = value; }
    }

    public override decimal CalcolaGuadagno()
    {
        decimal totale;
        totale = PrezzoVendita - CostoStore;
        return totale;
    }
}