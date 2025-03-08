
import java.util.ArrayList;
import java.util.Date;

public class GestoreProdotti<T extends Prodotto> {

    private ArrayList<T> prodottiPresenti;
    private ArrayList<T> prodottiAcquistati;

    // Costruttore
    public GestoreProdotti() {
        this.prodottiPresenti = new ArrayList<>();
        this.prodottiAcquistati = new ArrayList<>();
    }

    // Metodo di aggiunta del prodotto alla lista con controllo dell'esistenza del
    // prodotto che si va ad inserire. Se il prodotto esiste già aggiorno
    // semplicemente la quantita facendo la somma di quella presente con quella
    // nuova.
    public void aggiungiProdotto(T nuovoProdotto) {
        for (T t : prodottiPresenti) {
            if (t.getNomeProdotto().equalsIgnoreCase(nuovoProdotto.getNomeProdotto())) {

                t.setQuantita(t.getQuantita() + nuovoProdotto.getQuantita());
                System.out.println("Prodotto già presente, ho aggiornato la quantità a  " + t.getQuantita());
                return;
            }
        }
        prodottiPresenti.add(nuovoProdotto);
        System.out.println("Prodotto inserito con successo!");
    }

    // Metodo per rimuovere un prodotto da quelli inseriti1
    public void rimuoviProdotto(String nomeProdotto) {
        for (int i = 0; i < prodottiPresenti.size(); i++) {
            if (prodottiPresenti.get(i).getNomeProdotto().equalsIgnoreCase(nomeProdotto)) {
                System.out.println("Eliminato prodotto: " + prodottiPresenti.get(i).getDettagli());
                prodottiPresenti.remove(i);
                return;
            }
        }
        System.out.println("Prodotto non trovato con nome " + nomeProdotto);
    }

    // Metodo per la stampa della lista dei prodotti presenti nel supermercato
    public void stampaProdottiInseriti() {
        if (prodottiPresenti.isEmpty()) {
            System.out.println("Nessun prodotto disponibile.");
        } else {
            for (T prodotto : prodottiPresenti) {
                System.out.println(prodotto.getDettagli());
            }
        }
    }

    // Metodo per l'applicazione dello sconto ai prodotti alimentari in scadenza
    public void applicaSconto() {
        System.out.println("Applicazione sconto ai prodotti alimentari in scadenza: ");
        for (T t : prodottiPresenti) {
            if (t instanceof Alimentare) {
                Alimentare prodotto = (Alimentare) t;
                double prezzoPrecedente = prodotto.getPrezzo();
                double prezzoScontato = prodotto.calcolaSconto();

                // Se il prezzo è stato ridotto, stampa il risultato
                if (prezzoScontato < prezzoPrecedente) {
                    System.out.println("Prodotto: " + prodotto.getNomeProdotto() +
                            " | Prezzo precedente: " + prezzoPrecedente +
                            " | Prezzo scontato: " + String.format("%.2f", prezzoScontato));
                    prodotto.setPrezzo(prezzoScontato); // Aggiorna il prezzo
                }
            }
        }
    }

    // Metodo per la stampa dei prodotti in garanzia
    public void stampaProdottiInGaranzia() {
        System.out.println("=== Stampa dei prodotti in garanzia ===");
        boolean trovato = false;

        for (T t : prodottiAcquistati) {
            if (t instanceof Elettronico) {
                Elettronico elettronico = (Elettronico) t;
                if (elettronico.inGaranzia()) {
                    System.out.println(elettronico.getDettagli());
                    trovato = true;
                }
            }
        }

        if (!trovato) {
            System.out.println("Nessun prodotto elettronico in garanzia.");
        }
    }

    // Metodo per la stampa dei punti fedeltà accumulati
    public void stampaPuntiFedelta() {
        int totalePunti = 0;

        for (T t : prodottiAcquistati) {
            totalePunti += t.puntiFedelta();
        }

        System.out.println("Punti fedeltà accumulati: " + totalePunti);

    }

    // Metodo per acquistare un prodotto. Utilizza un for normale poichè nel caso in
    // cui la quantità del prodotto arriva a 0 lo devo togliere dall'ararylist e con
    // un foreach non si può modificare la dimensione di un arraylist poichè serve
    // solo a scorrere la lista e non a modificarla.
    // Metodo per acquistare un prodotto
    public void acquistaProdotto(String nomeProdotto) {
        ArrayList<T> prodottiRimanenti = new ArrayList<>();

        for (T t : prodottiPresenti) {
            if (t.getNomeProdotto().equalsIgnoreCase(nomeProdotto)) {
                if (t.getQuantita() > 0) {
                    t.setQuantita(t.getQuantita() - 1);
                    t.setDataAcquisto(new Date());
                    aggiornaProdottoAcquistato(t); // Aggiorna la lista prodotti acquistati
                    System.out.println(
                            "Prodotto acquistato: " + t.getNomeProdotto() + " - Data acquisto: " + t.getDataAcquisto());
                } else {
                    System.out.println("Prodotto esaurito: " + t.getNomeProdotto());
                }
            }

            // Aggiunge solo i prodotti con quantità maggiore di 0
            if (t.getQuantita() > 0) {
                prodottiRimanenti.add(t);
            }
        }

        // Aggiorna la lista mantenendo solo i prodotti ancora disponibili
        prodottiPresenti = prodottiRimanenti;
    }

    // Metodo per aggiornare la lista dei prodotti acquistati
    private void aggiornaProdottoAcquistato(T prodotto) {
        for (T p : prodottiAcquistati) {
            if (p.getNomeProdotto().equalsIgnoreCase(prodotto.getNomeProdotto())) {
                // Se il prodotto è già stato acquistato, aggiorna la quantità
                p.setQuantita(p.getQuantita() + 1);
                return; // Esce perché il prodotto è già stato aggiornato
            }
        }

        // Se il prodotto non è ancora stato acquistato, lo aggiunge alla lista
        prodottiAcquistati.add(prodotto);
    }

    // Metodo per la stampa dei prodotti acquistati
    public void stampaProdottiAcquistati() {
        System.out.println("Prodotti acquistati!");
        for (T t : prodottiAcquistati) {
            System.out.println(t.getNomeProdotto() + " | Prezzo: " + t.getPrezzo() + "");
        }
    }
}