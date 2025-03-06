package data06_03_2025.EsercizioVeicoli;

import java.util.Scanner;

public class Menu {

    // Metodo per il menu principale
    public void mostraMenuPrincipale(Scanner scanner, GestoreVeicoli<Veicolo> gestoreVeicoli)
            throws InterruptedException {
        int scelta;

        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            clear();
            stampaMenuPrincipale();
            scelta = getInt(scanner);

            switch (scelta) {
                case 1:

                    System.out.print("Tipo di veicolo (automobile/moto/camion): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modello: ");
                    String modello = scanner.nextLine();

                    System.out.print("Anno di produzione: ");
                    int anno = scanner.nextInt();

                    scanner.nextLine();

                    if (tipo.equalsIgnoreCase("automobile")) {
                        System.out.print("Numero di porte: ");
                        int porte = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Tipo di carburante: ");
                        String carburante = scanner.nextLine();

                        gestoreVeicoli.aggiungiVeicolo(new Automobile(marca, modello, anno, porte, carburante));
                    } else if (tipo.equalsIgnoreCase("moto")) {
                        System.out.print("Tipologia (stradale/cross/scooter): ");
                        String tipologia = scanner.nextLine();

                        System.out.print("Cilindrata: ");
                        int cilindrata = scanner.nextInt();

                        gestoreVeicoli.aggiungiVeicolo(new Moto(marca, modello, anno, tipologia, cilindrata));
                    } else if (tipo.equalsIgnoreCase("camion")) {
                        System.out.print("Capacità di carico (tonnellate): ");
                        double capacita = scanner.nextDouble();

                        System.out.print("Numero di assi: ");
                        int assi = scanner.nextInt();

                        gestoreVeicoli.aggiungiVeicolo(new Camion(marca, modello, anno, capacita, assi));
                    } else {
                        System.out.println("Tipo di veicolo non valido.");
                    }
                    break;

                case 2:

                    gestoreVeicoli.mostraDettagliVeicoli();
                    break;
                case 3:

                    Veicolo piuVecchio = gestoreVeicoli.trovaVeicoloVecchio();
                    if (piuVecchio != null) {
                        System.out.println("Il veicolo più vecchio è:");
                        piuVecchio.mostraDettagli();
                    } else {
                        System.out.println("Nessun veicolo registrato.");
                    }
                    break;
                case 0:
                    System.out.println("ARRIVEDERCI E ACQUA IN BOCCA ;)");
                    exitMainMenu = true;
                    break;
                default:
                    System.out.println("Opzione non valida! Riprova.");
            }
        }
    }

    // Metodo di stampa del menu principale
    public void stampaMenuPrincipale() {
        System.out.println("\n======================================================");
        System.out.println("         BENVENUTO NEL GESTORE DI VEICOLI RUBATI      ");
        System.out.println("======================================================");
        System.out.println(" 1. Aggiungi un nuovo veicolo al gestore");
        System.out.println(" 2. Mostra i dettagli di tutti i veicoli");
        System.out.println(" 3. Trova il veicolo più vecchio");
        System.out.println(" 0. Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (0-3): ");
    }

    // Metodo per il controllo di un int
    public int getInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserire un numero intero valido.");
            }
        }
    }

    // Metodo per controllare che l'input stringa non sia vuoto
    public static String controlloInputStringhe(Scanner scanner) {
        while (true) {
            String valore = scanner.nextLine().trim();
            if (!valore.isEmpty()) {
                return valore; // Restituisce il valore solo se non è vuoto
            }
            System.out.print("Input non valido. Inserisci un testo: ");
        }
    }

    private static void clear() throws InterruptedException {
        Thread.sleep(3000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}