package Es3;

import java.util.ArrayList;
import java.util.List;

interface Animale{
    public void emettiVerso();
    public void muoviti();
}

abstract class AnimaleBase implements Animale{
    protected String nome;
    
    public AnimaleBase(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    @Override
    public void emettiVerso() {
        System.out.println("Verso dell'animale: " + nome);
    }
    
    @Override
    public void muoviti() {
        System.out.println(nome + " si sta muovendo.");
    }
}

class Cane extends AnimaleBase{

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

class Gatto extends AnimaleBase{
    
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

public class Oasi {
    public static void main(String[] args) {
        List<Animale> animali = new ArrayList<>();

        //Aggiungo animali alla lista
        animali.add(new Cane("Scooby Doo"));
        animali.add(new Cane("Pluto"));
        animali.add(new Gatto("Tom"));
        animali.add(new Gatto("Silvestro"));

        for(Animale animale : animali){
            animale.emettiVerso();
            animale.muoviti();
            System.out.println();
        }
    }
}