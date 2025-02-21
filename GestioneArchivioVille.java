import java.util.ArrayList;
import java.util.Scanner;

public class GestioneArchivioVille {
    public static void main(String[] args) {
        // Creazione della lista delle ville registrate
        ArrayList<ArrayList<Object>> ville = new ArrayList<>();

        // Avvio del menu interattivo per la gestione delle ville
        menu(ville);
    }

    // Funzione per aggiungere una nuova villa alla lista
    public static void aggiuntaVilla(ArrayList<ArrayList<Object>> ville, String nome, int numeroStanze,
            String piscina) {
        // Creazione di una lista che rappresenta una villa con nome, numero di stanze e
        // presenza di piscina
        ArrayList<Object> villa = new ArrayList<>();
        villa.add(nome);
        villa.add(numeroStanze);
        villa.add(piscina);

        // Aggiunta della villa alla lista principale
        ville.add(villa);

        // Messaggio di conferma per l'utente
        System.out.println("Inserimento avvenuto con successo!");
    }

    // Funzione per visualizzare tutte le ville registrate
    public static void visualizzazioneVille(ArrayList<ArrayList<Object>> ville) {
        // Controllo se la lista è vuota
        if (ville.isEmpty()) {
            System.out.println("Nessuna villa registrata.");
            return;
        }

        // Iterazione attraverso la lista per stampare i dettagli di ogni villa
        for (ArrayList<Object> villa : ville) {
            String nome = (String) villa.get(0);
            int numeroStanze = (Integer) villa.get(1);
            String piscina = (String) villa.get(2);

            // Stampa delle informazioni della villa
            System.out.println("Nome: " + nome + ", Stanze: " + numeroStanze + ", Piscina: " + piscina);
        }
    }

    // Funzione per cercare una villa per nome
    public static void ricercaPerNome(ArrayList<ArrayList<Object>> ville, String nomeRicerca) {
        // Controllo se la lista è vuota
        if (ville.isEmpty()) {
            System.out.println("Nessuna villa registrata.");
            return;
        }

        // Iterazione attraverso la lista per trovare la villa con il nome cercato
        for (ArrayList<Object> villa : ville) {
            String nomeVilla = (String) villa.get(0);

            // Controllo se il nome corrisponde (ignorando maiuscole/minuscole)
            if (nomeVilla.equalsIgnoreCase(nomeRicerca.trim())) {
                int numeroStanze = (Integer) villa.get(1);
                String piscina = (String) villa.get(2);

                // Stampa della villa trovata
                System.out.println(
                        "Villa trovata: Nome: " + nomeVilla + ", Stanze: " + numeroStanze + ", Piscina: " + piscina);
                return;
            }
        }

        // Messaggio di errore se la villa non è stata trovata
        System.out.println("Nessuna villa trovata con il nome: " + nomeRicerca);
    }

    // Funzione che gestisce il menu interattivo per l'utente
    public static void menu(ArrayList<ArrayList<Object>> ville) {
        // Creazione degli scanner per input numerico e testuale
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        // Ciclo principale del menu
        while (true) {
            // Stampa delle opzioni disponibili nel menu
            System.out.println(
                    "\nScegli un'opzione: \n1- Aggiungi villa \n2- Visualizza ville \n3- Ricerca per nome \n-1 Esci");

            // Lettura della scelta dell'utente
            int scelta = inputInt.nextInt();

            // Controllo della scelta inserita
            if (scelta == -1) {
                System.out.println("Uscita dal menu!");
                break;

            } else if (scelta == 1) {
                // Ciclo per l'inserimento di una nuova villa
                while (true) {
                    System.out.println("Inserisci la villa!");

                    // Lettura del nome della villa
                    System.out.print("Inserisci nome villa: ");
                    String nomeVilla = inputStr.nextLine();

                    // Lettura del numero di stanze con controllo sull'input
                    int numero;
                    while (true) {
                        System.out.print("Inserisci numero stanze (deve essere maggiore di 0): ");
                        numero = inputInt.nextInt();
                        inputInt.nextLine(); // Consuma il newline rimasto nel buffer

                        if (numero > 0) {
                            break; // Esce dal loop se il numero è valido
                        } else {
                            System.out.println("Errore: il numero di stanze deve essere maggiore di 0.");
                        }
                    }

                    // Richiesta dell'informazione sulla presenza della piscina con validazione
                    // dell'input
                    while (true) {
                        System.err.print("Inserisci se la piscina è presente (si/no): ");
                        String flag = inputStr.nextLine();

                        // Controllo se l'input è valido (deve essere "si" o "no")
                        if (!flag.equalsIgnoreCase("si") && !flag.equalsIgnoreCase("no")) {
                            System.out.println("Errore: inserisci 'si' o 'no'.");
                            continue;
                        } else {
                            // Aggiunta della villa se l'input è valido
                            aggiuntaVilla(ville, nomeVilla, numero, flag);
                            break;
                        }
                    }
                    break;
                }

            } else if (scelta == 2) {
                // Chiamata alla funzione di visualizzazione delle ville
                visualizzazioneVille(ville);

            } else if (scelta == 3) {
                // Richiesta del nome della villa da cercare
                System.out.println("Ricerca per nome della villa: ");
                String nomedaCercare = inputStr.nextLine();

                // Chiamata alla funzione di ricerca
                ricercaPerNome(ville, nomedaCercare);

            } else {
                // Messaggio di errore per input non valido
                System.out.println("Inserisci un numero tra 1 e 3 o -1 per uscire.");
            }
        }

        // Chiusura degli scanner per evitare memory leaks
        inputInt.close();
        inputStr.close();
    }
}
