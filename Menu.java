package EserciziPomeriggioWhile;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        // Apertura dello scanner
        Scanner myScanner = new Scanner(System.in);

        // Inizio ciclo del menu
        while (true) {
            System.out.println(
                    "\nScegli un'opzione: \n1- EsercizioUno \n2- EsercizioDue \n3- EsercizioTre \n-1 Esci");
            int scelta = myScanner.nextInt();

            // Controllo della scelta inserita da input
            if (scelta == -1) {
                System.out.println("Uscita dal menu!");
                break;
            } else if (scelta == 1)
                EsercizioUno.main(null);

            else if (scelta == 2)
                EsercizioDue.main(null);

            else if (scelta == 3)
                EsercizioTre.main(null);

            else
                System.out.println("Inserisci un numero tra 1 e 3 o -1 per uscire.");
        }

        // Chiusura stream
        myScanner.close();
    }
}