package Es3;

public abstract class AnimaleBase implements Animale{
    protected String nome;

    public AnimaleBase(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
