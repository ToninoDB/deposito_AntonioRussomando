import java.util.Scanner;

public class EsercizioDueLoop {
    public static void main(String[] args) {
        // Array con i giorni della settimana
        String[] giorniSettimana = { "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica" };

        // Creazione di un array vuoto con capacità massima di 20 elementi
        String[] giorniRichiesti = new String[20];
        // Contatore per i giorni inseriti
        int count = 0;

        // Creazione dello scanner per input utente
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Inserisci un numero da 1 a 7 per conoscere il giorno della settimana.");
        System.out.println("Inserisci 0 per terminare.");

        do {
            System.out.print("Inserisci un numero: ");
            numero = input.nextInt();

            switch (numero) {
                case 1, 2, 3, 4, 5, 6, 7:
                    // Controlla che l'array non sia pieno
                    if (count < giorniRichiesti.length) {
                        // Aggiunge il giorno all'array
                        giorniRichiesti[count] = giorniSettimana[numero - 1];
                        count++;
                        System.out.println("Aggiunto: " + giorniSettimana[numero - 1]);
                    } else {
                        System.out.println("Hai raggiunto il limite massimo di 20 giorni inseriti.");
                    }
                    break;
                case 0:
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Numero non valido! Inserisci un numero tra 1 e 7.");
            }
        } while (numero != 0);

        // Stampa tutti i giorni richiesti
        System.out.println("\nGiorni inseriti in ordine:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + giorniRichiesti[i]);
        }

        // Chiusura scanner
        input.close();
    }
}