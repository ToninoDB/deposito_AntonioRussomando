package com.example.carrozzeria.model.enums;

public enum Stato {
    IN_ATTESA("In attesa di conferma"),
    IN_LAVORAZIONE("Lavorazione in corso"),
    COMPLETATO("Completato");

    private String descrizione;

    Stato(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
