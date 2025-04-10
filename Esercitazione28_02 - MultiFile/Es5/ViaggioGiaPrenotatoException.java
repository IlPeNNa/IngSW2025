package Es5;

public class ViaggioGiaPrenotatoException extends Exception {
    public ViaggioGiaPrenotatoException() {
        super("Errore: il viaggio è già stato prenotato!");
    }

    public ViaggioGiaPrenotatoException(String message) {
        super(message);
    }
}