import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GestoreProdotti<Prodotto> gestoreProdotti = new GestoreProdotti<>();
        Menu menu = new Menu();
        menu.mostraMenuPrincipale(scanner, gestoreProdotti);
    }
}
