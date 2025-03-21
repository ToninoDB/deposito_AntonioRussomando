package com.example.carrozzeria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.model.enums.Stato;
import com.example.carrozzeria.service.OfficinaService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/veicoli")
public class OfficinaController {
    private final OfficinaService officinaService;

    public OfficinaController(OfficinaService officinaService) {
        this.officinaService = officinaService;
    }

    // Ricerca per tutti i veicoli
    @GetMapping
    public List<Veicolo> getAllVehicles() {
        return officinaService.getAllVehicles();
    }

    // Ricerca per la targa
    @GetMapping("/{targa}")
    public ResponseEntity<Veicolo> findByTarga(@PathVariable String targa) {
        Optional<Veicolo> veicolo = officinaService.findByTarga(targa);
        return veicolo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Aggiunta di un nuovo veicolo
    @PostMapping
    public ResponseEntity<Veicolo> aggiungiVeicolo(@RequestBody Veicolo veicolo) {
        Veicolo nuovoVeicolo = officinaService.addVehicle(veicolo);
        URI location = URI.create("/api/veicoli/" + veicolo.getId());
        return ResponseEntity.created(location).body(nuovoVeicolo);
    }

    // Modifica stato di riparazione veicolo
    @PatchMapping("/{id}")
    public ResponseEntity<Veicolo> updateVehicleState(@PathVariable Long id, @RequestParam Stato stato) {
        Optional<Veicolo> updatedVehicle = Optional.ofNullable(officinaService.patchVehicle(id, stato));
        Veicolo veicolo = updatedVehicle.get();
        if (updatedVehicle.isPresent()) {
            URI location = URI.create(String.format("api/vehicles/%s", veicolo.getTarga()));
            return ResponseEntity.created(location).body(veicolo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Rimozione veicolo completato
    @DeleteMapping("/{targa}")
    public ResponseEntity<Void> deleteVeicolo(@PathVariable String targa) {
        boolean delete = officinaService.deleteByTarga(targa);

        return delete ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    // Metodo per la restituzione del numero di veicoli in base allo stato
    @GetMapping("/statoRiparazione")
    public Map<Stato, Long> getAllByStato() {
        return officinaService.returnByStato();
    }

}
