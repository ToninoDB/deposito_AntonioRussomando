public class Film {
    private String titolo;
    private int annoDiUscita;

    // Costruttore
    public Film(String titolo, int annoDiUscita) {
        this.titolo = titolo;
        this.annoDiUscita = annoDiUscita;
    }

    // #region Getter & Setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDiUscita() {
        return annoDiUscita;
    }

    public void setAnnoDiUscita(int annoDiUscita) {
        this.annoDiUscita = annoDiUscita;
    }
    // #endregion

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                ", annoDiUscita=" + annoDiUscita +
                '}';
    }
}
