
import java.util.Date;

public abstract class Prodotto implements IProdotto, IFidelizzabile {
    private static int idAutoIncrementale = 1;
    protected int codiceId;
    protected String nomeProdotto;
    protected double prezzo;
    protected int quantita;
    protected Date dataAcquisto;

    // Costruttore
    public Prodotto(String nomeProdotto_plc, double prezzo_plc, int quantita_plc) {
        this.codiceId = idAutoIncrementale++;
        this.nomeProdotto = nomeProdotto_plc;
        this.prezzo = prezzo_plc;
        this.quantita = quantita_plc;
        this.dataAcquisto = null;
    }

    // Getter id
    public int getCodiceId() {
        return this.codiceId;
    }

    public void setCodiceId(int codiceId) {
        this.codiceId = codiceId;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public String getNomeProdotto() {
        return this.nomeProdotto;
    }

    // Setter per la data di acquisto
    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    // Override metodi interfaccia IProdotto
    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public String getDettagli() {
        return "Nome: " + nomeProdotto + ", Prezzo: " + prezzo + ", Quantità: " + quantita;
    }

    @Override
    public int puntiFedelta() {
        if (this instanceof Alimentare) {
            return (int) (prezzo * 2);
        } else if (this instanceof Elettronico) {
            return (int) (prezzo * 0.5);
        } else if (this instanceof Abbigliamento) {
            return (int) (prezzo * 1.2);
        } else
            return (int) (prezzo * 0.5);

    }

}
