package dev.etimbuk.sequencegeneratordemo.services;

import dev.etimbuk.sequencegeneratordemo.models.Patient;
import dev.etimbuk.sequencegeneratordemo.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient createPatient(final Patient patient) {
        return patientRepository.save(patient);
    }

    @PostConstruct
    public void initData() {
        IntStream.rangeClosed(1, 100).forEach(index -> {
           final var patient = Patient.builder()
               .firstName("Etimbuk")
               .lastName(String.valueOf(index))
               .gender("F")
               .contactNumber(String.valueOf(index))
               .address("Just the address "+ index)
               .email(String.format("%s@test.com", index))
               .dateOfBirth(LocalDate.now().minusDays(index))
               .registrationDate(LocalDateTime.now().minusHours(index))
               .build();
           patientRepository.save(patient);
        });
    }
}
