package EserciziPomeriggioWhile;

import java.util.Scanner;

//Scrivi un programma che chiede all'utente di inserire interi positivi.
//Il programma termina all'inserimento di un numero negativo.
//Alla fine stampa la somma di tutti i numeri inseriti (tranne il numero negativo)

public class EsercizioUno {
    public static void main(String[] args) {
        // Apertura scanner per inserimento
        Scanner input = new Scanner(System.in);

        // Dichiarazione e inizializzazione variabile per la somma
        int somma = 0;

        // Inizio ciclo while booleano
        while (true) {
            System.out.println("Inserisci numero: ");
            int numero = input.nextInt();

            // Chiusura del ciclo while se il numero inserito è negativo
            if (numero < 0)
                break;

            // Aggiornamento della variabile somma
            somma += numero;
        }

        System.out.println("Somma finale: " + somma);

        // Chiusura dello scanner
        input.close();
    }
}
