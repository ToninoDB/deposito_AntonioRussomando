import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GestioneSquadra {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Dichiarazione di array delle due squadre da inserire
        Squadra[] squadre = new Squadra[2];

        // Ciclo di riempimento del nome e dei calciatori per ogni squadra
        for (int i = 0; i < 2; i++) {

            // Inserimento del nome delle squadre
            System.out.print("Inserisci il nome della squadra n." + (i + 1) + ": ");
            String nomeSquadra = input.nextLine();
            squadre[i] = new Squadra(nomeSquadra);

            System.out.println("Inserisci i 12 calciatori della squadra n." + (i + 1));

            // For per l'inserimento dei calciatori per ogni squadra
            for (int j = 1; j < 12; j++) {
                System.out.print("Inserisci il nome del calciatore n." + j + ": ");
                String nome = input.nextLine();

                System.out.println();

                System.out.print("Inserisci il ruolo del calciatore n." + j + ": ");
                System.out.println();
                String ruolo = checkRuolo();

                System.out.println();
                // Aggiunta del calciatore alla squadra
                Calciatore calciatore = new Calciatore(nome, ruolo);
                squadre[i].squadArrayList.add(calciatore);
            }

        }

        // Stampo entrambe le squadre
        System.out.println("Stampa della squadra: ");
        for (Squadra squadra : squadre) {
            squadra.stampaSquadra();
        }

        // Creazione della partita tra le due squadre
        Partita partita = new Partita(squadre[0], squadre[1]);
        partita.giocaPartita();

        input.close();
    }

    @SuppressWarnings("resource")
    public static String checkRuolo() {
        Scanner scanner = new Scanner(System.in);
        String ruolo;
        do {
            System.out.print("Ruoli possibili -> portiere (p), difensore (d), centrocampista (c), attaccante (a): ");
            ruolo = scanner.nextLine().trim().toLowerCase();
        } while (!ruolo.equalsIgnoreCase("p") &&
                !ruolo.equalsIgnoreCase("d") &&
                !ruolo.equalsIgnoreCase("c") &&
                !ruolo.equalsIgnoreCase("a"));

        return ruolo;
    }
}

class Calciatore {
    String nome;
    String ruolo;

    public Calciatore(String nome_plc, String ruolo_plc) {
        this.nome = nome_plc;
        this.ruolo = ruolo_plc;
    }
}

class Squadra {
    String nome;
    ArrayList<Calciatore> squadArrayList = new ArrayList<Calciatore>();

    public Squadra(String nome_plc) {
        this.nome = nome_plc;
    }

    public void stampaSquadra() {
        System.out.println("Squadra: " + nome);
        for (Calciatore calciatore : squadArrayList) {
            System.out.println("Nome: " + calciatore.nome + " | Ruolo: " + calciatore.ruolo);
        }
    }
}

class Partita {
    Squadra squadra1;
    Squadra squadra2;

    public Partita(Squadra squadra1, Squadra squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
    }

    public void giocaPartita() {
        Random random = new Random();
        int risultatoSquadra1 = random.nextInt(10); // Random score between 0 and 4
        int risultatoSquadra2 = random.nextInt(10); // Random score between 0 and 4

        System.out.println("Risultato della partita:");
        System.out.println(squadra1.nome + " " + risultatoSquadra1 + " - " + risultatoSquadra2 + " " + squadra2.nome);
    }
}
