import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci un libro: ");
        System.out.println("Inserisci il nome dell'autore: ");
        String nomeAutore = input.nextLine();
        System.out.println("Inserisci il numero di pagine: ");
        int nrPagine = input.nextInt();

        Libro libro1 = new Libro(nomeAutore, nrPagine);

        System.out.println("Vuoi effettuare una ricerca per nome autore? (s/n)");
        String risposta = input.next();
        if (risposta.equalsIgnoreCase("s")) {
            System.out.println("Inserisci il nome dell'autore da cercare: ");
            String autore = input.next();
            Libro libroTrovato = libro1.ricercaPerAutore(autore);
            if (libroTrovato != null) {
                System.out.println("Libro trovato: " + libroTrovato.nomeAutore + " " + libroTrovato.nrPagine);
            } else {
                System.out.println("Libro non trovato");
            }
        } else
            return;

        System.out.println("Vuoi effettuare una ricerca per numero di pagine? (s/n)");
        risposta = input.next();
        if (risposta.equalsIgnoreCase("s")) {
            System.out.println("Inserisci il numero massimo di pagine: ");
            int maxPagine = input.nextInt();
            Libro libroTrovato = libro1.ricercaPerMassimoNumeroPagine(maxPagine);
            if (libroTrovato != null) {
                System.out.println("Libro trovato: " + libroTrovato.nomeAutore + " " + libroTrovato.nrPagine);
            } else {
                System.out.println("Libro non trovato");
            }
        } else
            return;

    }
}

class Libro {
    String nomeAutore;
    int nrPagine;

    public Libro(String nomeAutore_plc, int nrPagine_plc) {
        this.nomeAutore = nomeAutore_plc;
        this.nrPagine = nrPagine_plc;
    }

    // Metodo per la ricerca di un libro per autore
    public Libro ricercaPerAutore(String autore) {
        if (this.nomeAutore.equalsIgnoreCase(autore)) {
            return this;
        }
        return null;
    }

    // Metodo per la ricerca di un libro per il numero massimo di pagine che deve
    // avere
    public Libro ricercaPerMassimoNumeroPagine(int numeroPagine) {
        if (this.nrPagine <= numeroPagine) {
            return this;
        }
        return null;
    }
}
