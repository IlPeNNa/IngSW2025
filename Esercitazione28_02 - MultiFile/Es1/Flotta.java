package Es1;

import java.util.ArrayList;
import java.util.List;

public class Flotta{
    public static void main(String[] args){

        /*
        --- SOLUZIONE SENZA USARE LISTE ---
         --SE USO GLI ARRAY IL CODICE DIVENTA PIU' COMPLESSO--

        --------------------------------

        Veicolo[] flotta = new Veicolo[2];
        
        flotta[0] = new Auto("AB123CD");
        flotta[1] = new Moto("EF456GH");

        for (int i = 0; i < flotta.length; i++) {
            flotta[i].avvia();
        }

        for (int i = 0; i < flotta.length; i++) {
            flotta[i].ferma();
        }
            
        */

        List<Veicolo> flotta = new ArrayList<>();

        flotta.add(new Auto("AB123CD"));
        flotta.add(new Moto("EF456GH"));

        for(Veicolo veicolo : flotta) {
            veicolo.avvia();
        }

        for(Veicolo veicolo : flotta) {
            veicolo.ferma();
        }
    }
}
