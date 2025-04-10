package Es1;

import java.util.ArrayList;
import java.util.List;

interface Veicolo{
    void avvia();
    void ferma();
    String getTipo();
}

abstract class MezzoDiTrasporto implements Veicolo{
    
    protected String targa;

    public MezzoDiTrasporto(String targa){
        this.targa = targa;
    }

    public String getTarga(){
        return targa;
    }
}

class Auto extends MezzoDiTrasporto{

    public Auto(String targa){
        super(targa);
    }

    @Override
    public void avvia(){
        System.out.println("Auto " + targa + " avviata");
    }

    @Override
    public void ferma(){
        System.out.println("Auto " + targa + " fermata");
    }

    @Override
    public String getTipo(){
        return "Auto";
    }
    
}

class Moto extends MezzoDiTrasporto{

    public Moto(String targa){
        super(targa);
    }

    @Override
    public void avvia(){
        System.out.println("Moto " + targa + " avviata");
    }

    @Override
    public void ferma(){
        System.out.println("Moto " + targa + " fermata");
    }

    @Override
    public String getTipo(){
        return "Moto";
    }
    
}

public class FlottaVeicoli{
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