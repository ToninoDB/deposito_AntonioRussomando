package data_04_03_2025;

import java.util.Scanner;

public class Menu {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PiattoSpeciale piatto = new PiattoSpeciale();
        piatto.mostraIngredienti();

        while (true) {
            System.out.println("Scegli uno degli ingredienti del menu (oppure scrivi \'esci\' per uscire): ");
            String ingrediente = scanner.nextLine();

            if (ingrediente.equalsIgnoreCase("esci")) {
                break;
            }

            piatto.aggiungiIngrediente(ingrediente);
        }

        if (piatto.getIngredientiScelti() != null) {
            System.out.println("Gli ingredienti scelti sono: ");
            piatto.mostraIngredientiScelti();

            double prezzo = piatto.calcolaPrezzo();
            System.out.println("Il prezzo totale del piatto è: " + prezzo);

        } else {
            System.out.println("Nessun ingrediente scelto");
        }

    }
}
