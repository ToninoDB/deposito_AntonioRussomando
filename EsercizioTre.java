package EserciziPomeriggioWhile;

import java.util.Random;
import java.util.Scanner;

//Gioco indovina numero segreto
//Genera intero compreso tra 1 e 100 e chiedere all'utente di tentare di indovinare,
//fornendo dei suggerimento "Troppo alto" o "Troppo basso".

public class EsercizioTre {
    public static void main(String[] args) {
        // Apertura scanner
        Scanner input = new Scanner(System.in);
        // Dichiarazione variabile della classe Random per il numero casuale
        Random random = new Random();

        // Dichiarazione e inizializzazione del numero casuale generato
        int numeroDaIndovinare = random.nextInt(100) + 1;

        // Inizializzazione ciclo while booleano
        while (true) {

            int numeroUtente;

            // Controllo se il numero inserito è compreso tra 1 e 100
            do {
                System.out.print("Prova ad indovinare il numero intero tra 1 e 100: ");
                numeroUtente = input.nextInt();
            } while (numeroUtente <= 0 && numeroUtente > 100);

            // Controllo se il numero è stato indovinato
            if (numeroUtente < numeroDaIndovinare)
                System.out.println("Troppo basso!");
            else if (numeroUtente > numeroDaIndovinare)
                System.out.println("Troppo alto!");
            else {
                System.out.println("Complimenti hai indovinato!");
                break;
            }
        }

        // Chiusura scanner
        input.close();
    }
}
