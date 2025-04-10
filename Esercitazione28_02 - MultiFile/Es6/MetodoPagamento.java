package Es6;

public abstract class MetodoPagamento implements Pagabile{
    
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
