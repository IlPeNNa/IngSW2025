package Es6;

public interface Pagabile{
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException;
}