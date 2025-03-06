package data06_03_2025.EsercizioSupermercato;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Abbigliamento extends Prodotto implements IRestituibile {

    private String taglia;
    private String materiale;

    // Costruttore
    public Abbigliamento(int codiceId_plc, String nomeProdotto_plc, double prezzo_plc, String taglia_plc,
            String materiale_plc) {
        super(codiceId_plc, nomeProdotto_plc, prezzo_plc);
        this.taglia = taglia_plc;
        this.materiale = materiale_plc;
    }

    // Metodo per la stampa dei dettagli del prodotto
    @Override
    public String getDettagli() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.getDettagli() + ", Taglia: " + taglia + ", Materiale: " + materiale + ", Acquisto: "
                + sdf.format(dataAcquisto);
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
