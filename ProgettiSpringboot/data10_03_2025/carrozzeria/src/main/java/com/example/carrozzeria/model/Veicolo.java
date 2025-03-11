package com.example.carrozzeria.model;

import java.util.Date;

import com.example.carrozzeria.model.enums.Stato;

public class Veicolo {
    private int id;
    private String marca;
    private String targa;
    private Date dataIngressoOfficina;
    private Stato statoRiparazione;

    public Veicolo(int id, String marca, String targa, Date dataIngressoOfficina, Stato statoRiparazione) {
        this.id = id;
        this.marca = marca;
        this.targa = targa;
        this.dataIngressoOfficina = dataIngressoOfficina;
        this.statoRiparazione = statoRiparazione;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTarga() {
        return targa;
    }

    public Date getDataIngressoOfficina() {
        return dataIngressoOfficina;
    }

    public Stato getStatoRiparazione() {
        return statoRiparazione;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setDataIngressoOfficina(Date dataIngressoOfficina) {
        this.dataIngressoOfficina = dataIngressoOfficina;
    }

    public void setStatoRiparazione(Stato statoRiparazione) {
        this.statoRiparazione = statoRiparazione;
    }

}
