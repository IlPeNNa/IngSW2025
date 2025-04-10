package Es6;

public class Paypal extends MetodoPagamento{
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