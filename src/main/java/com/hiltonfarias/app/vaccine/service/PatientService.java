package com.hiltonfarias.app.vaccine.service;

import com.hiltonfarias.app.vaccine.domain.Patient;
import com.hiltonfarias.app.vaccine.mapper.PatientMapper;
import com.hiltonfarias.app.vaccine.repository.PatientRepository;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public List<Patient> listAll() {
        return patientRepository.findAll();
    }

    public Patient findByIdOrThrowBadRequestException(Long id) {
        return patientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient id not found."));
    }

    public Patient save(PatientPostRequestsBody patientPostRequestsBody) {
        return patientRepository.save(PatientMapper.INSTANCE.toPatient(patientPostRequestsBody));
    }

    public void delete(Long id) {
        patientRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(PatientPutRequestsBody patientPutRequestsBody) {
        Patient savedPatient = findByIdOrThrowBadRequestException(patientPutRequestsBody.getId());
        Patient patient = PatientMapper.INSTANCE.toPatient(patientPutRequestsBody);
        patient.setId(savedPatient.getId());
        patientRepository.save(patient);
    }
}
