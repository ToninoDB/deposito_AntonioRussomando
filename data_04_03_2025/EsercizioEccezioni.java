package data_04_03_2025;

import java.util.Scanner;

public class EsercizioEccezioni {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Inserisci il numero di cioccolatini: ");
            String quantita = input.nextLine();

            int cioccolatini = Integer.parseInt(quantita);
            if (cioccolatini < 0) {
                throw new Exception("Il numero non può essere negativo!");
            }

            double prezzo = 0.75;
            double totale = prezzo * cioccolatini;

            System.out.println("Ordinati n." + cioccolatini + " al prezzo totale di €" + totale);

            // I catch vengono analizzati a cascata, quindi conviene prima scrivere quelli
            // pù specifici e man mano espandere la gerarchia delle eccezioni.
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Devi inserire un numero valido!");

        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println("Mirko mangia meno caramelle!");
        }
        input.close();
    }
}
