package Es6;

import java.util.ArrayList;
import java.util.List;

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