package com.example.carrozzeria.model;

import java.util.Date;

import com.example.carrozzeria.model.enums.Stato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 7)
    private String targa;

    @Column(nullable = false)
    private Date dataIngressoOfficina;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Stato statoRiparazione;

    // Costruttore di default vuoto obbligatorio
    public Veicolo() {
    }

    public Veicolo(Long id, String marca, String targa, Date dataIngressoOfficina, Stato statoRiparazione) {
        this.id = id;
        this.marca = marca;
        this.targa = targa;
        this.dataIngressoOfficina = dataIngressoOfficina;
        this.statoRiparazione = statoRiparazione;
    }

    public Long getId() {
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

    public void setId(Long id) {
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