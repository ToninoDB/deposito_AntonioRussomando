import java.util.Scanner;

public class SnippetRiutilizzabiliInputMenu {

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
            if (valore >= 0) {
                return valore; // Ritorna solo se è un numero valido
            }

            System.out.print("Il numero non può essere negativo. Riprova: ");
        }
    }

    // Metodo per controllare l'input intero (o null)
    public static Integer checkInputIntegerOrNull(Scanner scanner) {
        String valore;
        Integer valoreInt;

        while (true) {
            valore = scanner.nextLine().trim();

            if (valore.isEmpty()) {
                return null; // Ritorna null se l'input è vuoto
            }

            try {
                valoreInt = Integer.parseInt(valore);

                if (valoreInt >= 0) {
                    return valoreInt; // Se il valore è valido, esce dal metodo
                } else {
                    System.out.print("Il numero non può essere negativo. Riprova: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Errore: Devi inserire un numero intero valido o premere Invio per lasciare vuoto.\n");
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

    // Metodo per l'inserimento di un double (o null)
    public static Double checkInputDoubleOrNull(Scanner scanner) {
        while (true) {
            String valore = scanner.nextLine().trim(); // Legge l'input e rimuove spazi bianchi

            if (valore.isEmpty()) {
                return null; // Ritorna null se l'input è vuoto
            }

            try {
                double valDouble = Double.parseDouble(valore);

                if (valDouble >= 0) {
                    return valDouble; // Se il valore è valido, lo restituisce
                } else {
                    System.out.print("Il numero non può essere negativo. Riprova: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Errore: Devi inserire un numero valido o premere Invio per lasciare vuoto.\n");
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

    // Metodo per controllare l'input stringa (o null)
    public static String checkInputStringOrNull(Scanner scanner) {
        String valore = scanner.nextLine().trim();
        return valore.isEmpty() ? null : valore;
    }

    // Metodo per controllare che l'input stringa void e lenght
    public static String controlloInputStringheConLunghezza(Scanner scanner, int lunghezzaStringa) {
        while (true) {
            String valore = scanner.nextLine().trim();

            if (valore.isEmpty()) {
                System.out.print("Input non valido. Inserisci un testo (non vuoto): ");
                continue;
            }

            if (valore.length() == lunghezzaStringa) {
                return valore; // Input valido, restituisco il valore
            }

            System.out.print("Input non valido. La lunghezza deve essere esattamente "
                    + lunghezzaStringa + " caratteri. Riprova: ");
        }
    }

    // #region METODI DEI MENU
    // Metodo per il menu principale
    public static void mostraMenuPrincipale(Scanner scanner) {
        int scelta;
        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            stampaMenuPrincipale();
            scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:
                    // Azione per l'opzione 1
                    break;
                case 2:
                    // Azione per l'opzione 2
                    break;
                case 3:
                    mostraSottoMenu(scanner); // Richiama il sotto-menu
                    break;
                case 4:
                    System.out.println("CIAOOOO");
                    exitMainMenu = true;
                    break;
                default:
                    System.out.println("⚠ Opzione non valida! Riprova.");
            }
        }
    }

    // Metodo di stampa del menu principale
    public static void stampaMenuPrincipale() {
        System.out.println("\n================================");
        System.out.println("         MENU PRINCIPALE        ");
        System.out.println("================================");
        System.out.println(" 1. Opzione 1");
        System.out.println(" 2. Opzione 2");
        System.out.println(" 3. Apri il sotto-menu");
        System.out.println(" 4. Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (1-4): ");
    }

    // Metodo per il sotto-menu per eliminare una città
    public static void mostraSottoMenu(Scanner scanner) {
        int sceltaSottomenu;
        boolean ritornoAlMenuPrincipale = false;

        do {
            stampaSottoMenu();
            sceltaSottomenu = controlloInputInteri(scanner);

            switch (sceltaSottomenu) {
                case 1:
                    // Azione per opzione 1
                    break;
                case 2:
                    // Azione per opzione 2
                    break;
                case 3:
                    // Azione per opzione 3
                    break;
                case 4:
                    // Azione per opzione 4
                    break;
                case 5:
                    // Azione per opzione 5
                    break;
                case 6:
                    // Azione per opzione 6
                    break;
                case 7:
                    // Azione per opzione 7
                    break;
                case 8:
                    // Azione per opzione 8
                    break;
                case 9:
                    // Azione per opzione 9
                    break;
                case 0:
                    System.out.println("Tornando al menu principale...");
                    ritornoAlMenuPrincipale = true;
                    break;
                default:
                    System.out.println("⚠ Opzione non valida! Riprova.");
            }
        } while (!ritornoAlMenuPrincipale);
    }

    // Metodo di stampa del sottomenu
    public static void stampaSottoMenu() {
        System.out.println("\n================================");
        System.out.println("         SOTTO-MENU             ");
        System.out.println("================================");
        System.out.println(" 1. Opzione 1");
        System.out.println(" 2. Opzione 2");
        System.out.println(" 3. Opzione 3");
        System.out.println(" 4. Opzione 4");
        System.out.println(" 5. Opzione 5");
        System.out.println(" 6. Opzione 6");
        System.out.println(" 7. Opzione 7");
        System.out.println(" 8. Opzione 8");
        System.out.println(" 9. Opzione 9");
        System.out.println(" 0. Torna al menu principale");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (0-9): ");
    }

    // #endregion
}