package Es6;

public class CartadiCredito extends MetodoPagamento{
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