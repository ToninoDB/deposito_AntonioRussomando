package data06_03_2025.EsercizioVeicoli;

public class Moto extends Veicolo {

    private String tipo;
    private int cilindrata;

    // Costruttore
    public Moto(String marca_plc, String modello_plc, int annoProduzione_plc, String tipo_plc, int cilindrata_plc) {
        super(marca_plc, modello_plc, annoProduzione_plc);
        this.tipo = tipo_plc;
        this.cilindrata = cilindrata_plc;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Moto: " + marca + " " + modello + " (" + annoProduzione + "), Tipo: " + tipo
                + ", Cilindrata: " + cilindrata);
    }
}