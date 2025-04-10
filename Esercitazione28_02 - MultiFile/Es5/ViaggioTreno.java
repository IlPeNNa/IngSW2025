package Es5;

public class ViaggioTreno extends Viaggio implements Prenotabile{
    protected String compagniaFerroviaria;
    protected int numeroCarrozza;

    public ViaggioTreno(String destinazione, double prezzo, String compagniaFerroviaria, int numeroCarrozza){
        super(destinazione, prezzo);
        this.compagniaFerroviaria = compagniaFerroviaria;
        this.numeroCarrozza = numeroCarrozza;
    }

    public String getCompagniaFerroviaria(){
        return compagniaFerroviaria;
    }

    public int getNumeroCarrozza(){
        return numeroCarrozza;
    }

    @Override
    public void prenota(){
        System.out.println("Prenotazione effettuata per il viaggio in treno con " + compagniaFerroviaria + " verso " + destinazione + ".");
    }

    @Override
    public void descrizione(){
        System.out.println("Viaggio a " + destinazione + " al prezzo di " + prezzo + "euro.");
        System.out.println("Compagnia ferroviaria: " + compagniaFerroviaria + ", Numero carrozza: " + numeroCarrozza + ".");
    }
}