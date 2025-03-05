package data_04_03_2025.EsercizioVideoteca;

import java.util.ArrayList;

public class Videoteca {
    private ArrayList<Film> catalogoFilm;
    private ArrayList<Film> filmNoleggiati;
    private ArrayList<Utente> utentiRegistrati;
    final int MAX_NOLEGGIO = 3;

    // Costruttore
    public Videoteca() {
        this.catalogoFilm = new ArrayList<>();
        this.filmNoleggiati = new ArrayList<>();
        this.utentiRegistrati = new ArrayList<>();
    }

    // Metodo per aggiungere un film al catalogo
    public void aggiungiFilm(Film film) {
        for (Film f : catalogoFilm) {
            if (f.getTitolo().equalsIgnoreCase(film.getTitolo())) {
                System.out.println("Film già presente: " + film.getTitolo());
                return;
            }
        }
        catalogoFilm.add(film);
        System.out.println("Film aggiunto: " + film.getTitolo());
    }

    // Metodo per rimuovere un film al catalogo
    public void rimuoviFilm(String titolo) {
        for (int i = 0; i < catalogoFilm.size(); i++) {
            if (catalogoFilm.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                catalogoFilm.remove(i);
                System.out.println("Film rimosso: " + titolo);
                return; // Termina la ricerca dopo la rimozione
            }
        }
        System.out.println("Film non trovato: " + titolo);
    }

    // Metodo per registrare un utente nella lista
    public void registraUtente(Utente utente) {
        for (Utente u : utentiRegistrati) {
            if (u.getIdUtente().equalsIgnoreCase(utente.getIdUtente())) {
                System.out.println("Utente già registrato con ID: " + utente.getIdUtente());
                return; // Esce dal metodo senza aggiungere l'utente
            }
        }
        utentiRegistrati.add(utente);
        System.out.println(
                "Utente registrato con successo: " + utente.getNome() + " (ID: " + utente.getIdUtente() + ")");
    }

    // Metodo per la ricerca di un film per titolo
    public Film cercaFilmPerTitolo(String titolo) {
        for (Film film : catalogoFilm) {
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film;
            }
        }
        return null;
    }

    // Metodo per la ricerca di un film per anno di uscita
    public void cercaFilmPerAnno(int anno) {
        ArrayList<Film> filmAnno = new ArrayList<>();
        for (Film film : catalogoFilm) {
            if (film.getAnnoDiUscita() == anno) {
                filmAnno.add(film);
            }
        }

        if (filmAnno.isEmpty()) {
            System.out.println("Nessun film trovato per l'anno " + anno);
            return;
        }

        System.out.println("Film trovati per l'anno " + anno + ":");
        for (Film f : filmAnno) {
            System.out.println("- " + f);
        }

    }

    // Metodo per cercare un utente per id
    public Utente cercaUtentePerId(String id) {
        for (Utente utente : utentiRegistrati) {
            if (utente.getIdUtente().equalsIgnoreCase(id)) {
                return utente;
            }
        }
        return null;
    }

    // Metodo per cercare i film disponibili da poter noleggiare
    public Film disponibilitaFilm(String titolo) {
        for (Film film : catalogoFilm) {
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film;
            }
        }
        return null;
    }

    // Metodo che stampi i film noleggiati da un utente
    public void filmNoleggiatiDaUtente(String id) {
        Utente utente = cercaUtentePerId(id);
        if (utente != null) {
            utente.elencoNoleggi();
        } else {
            System.out.println("Utente non trovato con id = " + id);
        }
    }

    // Metodo per noleggiare un film
    public void noleggiaFilm(String idUtente, String titolo) {
        Utente u = cercaUtentePerId(idUtente);
        Film f = cercaFilmPerTitolo(titolo);

        if (u == null || f == null) {
            System.out.println("Utente o film non trovato");
            return;
        }

        if (u.getFilmNoleggiati().size() >= MAX_NOLEGGIO) {
            System.out
                    .println("L'utente " + u.getNome() + " ha raggiunto il limite massimo di noleggi: " + MAX_NOLEGGIO);
            return;
        }

        u.noleggiaFilm(f);
        catalogoFilm.remove(f);
        filmNoleggiati.add(f);
        System.out.println("Film noleggiato: " + f.getTitolo() + " da " + u.getNome());
    }

    // Metodo per restituire un film
    public void restituisciFilm(String idUtente, String titolo) {
        Utente u = cercaUtentePerId(idUtente);
        if (u == null) {
            System.out.println("Utente non trovato");
            return;
        }

        Film filmDaRestituire = u.restituisciFilm(titolo);
        if (filmDaRestituire != null) {
            filmNoleggiati.remove(filmDaRestituire);
            catalogoFilm.add(filmDaRestituire);
            System.out.println("Film restituito: " + filmDaRestituire.getTitolo() + " da " + u.getNome());
            return;
        }
        System.out.println("Film non trovato: " + titolo);
    }

    // Metodo che mostra i film noleggiati
    public void mostraFilmNoleggiati() {
        System.out.println("Film noleggiati:");
        for (Film film : filmNoleggiati) {
            System.out.println("- " + film);
        }
    }

    // Metodo che mostra i film nel catalogo
    public void mostraCatalogoFilm() {
        System.out.println("Catalogo film:");
        for (Film film : catalogoFilm) {
            System.out.println("- " + film);
        }
    }

    // Metodo per la stampa degli utenti registrati
    public void utentiRegistratiAllaVideoteca() {
        for (Utente u : utentiRegistrati) {
            System.out.println(u);
        }
    }
}
