package EserciziPomeriggioWhile;

import java.util.Scanner;

//Tabellina di un numero
//Chiede di inserire un numero e stampa la sua tabellina 

public class EsercizioDue {
    public static void main(String[] args) {

        // Apertura scanner
        Scanner input = new Scanner(System.in);
        int numeroInput;

        // Controllo se il numero inserito intero è maggiore di 0
        do {
            System.out.print("Inserisci un numero intero positivo: ");
            numeroInput = input.nextInt();
        } while (numeroInput <= 0);

        // Stampa di una linea vuota per pulizia di lettura
        System.out.println();

        // Inizializzazione variabile di iterazione del ciclo while
        int i = 1;

        while (i <= 10) {
            System.out.println(numeroInput + " * " + i + " = " + i * numeroInput);
            i++;
        }

        // Chiusura dello scanner
        input.close();
    }
}
