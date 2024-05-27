package dev.etimbuk.sequencegeneratordemo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * CREATE TABLE patients (
 *     patient_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 *     first_name VARCHAR(50) NOT NULL,
 *     last_name VARCHAR(50) NOT NULL,
 *     date_of_birth DATE NOT NULL,
 *     gender CHAR(1) CHECK (gender IN ('M', 'F', 'O')),
 *     contact_number VARCHAR(15),
 *     email VARCHAR(100),
 *     address TEXT,
 *     registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 * );
 */
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(generator = "patients_patient_id_seq", strategy = AUTO)
    @SequenceGenerator(name = "patients_patient_id_seq", sequenceName = "patients_patient_id_seq", allocationSize = 1)
    private Long patientId;
    private String firstName;
    private String lastName;
    private String gender;
    private String contactNumber;
    private String email;
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private LocalDate dateOfBirth;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
    private LocalDateTime registrationDate;
}
