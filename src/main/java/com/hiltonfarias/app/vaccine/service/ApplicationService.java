package com.hiltonfarias.app.vaccine.service;

import com.hiltonfarias.app.vaccine.domain.Application;
import com.hiltonfarias.app.vaccine.domain.Patient;
import com.hiltonfarias.app.vaccine.domain.Vaccine;
import com.hiltonfarias.app.vaccine.mapper.ApplicationMapper;
import com.hiltonfarias.app.vaccine.mapper.PatientMapper;
import com.hiltonfarias.app.vaccine.mapper.VaccineMapper;
import com.hiltonfarias.app.vaccine.repository.ApplicationRepository;
import com.hiltonfarias.app.vaccine.repository.PatientRepository;
import com.hiltonfarias.app.vaccine.repository.VaccineRepository;
import com.hiltonfarias.app.vaccine.requests.requestApplication.ApplicationRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPutRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final VaccineRepository vaccineRepository;
    private final PatientRepository patientRepository;

    public List<Application> listAll() {
        return applicationRepository.findAll();
    }

    public Application findByIdOrThrowBadRequestException(Long id) {
        return applicationRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Application Id not found."));
    }

    public Application save(ApplicationRequestsBody applicationRequestsBody) {
        Patient patient = PatientMapper
                .INSTANCE
                .toPatient(
                        PatientPostRequestsBody
                                .builder()
                                .email(applicationRequestsBody.getEmail())
                                .build()
                );
        Vaccine vaccine = VaccineMapper
                .INSTANCE
                .toVaccine(
                        VaccinePostRequestsBody
                                .builder()
                                .name(applicationRequestsBody.getNameVaccine())
                                .build()
                );

        Application savedApplication = findByIdOrThrowBadRequestException(applicationRequestsBody.getId());
        return applicationRepository.save(ApplicationMapper
                .INSTANCE
                .toApplication(
                        ApplicationRequestsBody
                                .builder()
                                .id(savedApplication.getId())
                                .email(patient.getEmail())
                                .nameVaccine(vaccine.getName())
                                .date(LocalDate.now())
                                .build()
                ));

    }

    public void delete(Long id) {
        applicationRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ApplicationRequestsBody applicationRequestsBody) {
        Patient patient = PatientMapper
                .INSTANCE
                .toPatient(
                        PatientPutRequestsBody
                                .builder()
                                .email(applicationRequestsBody.getEmail())
                                .build()
                );
        Vaccine vaccine = VaccineMapper
                .INSTANCE
                .toVaccine(
                        VaccinePutRequestsBody
                                .builder()
                                .name(applicationRequestsBody.getNameVaccine())
                                .build()
                );
        Application savedApplication = findByIdOrThrowBadRequestException(applicationRequestsBody.getId());
        Application application = ApplicationMapper
                .INSTANCE
                .toApplication(
                        ApplicationRequestsBody
                                .builder()
                                .id(savedApplication.getId())
                                .email(patient.getEmail())
                                .nameVaccine(vaccine.getName())
                                .date(LocalDate.now())
                                .build()
                );
        applicationRepository.save(application);
    }
}
