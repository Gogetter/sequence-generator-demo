package dev.etimbuk.sequencegeneratordemo.repository;

import dev.etimbuk.sequencegeneratordemo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
