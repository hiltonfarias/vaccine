package com.hiltonfarias.app.vaccine.repository;

import com.hiltonfarias.app.vaccine.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
