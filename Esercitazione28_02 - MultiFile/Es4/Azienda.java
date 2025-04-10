package Es4;

import java.util.ArrayList;
import java.util.List;

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