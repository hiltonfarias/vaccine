package com.hiltonfarias.app.vaccine.repository;

import com.hiltonfarias.app.vaccine.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
