package Es1;

public class Auto extends MezzoDiTrasporto{

    public Auto(String targa){
        super(targa);
    }

    @Override
    public void avvia(){
        System.out.println("Auto " + targa + " avviata");
    }

    @Override
    public void ferma(){
        System.out.println("Auto " + targa + " fermata");
    }

    @Override
    public String getTipo(){
        return "Auto";
    }
    
}
