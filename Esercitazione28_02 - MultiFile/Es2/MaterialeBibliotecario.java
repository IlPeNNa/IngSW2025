package Es2;

public abstract class MaterialeBibliotecario{

    protected String titolo;
    protected int annoPubblicazione;

    public MaterialeBibliotecario(String titolo, int annoPubblicazione){
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
    }
    
    public String getTitolo(){
        return titolo;
    }

    public int getAnnoPubblicazione(){
        return annoPubblicazione;
    }

    @Override
    public String toString(){
        return "\nTitolo: " + titolo + "\nAnno di pubblicazione: " + annoPubblicazione;
    }
}