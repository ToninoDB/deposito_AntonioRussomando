import java.util.Scanner;

public class EsercizioProvaChef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente il nome dello chef
        System.out.print("Inserisci il nome dello Chef: ");
        String nome = scanner.nextLine();

        // Chiedi all'utente il tipo di chef
        System.out.print(
                "Inserisci il tipo di Chef (carne, sushi, vegetariano, napoletano, romano): ");
        String tipo = scanner.nextLine();

        // Chiedi all'utente l'ingrediente principale
        System.out.print("Inserisci un ingrediente: ");
        String ingrediente = scanner.nextLine();

        // Creazione dello Chef
        Chef chef = new Chef(nome, tipo, ingrediente);

        // Lo chef cucina il piatto
        chef.cucinaPiatto();

        // Chiudere lo Scanner
        scanner.close();
    }

}

class Chef {
    String nome;
    String tipo;
    String ingrediente;

    public Chef(String nome, String tipo, String ingrediente) {
        this.nome = nome;
        this.tipo = tipo;
        this.ingrediente = ingrediente;
    }

    public void cucinaPiatto() {
        System.out.println("Selezionato lo chef " + nome + " di tipo " + tipo);

        switch (tipo.toLowerCase()) {
            case "carne":
                if (ingrediente.equalsIgnoreCase("carne")) {
                    System.out.println("Preparazione: Bistecca alla griglia");
                } else {
                    System.out.println("Questo chef cucina solo piatti di carne!");
                }
                break;

            case "sushi":
                if (ingrediente.equalsIgnoreCase("pesce")) {
                    System.out.println("Preparazione: Sushi misto");
                } else {
                    System.out.println("Questo chef cucina solo piatti di sushi!");
                }
                break;

            case "vegetariano":
                if (ingrediente.equalsIgnoreCase("verdure")) {
                    System.out.println("Preparazione: Insalata fresca");
                } else {
                    System.out.println("Questo chef cucina solo piatti vegetariani!");
                }
                break;

            case "napoletano":
                if (ingrediente.equalsIgnoreCase("pizza")) {
                    System.out.println("Preparazione: pizza margherita");
                } else {
                    System.out.println("Questo chef cucina solo pizze!");
                }
                break;

            case "romano":
                if (ingrediente.equalsIgnoreCase("carbonara")) {
                    System.out.println("Preparazione: Pasta alla carbonara");
                } else {
                    System.out.println("Questo chef cucina solo carbonara!");
                }
                break;

            default:
                System.out.println("Tipo di chef non riconosciuto.");
        }
    }
}
