import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Videoteca videoteca = new Videoteca();
        Scanner scanner = new Scanner(System.in);

        mostraMenuPrincipale(scanner, videoteca);
    }

    // Metodo per il menu principale
    public static void mostraMenuPrincipale(Scanner scanner, Videoteca videoteca) {
        int scelta;
        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            stampaMenuPrincipale();
            scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:
                    videoteca.aggiungiFilm(aggiungiFilmDaInput(scanner));
                    break;
                case 2:
                    System.out.println("Quale film vuoi rimuovere?");
                    videoteca.mostraCatalogoFilm();
                    System.out.print("> ");
                    String titolo = scanner.nextLine();
                    videoteca.rimuoviFilm(titolo);
                    break;
                case 3:
                    System.out.print("Inserisci l'ID utente: ");
                    String idUtente = scanner.nextLine();
                    System.out.print("Inserisci il titolo del film da noleggiare: ");
                    String titoloFilm = scanner.nextLine();
                    videoteca.noleggiaFilm(idUtente, titoloFilm);
                    break;
                case 4:
                    videoteca.mostraCatalogoFilm();
                    break;
                case 5:
                    Utente u = registraUtenteDaInput(scanner);
                    videoteca.registraUtente(u);
                    break;
                case 6:
                    System.out.print("Inserisci il titolo del film da cercare: ");
                    String filmTitolo = scanner.nextLine();
                    Film film = videoteca.cercaFilmPerTitolo(filmTitolo);
                    if (film != null) {
                        System.out.println("Film trovato: " + film);
                    } else {
                        System.out.println("Film non trovato: " + filmTitolo);
                    }
                    break;
                case 7:
                    System.out.print("Inserisci l'anno di uscita del film da cercare: ");
                    int anno = controlloInputInteri(scanner);
                    videoteca.cercaFilmPerAnno(anno);

                    break;
                case 8:
                    System.out.print("Inserisci l'ID utente: ");
                    String id = scanner.nextLine();
                    videoteca.filmNoleggiatiDaUtente(id);

                    break;
                case 9:
                    videoteca.utentiRegistratiAllaVideoteca();
                    break;

                case 10:
                    System.out.print("Inserisci l'ID utente: ");
                    String idutente = scanner.nextLine();
                    System.out.print("Inserisci il titolo del film da restituire: ");
                    String titolofilm = scanner.nextLine();
                    videoteca.restituisciFilm(idutente, titolofilm);
                    break;
                case 0:
                    System.out.println("Uscita dal sistema!");
                    exitMainMenu = true;
                    break;
                default:
                    System.out.println("Opzione non valida! Riprova.");
            }
        }
    }

    // Metodo di stampa per il menu
    public static void stampaMenuPrincipale() {
        System.out.println("\n================================");
        System.out.println("         MENU PRINCIPALE        ");
        System.out.println("================================");
        System.out.println(" 1. Aggiungi film");
        System.out.println(" 2. Rimuovi film");
        System.out.println(" 3. Noleggia film");
        System.out.println(" 4. Stampa catalogo film");
        System.out.println(" 5. Aggiungi utente");
        System.out.println(" 6. Cerca film per titolo");
        System.out.println(" 7. Cerca film per anno di uscita");
        System.out.println(" 8. Stampa noleggi di un utente");
        System.out.println(" 9. Stampa degli utenti registrati");
        System.out.println(" 10. Restituisci film");
        System.out.println(" 0. Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (1-10): ");
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
            scanner.nextLine(); // Scarta il resto della riga
            if (valore >= 0) {
                return valore; // Ritorna solo se è un numero valido
            }

            System.out.print("Il numero non può essere negativo. Riprova: ");
        }
    }

    // Metodo per l'aggiunta di un film da input
    public static Film aggiungiFilmDaInput(Scanner scanner) {
        System.out.print("Inserisci il titolo del film: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci l'anno di uscita: ");
        int anno;

        while (true) {
            try {
                anno = Integer.parseInt(scanner.nextLine());
                break; // Se l'input è valido, esce dal ciclo
            } catch (NumberFormatException e) {
                System.out.print("Errore! Inserisci un anno valido: ");
            }
        }

        Film film = new Film(titolo, anno);
        return film;
    }

    // Metodo per l'aggiunta di un utente da input
    public static Utente registraUtenteDaInput(Scanner scanner) {
        System.out.print("Inserisci l'ID utente: ");
        String idUtente = scanner.nextLine();

        System.out.print("Inserisci il nome dell'utente: ");
        String nome = scanner.nextLine();

        return new Utente(idUtente, nome);
    }

}
