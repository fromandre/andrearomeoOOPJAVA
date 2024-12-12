using System;

/* public class Persona{
    public string Nome;

    public void Saluta(){
        Console.WriteLine("Ciao" + Nome);
    }
} */


/* class Program
{
    static void Main(string() args){
        Console.Write("Inserisci nome:");
        string nome = Console.ReadLine();
    }
} */

/* class Program2
{
    static void Main(string() args){
        Console.Write("Inserisci età:");
        string inputEta = Console.ReadLine();

        int eta;
        if (int.TryParse(inputEta, out eta))
        {
            Console.WriteLine($"Ciao, {nome}! Hai {eta} anni");
        } else {
            Console.WriteLine("L'età inserita non è valida.");
        }
    }
} */


/* class Program{
    static void Main(){
        List<int> pari = new List<int>();
        List<int> dispari = new List<int>();

        while (true){
            Console.WriteLine("Inserisci un numero: ");
            string tmp = Console.ReadLine();
            int num;
            if (int.TryParse(tmp, out num) ) {
                if (num%2==0){
                    pari.Add(num);
                } else if (num%1==0) {
                    dispari.Add(num);
                }
                
                Console.WriteLine($"Il numero inserito e' {num}");
                Console.WriteLine("Scegli fra:\n 1 - Stampa numeri pari.\n2 - Stampa numeri dispari\n3 - Esci dal programma.");
                string scelta = Console.ReadLine();
                switch (scelta){
                    case "1":
                        int[] paristring = pari.ToArray();
                        foreach (int n in paristring){
                            Console.WriteLine($"{n}  ");
                        }
                        Console.WriteLine("\n");
                        break;
                    case "2":
                        int[] disparistring = dispari.ToArray();
                        foreach(int b in dispari){
                            Console.WriteLine($"{b}  ");                            
                        }
                        Console.WriteLine("\n");
                        break;
                    case "3":
                        return;
                    default:
                        break;
                }
            } else {
                Console.WriteLine("Conversione non riuscita");
            }
        } 
    }
}
 */

/* class Program2{
    static void Main(string[] args){
        Console.WriteLine("Inserisci una frase in input: ");
        string frase = Console.ReadLine();

        //Il metodo Split separa la stringa in sottostringhe secondo il carattere inserito
        string[] frasearr = frase.Split(" ");
        Console.Write("Le parole contenute nella frase inserita sono: \n");
        //Per stampare ogni elemento 
        foreach (string e in frasearr){
            Console.Write($"{e}\n");
        }
        Console.Write($"Il numero di parole contenute nella frase è: {frasearr.Length}");
    }
} */

class Program{
    static void Main(string[] args){
        FabbricaGiocattoli fabbrica = new FabbricaGiocattoli();
        Giocattolo g1 = new Giocattolo("Cubi numerati", "Legno", 5.2m, 8.4m);
        Giocattolo g2 = new Giocattolo("Abaco", "Plastica", 12.3m, 22.6m);
        Giocattolo g3 = new Giocattolo("Peluche", "Cotone", 6.2m, 8.1m);
        fabbrica.aggiungiGiocattolo(g1);
        fabbrica.aggiungiGiocattolo(g2);
        fabbrica.aggiungiGiocattolo(g3);

        Console.Write("\nI giocattoli prodotti in fabbrica sono: ");
        fabbrica.stampaGiocattoli();
        Console.Write($"\nIl guadagno totale della fabbrica è: {fabbrica.guadagno()}");
    }
}

namespace sample{
    public class Giocattolo{
            private string Nome {get; set;}
            private string Materiale{get; set;}
            private decimal Prodprice{get; set;}
            private decimal Sellprice{get; set;}

        public void set(){
            
            //while quale valore vuoi settare?
            //switch
            //Accedi al valore con namespace.classe.proprietà

        }

        public Giocattolo(string nome, string materiale, decimal produzione, decimal vendita){
            Nome = nome;
            Materiale = materiale;
            Prodprice = produzione;
            Sellprice = vendita;
        }

        public decimal margine(){
            return Sellprice - Prodprice;
        }
    }
}

public class FabbricaGiocattoli{
    private List<Giocattolo> giocattoli = new List<Giocattolo>();

    public void aggiungiGiocattolo(Giocattolo g){
        giocattoli.Add(g);
    }

    public void stampaGiocattoli(){
        foreach (Giocattolo g in giocattoli){
            Console.Write($"\nNome giocattolo: {g.Nome}\nMateriale: {g.Materiale}\nPrezzo vendita: {g.Sellprice}.\n\n");
        }
    }

    public decimal guadagno(){
        decimal total = 0m;
        foreach (Giocattolo g in giocattoli){
            total += g.margine();
        }
        return total;
    }
}