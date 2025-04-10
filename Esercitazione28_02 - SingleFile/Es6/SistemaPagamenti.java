package Es6;

import java.util.ArrayList;
import java.util.List;

interface Pagabile{
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException;
}

class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(String message) {
        super(message);
    }
}

abstract class MetodoPagamento implements Pagabile{
    
    protected double saldoDisponibile;

    public MetodoPagamento(double saldoDisponibile){
        this.saldoDisponibile = saldoDisponibile;
    }

    public double getSaldoDisponibile() {
        return saldoDisponibile;
    }

    public void aggiungiFondi(double importo) {
        saldoDisponibile += importo;
    }
}

class CartadiCredito extends MetodoPagamento{
    protected String numeroCarta;
    protected String intestatario;
    protected String scadenza;

    public CartadiCredito(double saldoDisponibile, String numeroCarta, String intestatario, String scadenza){
        super(saldoDisponibile);
        this.numeroCarta = numeroCarta;
        this.intestatario = intestatario;
        this.scadenza = scadenza;
    }

    public String getNumeroCarta(){
        return numeroCarta;
    }

    public String getIntestatario(){
        return intestatario;
    }

    public String getScadenza(){
        return scadenza;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        if (importo > saldoDisponibile) {
            throw new SaldoInsufficienteException("Saldo insufficiente sulla carta di credito.");
        }
        saldoDisponibile -= importo;
        System.out.println("Pagamento di " + importo + " euro effettuato con Carta di Credito " + numeroCarta + ".");
    }
}

class Paypal extends MetodoPagamento{
    protected String email;

    public Paypal(double saldoDisponibile, String email){
        super(saldoDisponibile);
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        if (importo > saldoDisponibile) {
            throw new SaldoInsufficienteException("Saldo insufficiente sull'account PayPal.");
        }
        saldoDisponibile -= importo;
        System.out.println("Pagamento di " + importo + " euro effettuato con PayPal (" + email + ").");
    }
}

public class SistemaPagamenti{

    List<MetodoPagamento> metodiPagamento = new ArrayList<>();
    
    public void aggiungiMetodoPagamento(MetodoPagamento metodo) {
        metodiPagamento.add(metodo);
    }

    public void effettuaPagamento(double importo) {
        for (MetodoPagamento metodo : metodiPagamento) {
            try {
                metodo.effettuaPagamento(importo);
                System.out.println("Pagamento completato con successo.");
                return;
            } catch (SaldoInsufficienteException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Pagamento fallito: nessun metodo con saldo sufficiente.");
    }

    public void mostraMetodiPagamento() {
        System.out.println("Metodi di pagamento disponibili:");
        for (MetodoPagamento metodo : metodiPagamento) {
            System.out.println("- " + metodo.getClass().getSimpleName() + " (Saldo: " + metodo.getSaldoDisponibile() + "euro)");
        }
    }

    public static void main(String[] args){

        SistemaPagamenti sistema = new SistemaPagamenti();

        // Aggiunta di metodi di pagamento
        sistema.aggiungiMetodoPagamento(new CartadiCredito(100.0, "1234-5678-9012-3456", "luca rossi", "12/25"));
        sistema.aggiungiMetodoPagamento(new Paypal(50.0, "andreadipre@pippo.com"));

        // Mostra i metodi di pagamento
        sistema.mostraMetodiPagamento();

        // Effettua un pagamento
        System.out.println("\nTentativo di pagamento di 20 euro:");
        sistema.effettuaPagamento(20.0);

        // Mostra i metodi di pagamento aggiornati
        sistema.mostraMetodiPagamento();

        // Effettua un pagamento che supera il saldo disponibile
        System.out.println("\nTentativo di pagamento di 200 euro:");
        sistema.effettuaPagamento(200.0);
    }
}