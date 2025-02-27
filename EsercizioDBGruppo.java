import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EsercizioDBGruppo {
    public static void main(String[] args) {
        // Dati di connessione
        String DB_URL = "jdbc:mysql://192.168.1.98:3306/world?serverTimezone=UTC";
        String DB_USERNAME = "utente_remoto"; // Sostituisci con il tuo username
        String DB_PASSWORD = "ToninoDB"; // Sostituisci con la tua password

        Connection conn = null;

        try {
            // Carica il driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crea la connessione
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connessione riuscita al database remoto!");

            creaViewIta(conn);

            aggiungiCittaItaliane(conn);

            // Chiudi le risorse

            conn.close();
            System.out.println("Connessione chiusa.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void creaViewIta(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String createViewSql = "CREATE OR REPLACE VIEW italian_cities_view AS " +
                    "SELECT city.name, city.district, city.population " +
                    "FROM city " +
                    "WHERE city.countrycode = 'ITA'";

            String query = "SELECT * FROM italian_cities_view";

            // Esegui la query
            stmt.executeUpdate(createViewSql);
            ResultSet rs = stmt.executeQuery(query);

            int i = 1;

            // Leggi i risultati e stampali
            while (rs.next()) {
                String nome = rs.getString("Name");
                String distretto = rs.getString("District");
                int popolazione = rs.getInt("population");

                System.out.println(i + " | " + nome + " | " + distretto + " | " + popolazione);
                i++;
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Metodo per aggiungere 10 nuove città italiane
    public static void aggiungiCittaItaliane(Connection conn) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM city",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = pstmt.executeQuery();

            // Lista delle nuove città da inserire
            String[][] nuoveCitta = {
                    { "Nocera Superiore", "ITA", "Campania", "24000" },
                    { "Nocera Inferiore", "ITA", "Campania", "48000" },
                    { "Cava dé Tirreni", "ITA", "Campania", "60000" },
                    { "Roccapiemonte", "ITA", "Campania", "10000" },
                    { "Castel San Giorgio", "ITA", "Campania", "10000" },
                    { "Siano", "ITA", "Campania", "7000" },
                    { "Bracigliano", "ITA", "Campania", "6000" },
                    { "Mercato San Severino", "ITA", "Campania", "12000" },
                    { "Fisciano", "ITA", "Campania", "15000" },
                    { "Casali di Roccapiemonte", "ITA", "Campania", "2000" },
                    { "San Potito", "ITA", "Campania", "200" },
                    { "Sant'Eustachio", "ITA", "Campania", "200" }
            };

            // Inserimento delle nuove città
            for (String[] citta : nuoveCitta) {
                rs.moveToInsertRow();
                rs.updateString("Name", citta[0]);
                rs.updateString("CountryCode", citta[1]);
                rs.updateString("District", citta[2]);
                rs.updateInt("Population", Integer.parseInt(citta[3]));
                rs.insertRow();
            }

            System.out.println("10 città italiane aggiunte con successo!");
        }
    }
}
