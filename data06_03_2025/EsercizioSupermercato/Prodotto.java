package data06_03_2025.EsercizioSupermercato;

import java.util.Date;

public abstract class Prodotto implements IProdotto {
    protected int codiceId;
    protected String nomeProdotto;
    protected double prezzo;
    protected Date dataAcquisto;

    // Costruttore
    public Prodotto(int codiceId_plc, String nomeProdotto_plc, double prezzo_plc) {
        this.codiceId = codiceId_plc;
        this.nomeProdotto = nomeProdotto_plc;
        this.prezzo = prezzo_plc;
        this.dataAcquisto = null;
    }

    // Getter id
    public int getCodiceId() {
        return this.codiceId;
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
        return "Nome: " + nomeProdotto + ", Prezzo: " + prezzo;
    }
}
