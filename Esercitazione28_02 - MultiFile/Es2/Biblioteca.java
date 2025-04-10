package Es2;

import java.util.ArrayList;
import java.util.List;

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
