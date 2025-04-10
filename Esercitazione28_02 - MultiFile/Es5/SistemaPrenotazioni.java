package Es5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPrenotazioni{

    static void aggiungiViaggio(List<Viaggio> viaggi, Viaggio nuovoViaggio) throws ViaggioGiaPrenotatoException {
        for (Viaggio viaggio : viaggi) {
            if (viaggio.getDestinazione().equalsIgnoreCase(nuovoViaggio.getDestinazione()) &&
                viaggio.getPrezzo() == nuovoViaggio.getPrezzo() &&
                ((nuovoViaggio instanceof ViaggioAereo && viaggio instanceof ViaggioAereo &&
                  ((ViaggioAereo) viaggio).getCompagniaAerea().equalsIgnoreCase(((ViaggioAereo) nuovoViaggio).getCompagniaAerea()) &&
                  ((ViaggioAereo) viaggio).getNumeroPosto() == ((ViaggioAereo) nuovoViaggio).getNumeroPosto()) ||
                 (nuovoViaggio instanceof ViaggioTreno && viaggio instanceof ViaggioTreno &&
                  ((ViaggioTreno) viaggio).getCompagniaFerroviaria().equalsIgnoreCase(((ViaggioTreno) nuovoViaggio).getCompagniaFerroviaria()) &&
                  ((ViaggioTreno) viaggio).getNumeroCarrozza() == ((ViaggioTreno) nuovoViaggio).getNumeroCarrozza()))) {
                throw new ViaggioGiaPrenotatoException();
            }
        }
        viaggi.add(nuovoViaggio);
        
        if(nuovoViaggio instanceof ViaggioAereo){
            ((ViaggioAereo) nuovoViaggio).prenota();
        } else if(nuovoViaggio instanceof ViaggioTreno){
            ((ViaggioTreno) nuovoViaggio).prenota();
        }
    }

    public static void main(String[] args){
        //Lista di viaggi
        List<Viaggio> viaggi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Inserisci il tipo di viaggio (aereo/treno) o 'esci' per terminare:");
            String tipo = scanner.nextLine();

            if (tipo.equalsIgnoreCase("esci")) {
                break;
            }

            System.out.println("Inserisci la destinazione:");
            String destinazione = scanner.nextLine();

            System.out.println("Inserisci il prezzo:");
            double prezzo = Double.parseDouble(scanner.nextLine());

            try{
                if(tipo.equalsIgnoreCase("aereo")){
                    System.out.println("Inserisci la compagnia aerea:");
                    String compagniaAerea = scanner.nextLine();

                    System.out.println("Inserisci il numero del posto:");
                    int numeroPosto = Integer.parseInt(scanner.nextLine());

                    //Creo un nuovo oggetto ViaggioAereo
                    ViaggioAereo viaggioAereo = new ViaggioAereo(destinazione, prezzo, compagniaAerea, numeroPosto);
                    
                    //Prima di aggiungerlo verifico che non sia già presente
                    aggiungiViaggio(viaggi, viaggioAereo);

                } else if(tipo.equalsIgnoreCase("treno")){
                    System.out.println("Inserisci la compagnia ferroviaria:");
                    String compagniaFerroviaria = scanner.nextLine();

                    System.out.println("Inserisci il numero della carrozza:");
                    int numeroCarrozza = Integer.parseInt(scanner.nextLine());

                    //Creo un nuovo oggetto ViaggioTreno
                    ViaggioTreno viaggioTreno = new ViaggioTreno(destinazione, prezzo, compagniaFerroviaria, numeroCarrozza);
                    
                    //Prima di aggiungerlo verifico che non sia già presente   
                    aggiungiViaggio(viaggi, viaggioTreno);

                } else {
                    System.out.println("Tipo di viaggio non valido. Riprova.");
                    continue;
                }
            }catch (ViaggioGiaPrenotatoException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        
        System.out.println("\nViaggi in aereo:");
        for (Viaggio viaggio : viaggi) {
            if (viaggio instanceof ViaggioAereo) {
                viaggio.descrizione(); // Chiama il metodo `descrizione()` di ViaggioAereo
            }
        }

        System.out.println("\nViaggi in treno:");
        for (Viaggio viaggio : viaggi) {
            if (viaggio instanceof ViaggioTreno) {
                viaggio.descrizione(); // Chiama il metodo `descrizione()` di ViaggioTreno
            }
        }
    }  
}