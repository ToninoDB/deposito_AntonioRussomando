package com.example.carrozzeria.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.model.enums.Stato;

@Service
public class OfficinaService {
    private final ArrayList<Veicolo> veicoli = new ArrayList<>(List.of(
            new Veicolo(1, "Fiat", "AB123CD", new Date(), Stato.IN_ATTESA),
            new Veicolo(2, "Ford", "BC234DE", new Date(), Stato.IN_LAVORAZIONE),
            new Veicolo(3, "BMW", "CD345EF", new Date(), Stato.COMPLETATO),
            new Veicolo(4, "Audi", "DE456FG", new Date(), Stato.IN_LAVORAZIONE),
            new Veicolo(5, "Mercedes", "EF567GH", new Date(), Stato.IN_ATTESA)));

    public ArrayList<Veicolo> getAllVehicles() {
        return veicoli;
    }

    public Optional<Veicolo> findByTarga(String targa) {
        return veicoli.stream().filter(veicolo -> veicolo.getTarga().equals(targa)).findFirst();
    }

    public Veicolo addVehicle(Veicolo v) {
        veicoli.add(v);
        return v;
    }

    public Veicolo patchVehicle(int id, Stato newState) {
        for (Veicolo vehicle : veicoli) {
            if (vehicle.getId() == id) {
                vehicle.setStatoRiparazione(newState);
                return vehicle;
            }
        }
        return null;
    }

    public boolean deleteByTarga(String targa) {
        for (Veicolo veicolo : veicoli) {
            if (veicolo.getTarga().equals(targa)) {
                veicoli.remove(veicolo);
                return true;
            }
        }
        return false;
    }

    public Map<Stato, Long> returnByStato() {
        return veicoli.stream().collect(Collectors.groupingBy(Veicolo::getStatoRiparazione, Collectors.counting()));
    }
}
