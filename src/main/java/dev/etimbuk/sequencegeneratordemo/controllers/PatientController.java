package dev.etimbuk.sequencegeneratordemo.controllers;

import dev.etimbuk.sequencegeneratordemo.models.Patient;
import dev.etimbuk.sequencegeneratordemo.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/v1/patients", "/patients"})
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }
}
