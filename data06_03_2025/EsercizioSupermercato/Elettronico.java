package data06_03_2025.EsercizioSupermercato;

import java.util.Calendar;
import java.util.Date;

public class Elettronico extends Prodotto implements IGarantibile, IRestituibile {
    // Garanzia in mesi
    private int garanzia;

    // Costruttore
    public Elettronico(int codiceId_plc, String nomeProdotto_plc, double prezzo_plc, int garanzia_plc) {
        super(codiceId_plc, nomeProdotto_plc, prezzo_plc);
        this.garanzia = garanzia_plc;
    }

    // Metodo di override per stampare i dettagli del prodotto
    @Override
    public String getDettagli() {
        return super.getDettagli() + " , Garanzia: " + garanzia + " mesi.";
    }

    // Metodo che ritorna true se il prodotto è ancora in garanzia
    @Override
    public boolean inGaranzia() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataAcquisto);
        cal.add(Calendar.MONTH, garanzia);
        Date fineGaranzia = cal.getTime();
        // Restituisce true se la data di fine garanzia è precedente alla data attuale
        return new Date().before(fineGaranzia);
    }

    // Metodo che ritorna true se il prodotto è restituibile
    @Override
    public boolean restituzione() {
        return inGaranzia();
    }

}
