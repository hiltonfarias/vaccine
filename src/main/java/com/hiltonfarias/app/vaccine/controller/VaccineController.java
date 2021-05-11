package com.hiltonfarias.app.vaccine.controller;

import com.hiltonfarias.app.vaccine.domain.Vaccine;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePutRequestsBody;
import com.hiltonfarias.app.vaccine.service.VaccineService;
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
@RequestMapping("vaccine")
@RequiredArgsConstructor
public class VaccineController {

    private VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<List<Vaccine>> list() {
        return new ResponseEntity<>(vaccineService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Vaccine> findVaccineById(@PathVariable Long id) {
        return new ResponseEntity<>(vaccineService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vaccine> save(@RequestBody VaccinePostRequestsBody vaccinePostRequestsBody) {
        return new ResponseEntity<>(vaccineService.save(vaccinePostRequestsBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vaccineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VaccinePutRequestsBody vaccinePutRequestsBody) {
        vaccineService.replace(vaccinePutRequestsBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
