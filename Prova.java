import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Prova {
    // Costanti dati di connessione
    private static final String DB_URL = "jdbc:mysql://192.168.1.98:3306/world";
    private static final String DB_USERNAME = "utente_remoto";
    private static final String DB_PASSWORD = "ToninoDB";

    /*
     * // Constati db
     * private static final int LUNGHEZZA_STRINGA_COUNTRYCODE = 3;
     * private static final int LUNGHEZZA_STRINGA_COUNTRYCODE2 = 2;
     */

    // Metodo per la connessione
    public static Connection connessioneDatabase() {
        Connection conn = null;

        try {
            // Carica il driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crea la connessione
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Il metodo getCatalog() ritorna il nome dello schema a cui si è collegati
            String databaseName = conn.getCatalog();
            System.out.println("Connessione riuscita al database: " + databaseName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        Connection conn = connessioneDatabase();
        if (conn != null) {
            Scanner scanner = new Scanner(System.in);
            try {
                aggiungiNuovoPaese(conn, scanner);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connessione al database fallita.");
        }
    }

    public static Integer controlloIntero(Scanner input) {
        while (true) {
            String valore = input.nextLine().trim();

            if (valore.isEmpty()) {
                return null;
            }

            try {
                return Integer.parseInt(valore);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Devi inserire un numero intero valido o premere Invio per lasciare vuoto.");
            }
        }
    }

    public static void aggiungiNuovoPaese(Connection conn, Scanner input) throws SQLException {

        System.out.print("Inserisci il code della città: ");
        String code = input.nextLine();

        System.out.print("Inserisci il nome della città: ");
        String name = input.nextLine();

        System.out.print(
                "Inserisci il continente ('Asia', 'Europe', 'North America', 'Africa', 'Oceania', 'Antarctica', 'South America'): ");
        String continent = input.nextLine();

        System.out.print("Inserisci la regione: ");
        String region = input.nextLine();

        System.out.print("Inserisci la superficie: ");
        Double surfaceArea = input.nextDouble();
        input.nextLine();

        System.out.print("Inserisci l'anno di indipendenza: ");
        Integer indepYear = controlloIntero(input);

        System.out.print("Inserisci il numero della popolazione: ");
        Integer population = input.nextInt();
        input.nextLine();

        System.out.print("Inserisci l'aspettativa di vita: ");
        Integer lifeExpectancy = input.nextInt();
        input.nextLine();

        System.out.print("Inserisci GNP: ");
        Double gnp = input.nextDouble();
        input.nextLine();

        System.out.print("Inserisci GNP-OLD: ");
        Double gnpOld = input.nextDouble();
        input.nextLine();

        System.out.print("Inserisci il Local Name: ");
        String localName = input.nextLine();

        System.out.print("Inserisci il governament: ");
        String governmentForm = input.nextLine();

        System.out.print("Inserisci headOfState: ");
        String headOfState = input.nextLine();

        System.out.print("Inserisci capital: ");
        Integer capital = input.nextInt();
        input.nextLine();

        System.out.print("Inserisci code2: ");
        String code2 = input.nextLine();

        // SQL per inserire un nuovo paese nella tabella "country"
        String sql = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, " +
                "lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = createPreparedStatement(conn, sql)) {
            pstmt.setString(1, code.toUpperCase());
            pstmt.setString(2, name);
            pstmt.setString(3, continent);
            pstmt.setString(4, region);
            pstmt.setDouble(5, surfaceArea);

            if (indepYear != null) {
                pstmt.setInt(6, indepYear);
            } else {
                pstmt.setNull(6, Types.INTEGER);
            }

            pstmt.setLong(7, population);
            pstmt.setDouble(8, lifeExpectancy);
            pstmt.setDouble(9, gnp);
            pstmt.setDouble(10, gnpOld);
            pstmt.setString(11, localName);
            pstmt.setString(12, governmentForm);
            pstmt.setString(13, headOfState);
            pstmt.setInt(14, capital);
            pstmt.setString(15, code2.toUpperCase());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Nuovo paese aggiunto con successo.");
            } else {
                System.out.println("Errore nell'inserimento del nuovo paese.");
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento del paese: " + e.getMessage());
            throw e;
        }
    }

    public static PreparedStatement createPreparedStatement(Connection conn, String query) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            return pstmt;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
