
import java.util.Calendar;
import java.util.Date;

public class Abbigliamento extends Prodotto implements IRestituibile {

    private String taglia;
    private String materiale;

    // Costruttore
    public Abbigliamento(String nomeProdotto_plc, double prezzo_plc, int quantita_plc,
            String taglia_plc,
            String materiale_plc) {
        super(nomeProdotto_plc, prezzo_plc, quantita_plc);
        this.taglia = taglia_plc;
        this.materiale = materiale_plc;
    }

    // Metodo per la stampa dei dettagli del prodotto
    @Override
    public String getDettagli() {
        return super.getDettagli() + ", Taglia: " + taglia + ", Materiale: " + materiale;
    }

    // Metodo per il controllo se il prodotto è restituibile entro i 30 giorni
    // dall'acquisto
    @Override
    public boolean restituzione() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataAcquisto);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date fineRestituzione = cal.getTime();

        return new Date().before(fineRestituzione);
    }

}
