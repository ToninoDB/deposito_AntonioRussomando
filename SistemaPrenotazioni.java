import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPrenotazioni {
    public static void main(String[] args) {

        int righe = 3;
        int colonne = 8;
        int postiTotali = righe * colonne;

        ArrayList<Integer> listaPostiRiga = new ArrayList<>();
        ArrayList<Integer> listaPostiColonna = new ArrayList<>();
        ArrayList<String> listaNominativi = new ArrayList<>();

        Scanner inputSTR = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);

        while (true) {

            // While per l'inserimento dei dati
            /* Controllare se i posti prenotati sono già occupati */

            while (true) {

                // Inserimento riga con controllo
                System.out.println("Inserisci riga tra 1 e 3: ");
                int riga = inputInt.nextInt();
                if (riga < 1 || riga > 3) {
                    System.out.println("⚠️ Errore: La riga deve essere tra 1 e 3.");
                    continue; // Torna all'inizio del ciclo
                }

                // Inserimento colonna con controllo
                System.out.println("Inserisci colonna tra 1 e 8: ");
                int colonna = inputInt.nextInt();
                if (colonna < 1 || colonna > 8) {
                    System.out.println("Errore: La colonna deve essere tra 1 e 8.");
                    continue; // Torna all'inizio del ciclo
                }

                // Controllo se il posto è già occupato
                boolean occupato = false;
                for (int i = 0; i < listaPostiRiga.size(); i++) {
                    if (listaPostiRiga.get(i) == riga && listaPostiColonna.get(i) == colonna) {
                        occupato = true;
                        break;
                    }
                }

                if (occupato) {
                    System.out.println("Posto già occupato! Scegli un altro.");
                    continue; // Torna all'inizio del ciclo senza aggiungere il posto
                }

                // Inserimento nominativo
                System.out.println("Inserisci nominativo: ");
                String nominativo = inputSTR.nextLine();

                // Aggiunta del posto solo se non è occupato
                listaPostiRiga.add(riga);
                listaPostiColonna.add(colonna);
                listaNominativi.add(nominativo);

                System.out.println("Prenotazione effettuata con successo!");

                // Uscita dal sottomenu
                System.out.println("Hai altre prenotazioni? si/no");
                String exit = inputSTR.nextLine();
                if (exit.equals("no")) {
                    break; // Esce dal ciclo
                }
            }

            // While per la ricerca delle prenotazioni
            while (true) {

                System.out.println(
                        "Inserisci per ricercare prenotazione 1->riga 2->colonna 3->nominativo 0->per uscire: ");
                int scelta = inputInt.nextInt();

                // Switch per la ricerca della prenotazione
                switch (scelta) {
                    case 1:
                        System.out.println("Inserisci riga: ");
                        int ricercaRigaPrenotazione = inputInt.nextInt();

                        // Ciclo foreach per la ricerca del nominativo nelle prenotazioni
                        for (int _ : listaPostiColonna) {
                            if (listaPostiRiga.contains(ricercaRigaPrenotazione)) {
                                System.out.println("Prenotazione presente con la riga: " + ricercaRigaPrenotazione);
                                break;
                            } else {
                                System.out.println(
                                        "Prenotazione con la riga " + ricercaRigaPrenotazione + " non trovata!");
                                break;
                            }

                        }
                        break;

                    case 2:
                        System.out.println("Inserisci colonna: ");
                        int ricercaColonnaPrenotazione = inputInt.nextInt();

                        // Ciclo foreach per la ricerca del nominativo nelle prenotazioni
                        for (int _ : listaPostiColonna) {
                            if (listaPostiColonna.contains(ricercaColonnaPrenotazione)) {
                                System.out
                                        .println("Prenotazione presente con la colonna: " + ricercaColonnaPrenotazione);
                                break;
                            } else
                                System.out.println(
                                        "Prenotazione con la colonna " + ricercaColonnaPrenotazione + " non trovata!");
                        }
                        break;

                    case 3:
                        System.out.println("Inserisci nominativo: ");
                        String ricercaNomePrenotazione = inputSTR.nextLine();

                        // Ciclo foreach per la ricerca del nominativo nelle prenotazioni
                        for (String _ : listaNominativi) {
                            if (listaNominativi.contains(ricercaNomePrenotazione)) {
                                System.out
                                        .println("Prenotazione presente con il nominativo: " + ricercaNomePrenotazione);
                                break;
                            } else
                                System.out.println(
                                        "Prenotazione con nominativo " + ricercaNomePrenotazione + " non trovata!");
                        }

                        break;
                    case 0:
                        System.out.println("Uscita dalla ricerca effettuata!");
                        break;

                    default:
                        System.out.println("Numero inserimento non corretto!");
                        break;
                }

                // Uscita dal sottomenu
                System.out.println("Devi cercare altre prenotazioni? si/no");
                String exit = inputSTR.nextLine();
                if (exit.equals("no"))
                    break;
            }

            // While per visualizzare i posto disponibili e prenotati
            while (true) {

                // Stampa dei posti occupati
                System.out.println("Posti Prenotati:");
                for (int i = 0; i < listaPostiRiga.size(); i++) {
                    System.out.println("Riga " + listaPostiRiga.get(i) + " Colonna " + listaPostiColonna.get(i)
                            + " -> Prenotato da: " + listaNominativi.get(i));
                }

                // Stampa dei posti disponibili
                System.out.println("Posti Disponibili: ");
                for (int i = 0; i < righe; i++) {
                    for (int j = 0; j < colonne; j++) {
                        boolean occupato = false;

                        // Controlla se il posto è già occupato
                        for (int k = 0; k < listaPostiRiga.size(); k++) {
                            if (listaPostiRiga.get(k) == i && listaPostiColonna.get(k) == j) {
                                occupato = true;
                                break;
                            }
                        }

                        // Se il posto non è occupato, lo stampiamo come disponibile
                        if (!occupato) {
                            System.out.println("Riga " + (i + 1) + " Colonna " + (j + 1) + " -> DISPONIBILE");
                        }
                    }
                }

                // Uscita dal sottomenu
                break;
            }

            // While per il report finale
            while (true) {
                System.out.println("Vuoi visualizzare il report finale? si/no");
                String scelta = inputSTR.nextLine();
                if (scelta.equals("no"))
                    break;
                else {
                    int postiPrenotati = listaPostiRiga.size();
                    int postiDisponibili = postiTotali - postiPrenotati;
                    System.out.println("Posti totali: " + postiTotali + //
                            "\nPosti disponibili: " + postiDisponibili + //
                            "\nPosti occupati: " + postiPrenotati);
                    break;
                }
            }

            // Uscita dal menu del sistema
            System.out.println("Vuoi continuare? si/no");
            String scelta = inputSTR.nextLine();
            if (scelta.equals("no"))
                break;
        }

        // Chiusura scanner
        inputInt.close();
        inputSTR.close();
    }
}
