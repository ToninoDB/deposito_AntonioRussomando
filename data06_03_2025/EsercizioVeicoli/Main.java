package data06_03_2025.EsercizioVeicoli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GestoreVeicoli<Veicolo> gestoreVeicoli = new GestoreVeicoli<>();
        Menu menu = new Menu();
        menu.mostraMenuPrincipale(scanner, gestoreVeicoli);
    }
}
