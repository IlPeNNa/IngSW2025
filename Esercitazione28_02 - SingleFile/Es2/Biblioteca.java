package Es2;

import java.util.ArrayList;
import java.util.List;

abstract class MaterialeBibliotecario{

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

class Libro extends MaterialeBibliotecario{

    protected String autore;

    public Libro(String titolo, int annoPubblicazione, String autore){
        super(titolo, annoPubblicazione);
        this.autore = autore;
    }

    public String getAutore(){
        return autore;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAutore: " + autore;
    }
}

class Rivista extends MaterialeBibliotecario{

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

public class Biblioteca{

    List<MaterialeBibliotecario> materiali = new ArrayList<>();

    public void aggiungiMateriale(MaterialeBibliotecario materiale){
        materiali.add(materiale);
    }

    public void rimuoviMateriale(MaterialeBibliotecario materiale){
        materiali.remove(materiale);
    }

    public void visualizzaMateriali(){
        for(MaterialeBibliotecario materiale : materiali){
            System.out.println(materiale);
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Il Trono di Spade - L'ombra della profezia", 1998 , "George R. R. Martin");
        Libro libro2 = new Libro("Fahrenheit 451", 1953, "Ray Bradbury");
        Rivista rivista1 = new Rivista("Pop Tiger", 2020, 1);
        Rivista rivista2 = new Rivista("Di più", 2010, 5);

        biblioteca.aggiungiMateriale(libro1);
        biblioteca.aggiungiMateriale(libro2);
        biblioteca.aggiungiMateriale(rivista1);
        biblioteca.aggiungiMateriale(rivista2);

        System.out.println("Materiale della biblioteca :");
        biblioteca.visualizzaMateriali();

        biblioteca.rimuoviMateriale(rivista1);

        System.out.println("\nMateriale della biblioteca dopo aver rimosso la prima rivista : ");
        biblioteca.visualizzaMateriali();
    }
}
