package data_04_03_2025.EsercizioVideoteca;

import java.util.ArrayList;

public class Utente {
    private String idUtente;
    private String nome;
    private ArrayList<Film> filmNoleggiati;
    private static final int MAX_NOLEGGIO = 3;

    // Costruttore
    public Utente(String idUtente, String nome) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.filmNoleggiati = new ArrayList<>();
    }

    // Metodo per noleggiare un film
    public void noleggiaFilm(Film film) {

        if (filmNoleggiati.size() >= MAX_NOLEGGIO) {
            System.out.println("Hai raggiunto il limite massimo di noleggi: " + MAX_NOLEGGIO);
            return;
        }
        // Controllo che l'utente non abbia già noleggiato il film
        for (Film f : filmNoleggiati) {
            if (f.getTitolo().equals(film.getTitolo())) {
                System.out.println("Il film è già stato noleggiato: " + film.getTitolo());
                return;
            }
        }

        filmNoleggiati.add(film);
        System.out.println("Film noleggiato: " + film.getTitolo());
    }

    // Metodo per restituire un film
    public Film restituisciFilm(String titolo) {
        for (int i = 0; i < filmNoleggiati.size(); i++) {
            if (filmNoleggiati.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                Film film = filmNoleggiati.remove(i);
                System.out.println("Film restituito: " + titolo);
                return film;
            }
        }

        System.out.println("Film non trovato: " + titolo);
        return null;
    }

    // Metodo per restituire l'elenco dei film noleggiati dall'utente
    public void elencoNoleggi() {
        System.out.println("Elenco film noleggiati da " + nome);
        for (Film film : filmNoleggiati) {
            System.out.println("- " + film);
        }
    }

    // #region Getters and Setters
    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Film> getFilmNoleggiati() {
        return filmNoleggiati;
    }

    public void setFilmNoleggiati(ArrayList<Film> filmNoleggiati) {
        this.filmNoleggiati = filmNoleggiati;
    }
    // #endregion

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente='" + idUtente + '\'' +
                ", nome='" + nome + '\'' +
                ", filmNoleggiati=" + filmNoleggiati +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Utente utente = (Utente) o;

        if (!idUtente.equals(utente.idUtente))
            return false;
        return nome.equals(utente.nome);
    }
}
