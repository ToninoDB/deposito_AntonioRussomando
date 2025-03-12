package com.example.carrozzeria.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.model.enums.Stato;
import com.example.carrozzeria.repository.VeicoloRepository;

import jakarta.transaction.Transactional;

@Service
public class OfficinaService {
    private final VeicoloRepository veicoloRepository;

    public OfficinaService(VeicoloRepository veicoloRepository) {
        this.veicoloRepository = veicoloRepository;
    }

    public List<Veicolo> getAllVehicles() {
        return veicoloRepository.findAll();
    }

    public Optional<Veicolo> findByTarga(String targa) {
        return veicoloRepository.findByTarga(targa);
    }

    @Transactional
    public Veicolo addVehicle(Veicolo v) {
        return veicoloRepository.save(v);
    }

    public Veicolo patchVehicle(Long id, Stato newState) {
        return veicoloRepository.findById(id).map(veicolo -> {
            veicolo.setStatoRiparazione(newState);
            return veicoloRepository.save(veicolo);
        }).orElse(null);
    }

    @Transactional
    public boolean deleteByTarga(String targa) {
        Optional<Veicolo> veicoloPresente = veicoloRepository.findByTarga(targa);

        if (veicoloPresente.isPresent()) {
            veicoloRepository.deleteByTarga(targa);
            return true;
        } else
            return false;

    }

    public Map<Stato, Long> returnByStato() {
        return veicoloRepository.countByStatoRiparazione().stream()
                .collect(Collectors.toMap(
                        result -> (Stato) result[0], // Stato di riparazione
                        result -> (Long) result[1] // Conteggio
                ));
    }

}
