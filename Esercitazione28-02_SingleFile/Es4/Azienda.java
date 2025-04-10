package Es4;

import java.util.ArrayList;
import java.util.List;

abstract class Dipendente{
    protected String nome;
    protected int stipendio;

    public abstract void calcolaStipendio();
}

class Impiegato extends Dipendente{
    protected String nome;
    protected int stipendio;

    public Impiegato(String nome, int stipendio) {
        this.nome = nome;
        this.stipendio = stipendio;
    }

    @Override
    public void calcolaStipendio() {
        System.out.println("Lo stipendio di " + nome + " è " + stipendio);
    }
}

class Dirigente extends Dipendente{
    protected String nome;
    protected int stipendio;
    protected int bonus;

    public Dirigente(String nome, int stipendio, int bonus){
        this.nome = nome;
        this.stipendio = stipendio;
        this.bonus = bonus;
    }

    @Override
    public void calcolaStipendio() {
        System.out.println("Lo stipendio di " + nome + " senza bonus è " + stipendio);
        System.out.println("Lo stipendio di " + nome + " con il bonus è " + (stipendio + bonus));
        
    }
}

public class Azienda {
    public static void main(String[] args) {
        //Lista per memorizzare i dipendenti
        List<Dipendente> dipendenti = new ArrayList<>();

        dipendenti.add(new Impiegato("Ernesto Stefanelli", 2000));
        dipendenti.add(new Impiegato("Frank Gramuglia", 1500));
        dipendenti.add(new Dirigente("Marco Gavanelli", 2500, 1000));
        dipendenti.add(new Dirigente("Jeff Bezos", 150500000, 9500000));

        for(Dipendente dipendente : dipendenti){
            dipendente.calcolaStipendio();
            System.out.println();
        }
    }
}