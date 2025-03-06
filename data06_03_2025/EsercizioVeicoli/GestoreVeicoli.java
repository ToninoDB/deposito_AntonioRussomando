package data06_03_2025.EsercizioVeicoli;

import java.util.ArrayList;
import java.util.List;

public class GestoreVeicoli<T extends Veicolo> {
    private List<T> veicoli;

    // Costruttore
    public GestoreVeicoli() {
        this.veicoli = new ArrayList<>();
    }

    // Metodo per aggiugnere i veicoli
    public void aggiungiVeicolo(T veicolo) {
        veicoli.add(veicolo);
        System.out.println("Aggiunto con successo!!");
    }

    // Metodo per mostrare i dettagli dei veicoli
    public void mostraDettagliVeicoli() {
        if (veicoli.isEmpty()) {
            System.out.println("Nessun veicolo presente!");
            return;
        }

        for (T v : veicoli) {
            v.mostraDettagli();
        }

    }

    // Metodo per la ricerca del veicolo più vecchio
    public T trovaVeicoloVecchio() {
        if (veicoli.isEmpty())
            return null;

        // Parto dal primo valore della collezione e lo confronto con tutti
        T vecchio = veicoli.get(0);
        for (T v : veicoli) {
            if (v.getAnnoProduzione() < vecchio.getAnnoProduzione()) {
                vecchio = v;
            }
        }
        return vecchio;
    }

}
