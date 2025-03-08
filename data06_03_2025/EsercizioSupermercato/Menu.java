import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private String tipoProdotto;
    private String nomeProdotto;
    private double prezzo;
    private int quantita;
    private int garanzia;
    private String taglia;
    private String materiale;
    private Date dataScadenza;

    // Metodo per il menu principale
    public void mostraMenuPrincipale(Scanner scanner, GestoreProdotti<Prodotto> gestoreProdotti)
            throws InterruptedException {
        int scelta;

        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            clear();
            stampaMenuPrincipale();
            scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:

                    System.out.println("Inserisci il nome del prodotto: ");
                    nomeProdotto = controlloInputStringhe(scanner);

                    System.out.println("Inserisci il prezzo del prodotto: ");
                    prezzo = controlloInputDouble(scanner);

                    System.out.println("Inserisci la quantita del prodotto: ");
                    quantita = controlloInputInteri(scanner);

                    tipoProdotto = controlloTipoProdotto(scanner);

                    if (tipoProdotto.equalsIgnoreCase("abbigliamento")) {
                        System.out.println("Inserisci la taglia del capo: ");
                        taglia = controlloInputStringhe(scanner);

                        System.out.println("Inserisci il materiale del capo: ");
                        materiale = controlloInputStringhe(scanner);

                        gestoreProdotti
                                .aggiungiProdotto(new Abbigliamento(nomeProdotto, prezzo, quantita, taglia, materiale));

                    } else if (tipoProdotto.equalsIgnoreCase("elettronico")) {
                        System.out.println("Inserisci in mesi il periodo di garanzia: ");
                        garanzia = controlloInputInteri(scanner);

                        gestoreProdotti.aggiungiProdotto(new Elettronico(nomeProdotto, prezzo, quantita, garanzia));

                    } else if (tipoProdotto.equalsIgnoreCase("alimentare")) {
                        System.out.println("Inserisci la data di scadenza dd/mm/yyyy: ");
                        dataScadenza = controlloInputData(scanner);

                        gestoreProdotti.aggiungiProdotto(new Alimentare(nomeProdotto, prezzo, quantita, dataScadenza));

                    } else
                        System.out.println("Tipo prodotto non valido!");

                    break;

                case 2:
                    System.out.println("Inserisci il nome del prodotto da eliminare: ");
                    nomeProdotto = controlloInputStringhe(scanner);

                    gestoreProdotti.rimuoviProdotto(nomeProdotto);
                    break;

                case 3:
                    gestoreProdotti.stampaProdottiInseriti();
                    break;

                case 4:
                    gestoreProdotti.applicaSconto();
                    break;

                case 5:
                    System.out.println("Inserisci il nome del prodotto che vuoi acquistare: ");
                    nomeProdotto = controlloInputStringhe(scanner);
                    gestoreProdotti.acquistaProdotto(nomeProdotto);
                    break;

                case 6:
                    gestoreProdotti.stampaProdottiAcquistati();
                    break;

                case 7:
                    gestoreProdotti.stampaProdottiInGaranzia();
                    break;

                case 8:
                    gestoreProdotti.stampaPuntiFedelta();
                    break;

                case 0:
                    System.out.println("TORNA A TROVARCI!!!");
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
        System.out.println("         BENVENUTO NELLA MINIMARKET DEL NAPOLI       ");
        System.out.println("======================================================");
        System.out.println(" 1. Aggiungi prodotto");
        System.out.println(" 2. Rimuovi prodotto");
        System.out.println(" 3. Stampa prodotti inseriti");
        System.out.println(" 4. Applica sconto");
        System.out.println(" 5. Acquista prodotto");
        System.out.println(" 6. Stampa prodotti acquistati");
        System.out.println(" 7. Stampa dei prodotti in garanzia");
        System.out.println(" 8. Stampa punti fedeltà");
        System.out.println(" 0. Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (0-8): ");
    }

    // Metodo per controllare l'input intero positivo
    public static int controlloInputInteri(Scanner scanner) {
        while (true) {
            // Controllo se l'input è un intero
            if (!scanner.hasNextInt()) {
                System.out.print("Devi inserire un numero intero. Riprova: ");
                scanner.next(); // Scarta l'input errato
                continue;
            }

            int valore = scanner.nextInt();
            scanner.nextLine();
            if (valore >= 0) {
                return valore; // Ritorna solo se è un numero valido
            }

            System.out.print("Il numero non può essere negativo. Riprova: ");
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

    // Metodo per controllare l'inserimento del tipo di prodotto
    public static String controlloTipoProdotto(Scanner scanner) {
        while (true) {
            System.out.print("Inserisci il tipo di prodotto (abbigliamento, elettronico, alimentare): ");
            String tipo = scanner.nextLine().trim();

            if (tipo.equalsIgnoreCase("abbigliamento") || tipo.equalsIgnoreCase("elettronico")
                    || tipo.equalsIgnoreCase("alimentare")) {
                return tipo;
            } else {
                System.out.println("Errore: inserire un tipo di moto valido (abbigliamento, elettronico, alimentare).");
            }
        }
    }

    // Metodo per controllare l'input double positivo
    public static double controlloInputDouble(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.print("Devi inserire un numero intero. Riprova: ");
                scanner.next(); // Scarta l'input errato
                continue;
            }

            double valore = scanner.nextDouble();
            if (valore >= 0) {
                return valore; // Ritorna solo se è un numero valido
            }

            System.out.print("Il numero non può essere negativo. Riprova: ");
        }
    }

    // Metodo per controllare l'input della data
    public static Date controlloInputData(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Rende la validazione rigorosa
        Date data = null;

        while (data == null) {
            try {
                System.out.print("Inserisci la data (dd/MM/yyyy): ");
                String inputData = scanner.nextLine();
                data = sdf.parse(inputData);

                if (!data.after(new Date())) {
                    System.out.println("La data deve essere successiva alla data attuale!");
                    data = null;
                }

            } catch (ParseException e) {
                System.out.println("Formato data non valido! Usa il formato dd/MM/yyyy");
            }
        }
        return data;
    }

    private static void clear() throws InterruptedException {
        Thread.sleep(3000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}