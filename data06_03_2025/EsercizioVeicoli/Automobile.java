package data06_03_2025.EsercizioVeicoli;

public class Automobile extends Veicolo {
    private int numeroPorte;
    private String carburante;

    // Costruttore
    public Automobile(String marca_plc, String modello_plc, int annoProduzione_plc, int numeroPorte_plc,
            String carburante_plc) {
        super(marca_plc, modello_plc, annoProduzione_plc);
        this.numeroPorte = numeroPorte_plc;
        this.carburante = carburante_plc;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Automobile: " + marca + " " + modello + " (" + annoProduzione + "), Porte: " + numeroPorte
                + ", Carburante: " + carburante);
    }

}
