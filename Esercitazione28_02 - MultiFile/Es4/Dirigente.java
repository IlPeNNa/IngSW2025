package Es4;

class Dirigente extends Dipendente{
    protected String nome;
    protected int stipendio;
    protected int bonus;

    public Dirigente(String nome, int stipendio, int bonus){
        this.nome = nome;
        this.stipendio = stipendio;
        this.bonus = bonus;
    }

    @Override
    public void calcolaStipendio() {
        System.out.println("Lo stipendio di " + nome + " senza bonus è " + stipendio);
        System.out.println("Lo stipendio di " + nome + " con il bonus è " + (stipendio + bonus));
        
    }
}