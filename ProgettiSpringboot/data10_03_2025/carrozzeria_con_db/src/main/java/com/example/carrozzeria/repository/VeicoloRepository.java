package com.example.carrozzeria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.carrozzeria.model.Veicolo;

public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {
    Optional<Veicolo> findByTarga(String targa);

    void deleteByTarga(String targa);

    // Conta i veicoli raggruppati per stato di riparazione
    @Query("SELECT v.statoRiparazione, COUNT(v) FROM Veicolo v GROUP BY v.statoRiparazione")
    List<Object[]> countByStatoRiparazione();
}
