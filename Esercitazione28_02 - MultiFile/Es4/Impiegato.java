package Es4;

public class Impiegato extends Dipendente{
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