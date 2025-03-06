package data06_03_2025.EsercizioSupermercato;

import java.util.ArrayList;

public class GestoreProdotti<T extends Prodotto> {

    private ArrayList<T> prodottiPresenti;

    // Costruttore
    public GestoreProdotti() {
        this.prodottiPresenti = new ArrayList<>();
    }

    // TODO controllo se il prodotto esiste già
    public void aggiungiProdotto(T prodotto) {
        prodottiPresenti.add(prodotto);
        System.out.println("Inserito: " + prodotto.getDettagli());
    }

    // Metodo per la rimozione di un prodotto dalla lista
    public void rimuoviProdotto(T prodotto) {
        if (prodottiPresenti.remove(prodotto))
            System.out.println("Prodotto: " + prodotto.getDettagli() + " rimosso!");
        else
            System.out.println("Prodotto non trovato!");
    }

    // Metodo per la stampa della lista dei prodotti presenti nel supermercato
    public void stampaListaProdottiInseriti() {
        if (prodottiPresenti.isEmpty()) {
            System.out.println("Nessun prodotto disponibile.");
        } else {
            for (T prodotto : prodottiPresenti) {
                System.out.println(prodotto.getDettagli());
            }
        }
    }
}
