package Es5;

public abstract class Viaggio{
    protected String destinazione;
    protected double prezzo;

    public Viaggio(String destinazione, double prezzo){
        this.destinazione = destinazione;
        this.prezzo = prezzo;
    }

    public String getDestinazione(){
        return destinazione;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public abstract void descrizione();
}