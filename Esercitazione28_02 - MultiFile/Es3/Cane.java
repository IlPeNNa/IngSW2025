package Es3;

public class Cane extends AnimaleBase{

    public Cane(String nome){
        super(nome);
    }

    @Override
    public void emettiVerso(){
        System.out.println("Il cane " + nome + " abbaia");
    }

    @Override
    public void muoviti(){
        System.out.println("Il cane " + nome + " corre");
    }
}
