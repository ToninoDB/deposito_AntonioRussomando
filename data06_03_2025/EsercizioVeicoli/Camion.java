package data06_03_2025.EsercizioVeicoli;

public class Camion extends Veicolo {
    private double carico;
    private int assi;

    // Costruttore
    public Camion(String marca_plc, String modello_plc, int annoProduzione_plc, double carico_plc, int assi_plc) {
        super(marca_plc, modello_plc, annoProduzione_plc);
        this.carico = carico_plc;
        this.assi = assi_plc;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Camion: " + marca + " " + modello + " (" + annoProduzione + "), Carico: " + carico
                + ", N. assi: " + assi);
    }
}