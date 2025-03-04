import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PiattoSpeciale> ordini = new ArrayList<>();

        while (true) {
            System.out.println("Quanti panini vuoi ordinare? (Scrivi un numero oppure 'no' per uscire): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("no")) {
                break;
            }

            try {
                int quantita = Integer.parseInt(input);
                for (int i = 0; i < quantita; i++) {
                    PiattoSpeciale piatto = new PiattoSpeciale();
                    piatto.mostraIngredienti();

                    while (true) {
                        System.out.println("Scegli un ingrediente per il panino " + (i + 1)
                                + " (oppure scrivi 'esci' per terminare la scelta): ");
                        String ingrediente = scanner.nextLine();

                        if (ingrediente.equalsIgnoreCase("esci")) {
                            break;
                        }
                        // Ciclo di controllo che fa inserire un ingrediente finchè esiste o è
                        // disponibile
                        while (!piatto.isAvailable(ingrediente)) {
                            System.out.println("Ingrediente non disponibile. Scegli un altro ingrediente: ");
                            ingrediente = scanner.nextLine();
                        }

                        piatto.aggiungiIngrediente(ingrediente);

                    }

                    ordini.add(piatto);
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido o 'no' per uscire.");
            }
        }

        // Stampa degli ordini
        if (!ordini.isEmpty()) {
            System.out.println("Riepilogo degli ordini:");
            double totale = 0;
            for (int i = 0; i < ordini.size(); i++) {
                System.out.println("Panino " + (i + 1) + ":");

                ordini.get(i).mostraIngredientiScelti();
                double prezzo = ordini.get(i).calcolaPrezzo();

                System.out.println("Prezzo: " + prezzo + "\n");
                totale += prezzo;
            }
            System.out.println("Prezzo totale dell'ordine: " + totale);
        } else {
            System.out.println("Nessun panino ordinato.");
        }

        System.out.println("Grazie per aver ordinato. Arrivederci!");
    }
}