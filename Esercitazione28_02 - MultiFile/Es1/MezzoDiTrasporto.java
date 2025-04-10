package Es1;

public abstract class MezzoDiTrasporto implements Veicolo{
    
    protected String targa;

    public MezzoDiTrasporto(String targa){
        this.targa = targa;
    }

    public String getTarga(){
        return targa;
    }
}
