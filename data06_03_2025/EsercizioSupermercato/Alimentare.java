
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimentare extends Prodotto implements IScontabile {

    private Date dataScadenza;

    // Costruttore
    public Alimentare(String nomeProdotto_plc, double prezzo_plc, int quantita_plc,
            Date dataScadenza_plc) {
        super(nomeProdotto_plc, prezzo_plc, quantita_plc);
        this.dataScadenza = dataScadenza_plc;
    }

    public void setPrezzo(double prezzo_plc) {
        this.prezzo = prezzo_plc;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    // Metodo per calcolare lo sconto se il prodotto è ad una settimana dalla
    // scadenza
    @Override
    public double calcolaSconto() {
        Date oggi = new Date();
        long differenzaMillisecondi = dataScadenza.getTime() - oggi.getTime();
        long giorniAllaScadenza = differenzaMillisecondi / (1000 * 60 * 60 * 24);

        // 40% di sconto se mancano 7 giorni o meno alla scadenza
        if (giorniAllaScadenza <= 7) {
            return this.prezzo * 0.60;
        } else {
            return this.prezzo;
        }
    }

    // Override metodo per i dettagli del prodotto alimentare
    @Override
    public String getDettagli() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.getDettagli() + ", Scadenza: " + sdf.format(dataScadenza);
    }

}
