import java.util.Scanner;

public class EsercizioDueLoop {
    public static void main(String[] args) {
        // Array con i giorni della settimana
        String[] giorniSettimana = { "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica" };

        // Apertura scanner
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Inserisci un numero da 1 a 7 per conoscere il giorno della settimana.");
        System.out.println("Inserisci 0 per terminare.");

        do {
            System.out.print("Inserisci un numero: ");
            numero = input.nextInt();

            // Per la stampa dei giorni della settimana
            switch (numero) {
                case 1, 2, 3, 4, 5, 6, 7:
                    System.out.println(numero + " = " + giorniSettimana[numero - 1]);
                    break;
                case 0:
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Numero non valido! Inserisci un numero tra 1 e 7.");
            }
        } while (numero != 0);

        // Chiusura scanner
        input.close();
    }
}
