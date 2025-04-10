package Es3;

public class Gatto extends AnimaleBase{
    
    public Gatto(String nome){
        super(nome);
    }

    @Override
    public void emettiVerso(){
        System.out.println("Il gatto " + nome + " miagola");
    }

    @Override
    public void muoviti(){
        System.out.println("Il gatto " + nome + " salta");
    }
}
