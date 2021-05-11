package com.hiltonfarias.app.vaccine.repository;

import com.hiltonfarias.app.vaccine.domain.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
}
