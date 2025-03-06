package data06_03_2025.EsercizioVeicoli;

public abstract class Veicolo {
    protected String marca;
    protected String modello;
    protected int annoProduzione;

    // Costruttore
    public Veicolo(String marca_plc, String modello_plc, int annoProduzione_plc) {
        this.marca = marca_plc;
        this.modello = modello_plc;
        this.annoProduzione = annoProduzione_plc;
    }

    // Getter anno
    public int getAnnoProduzione() {
        return this.annoProduzione;
    }

    // Metodo astratto
    public abstract void mostraDettagli();
}