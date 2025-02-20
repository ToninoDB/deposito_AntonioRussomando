import java.util.ArrayList;
import java.util.Scanner;

public class GestioneSpedizioniPenne {
    public static void main(String[] args) {
        // Creazione arraylist delle spedizioni
        ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
        menu(spedizioni);
    }

    public static void aggiungiSpedizione(ArrayList<ArrayList<Integer>> spedizioni, int rosso, int blu, int verde,
            int nero) {

        // Creazione arraylist per penne rosse
        ArrayList<Integer> penneRosse = new ArrayList<>();
        penneRosse.add(1);
        penneRosse.add(rosso);

        // Creazione arraylist per penne blu
        ArrayList<Integer> penneBlu = new ArrayList<>();
        penneBlu.add(2);
        penneBlu.add(blu);

        // Creazione arraylist per penne verdi
        ArrayList<Integer> penneVerdi = new ArrayList<>();
        penneVerdi.add(3);
        penneVerdi.add(verde);

        // Creazione arraylist per penne nere
        ArrayList<Integer> penneNere = new ArrayList<>();
        penneNere.add(4);
        penneNere.add(nero);

        // Aggiunta spedizione all'arraylist
        spedizioni.add(penneRosse);
        spedizioni.add(penneBlu);
        spedizioni.add(penneVerdi);
        spedizioni.add(penneNere);
    }

    public static void visualizzaSpedizioni(ArrayList<ArrayList<Integer>> spedizioni) {
        if (spedizioni.isEmpty()) {
            System.out.println("Nessuna spedizione registrata.");
            return;
        }

        System.out.println("\nLista delle Spedizioni:");
        for (ArrayList<Integer> spedizione : spedizioni) {
            int colore = spedizione.get(0);
            int numPenne = spedizione.get(1);

            System.out.println("Colore " + colore + " -> " + numPenne + " penne");
        }
    }

    public static void calcoloTotalePenne(ArrayList<ArrayList<Integer>> spedizioni) {
        if (spedizioni.isEmpty()) {
            System.out.println("Nessuna spedizione registrata.");
            return;
        }

        // Lista dei colori già elaborati
        ArrayList<Integer> coloriContati = new ArrayList<>();

        System.out.println("Totale penne per colore: ");

        // Scorriamo tutte le spedizioni per raccogliere i colori unici
        for (int i = 0; i < spedizioni.size(); i++) {
            int coloreCorrente = spedizioni.get(i).get(0); // Otteniamo il colore della spedizione corrente

            // Controlliamo se il colore è già stato conteggiato
            if (coloriContati.contains(coloreCorrente)) {
                continue; // Se già conteggiato, passa al prossimo
            }

            coloriContati.add(coloreCorrente); // Aggiungiamo il colore alla lista dei colori già conteggiati
            int totalePenne = 0;

            // Scansioniamo di nuovo l'elenco per sommare tutte le penne dello stesso colore
            for (int j = 0; j < spedizioni.size(); j++) {
                if (spedizioni.get(j).get(0) == coloreCorrente) {
                    totalePenne += spedizioni.get(j).get(1); // Sommiamo il numero di penne
                }
            }

            // Stampiamo il risultato per questo colore
            System.out.println("Colore " + coloreCorrente + " -> " + totalePenne + " penne");
        }
    }

    public static void ricercaPerColore(ArrayList<ArrayList<Integer>> spedizioni, int coloreDaCercare) {
        boolean trovato = false;

        System.out.println("Spedizioni contenenti il colore " + coloreDaCercare + ": ");

        for (int i = 0; i < spedizioni.size(); i++) {
            int colore = spedizioni.get(i).get(0); // Otteniamo il numero del colore
            int numPenne = spedizioni.get(i).get(1); // Otteniamo il numero di penne

            if (colore == coloreDaCercare && numPenne > 0) {
                System.out.println("Spedizione " + (i + 1) + " -> Colore " + colore + " " + numPenne + " penne");
                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Nessuna spedizione trovata con il colore " + coloreDaCercare);
        }
    }

    public static void menu(ArrayList<ArrayList<Integer>> spedizioni) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\nScegli un'opzione: \n1- Aggiungi spedizione \n2- Visualizza spedizioni \n3- Calcola per colore \n4- Ricerca per colore \n-1 Esci");
            int scelta = input.nextInt();

            // Controllo della scelta inserita da input
            if (scelta == -1) {
                System.out.println("Uscita dal menu!");
                break;

            } else if (scelta == 1) {
                // Ciclo per aggiungere una spedizione
                while (true) {
                    System.out.println("Inserisci la spedizione!");

                    System.out.println("Penne rosse!");
                    int rosse = checkInserimentoNumeroPenne();

                    System.out.println("Penne blu!");
                    int blu = checkInserimentoNumeroPenne();

                    System.out.println("Penne verdi!");
                    int verdi = checkInserimentoNumeroPenne();

                    System.out.println("Penne nere!");
                    int nere = checkInserimentoNumeroPenne();

                    aggiungiSpedizione(spedizioni, rosse, blu, verdi, nere);
                    break;
                }

            } else if (scelta == 2) {

                visualizzaSpedizioni(spedizioni);

            } else if (scelta == 3) {

                calcoloTotalePenne(spedizioni);

            } else if (scelta == 4) {
                while (true) {
                    System.out.println("Inserisci il colore (1->rosso 2->blu 3->verde 4->nero)");
                    int colore = input.nextInt();

                    if (colore < 1 || colore >= 5) {
                        continue;
                    } else {
                        ricercaPerColore(spedizioni, colore);
                        break;
                    }
                }

            } else
                System.out.println("Inserisci un numero tra 1 e 4 o -1 per uscire.");
        }

        // Chiusura scanner
        input.close();
    }

    @SuppressWarnings("resource")
    public static int checkInserimentoNumeroPenne() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.println("Inserisci quantitativo penne: ");
            n = scanner.nextInt();
            if (n < 0) {
                continue;
            } else {
                break;
            }
        }

        return n;
    }

}