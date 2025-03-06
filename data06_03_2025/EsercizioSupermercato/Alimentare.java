package data06_03_2025.EsercizioSupermercato;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimentare extends Prodotto implements IScontabile {

    private Date dataScadenza;

    // Costruttore
    public Alimentare(int codiceId_plc, String nomeProdotto_plc, double prezzo_plc, Date dataScadenza_plc) {
        super(codiceId_plc, nomeProdotto_plc, prezzo_plc);
        this.dataScadenza = dataScadenza_plc;
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
            System.out.println("Prodotto scontabile del 40%!");
            return prezzo * 0.40;
        } else {
            System.out.println("Prodotto non scontabile!");
            return 0;
        }

    }

    // Override metodo per i dettagli del prodotto alimentare
    @Override
    public String getDettagli() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.getDettagli() + ", Scadenza: " + sdf.format(dataScadenza);
    }

}
