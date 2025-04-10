package Es2;

public class Rivista extends MaterialeBibliotecario{

    protected int numeroEdizione;

    public Rivista(String titolo, int annoPubblicazione, int numeroEdizione){
        super(titolo, annoPubblicazione);
        this.numeroEdizione = numeroEdizione;
    }
    
    public int getNumeroEdizione(){
        return numeroEdizione;
    }

    @Override
    public String toString(){
        return super.toString() + "\nNumero Edizione : " + numeroEdizione;
    }
}
