import java.util.Scanner;

public class EsercizioFor {
    public static void main(String[] args) {
        // Dichiaro l'array e lo inizializzo a 0
        int[] array = { 0, 0, 0 };
        // Apertura scanner
        Scanner input = new Scanner(System.in);
        // Dichiarazione e inizializzazione counter
        int counter = 0;

        // Ciclo while con counter
        while (counter < 3) {
            // Ciclo for per l'inserimento dei valori da utente
            for (int i = 0; i < array.length; i++) {
                System.out.print("Inserisci numero per la posizione " + i + ": ");
                array[i] = input.nextInt();
            }
            System.out.println("Stampo i numeri maggiori di 100!");

            // Ciclo foreach per la stampa dei valori
            for (int i : array) {
                if (i > 100) {
                    System.out.println(i);
                    counter++;
                }
            }
        }
        // Chiusura scanner
        input.close();
    }
}
