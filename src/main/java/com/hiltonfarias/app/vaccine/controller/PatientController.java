package com.hiltonfarias.app.vaccine.controller;

import com.hiltonfarias.app.vaccine.domain.Patient;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPutRequestsBody;
import com.hiltonfarias.app.vaccine.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController {

    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> listPatient() {
        return ResponseEntity.ok(patientService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientPostRequestsBody patientPostRequestsBody) {
        return new ResponseEntity<>(patientService.save(patientPostRequestsBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PatientPutRequestsBody patientPutRequestsBody) {
        patientService.replace(patientPutRequestsBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
