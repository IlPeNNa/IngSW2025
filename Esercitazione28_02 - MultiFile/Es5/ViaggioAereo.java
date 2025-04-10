package Es5;

public class ViaggioAereo extends Viaggio implements Prenotabile{
    protected String compagniaAerea;
    protected int numeroPosto;

    public ViaggioAereo(String destinazione, double prezzo, String compagniaAerea, int numeroPosto){
        super(destinazione, prezzo);
        this.compagniaAerea = compagniaAerea;
        this.numeroPosto = numeroPosto;
    }

    public String getCompagniaAerea(){
        return compagniaAerea;
    }

    public int getNumeroPosto(){
        return numeroPosto;
    }

    @Override
    public void prenota(){
        System.out.println("Prenotazione effettuata per il volo con " + compagniaAerea + " verso " + destinazione + ".");
    }

    @Override
    public void descrizione(){
        System.out.println("Viaggio a " + destinazione + " al prezzo di " + prezzo + "euro.");
        System.out.println("Compagnia aerea: " + compagniaAerea + ", Numero posto: " + numeroPosto + ".");
    }
}