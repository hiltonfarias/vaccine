package com.hiltonfarias.app.vaccine.service;

import com.hiltonfarias.app.vaccine.domain.Vaccine;
import com.hiltonfarias.app.vaccine.mapper.VaccineMapper;
import com.hiltonfarias.app.vaccine.repository.VaccineRepository;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineService {

    private VaccineRepository vaccineRepository;

    public List<Vaccine> listAll() {
        return vaccineRepository.findAll();
    }

    public Vaccine findByIdOrThrowBadRequestException(Long id) {
        return vaccineRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vaccine id not found"));
    }

    public Vaccine save(VaccinePostRequestsBody vaccinePostRequestsBody) {
        return vaccineRepository.save(VaccineMapper.INSTANCE.toVaccine(vaccinePostRequestsBody));
    }

    public void delete(Long id) {
        vaccineRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(VaccinePutRequestsBody vaccinePutRequestsBody) {
        Vaccine savedVaccine = findByIdOrThrowBadRequestException(vaccinePutRequestsBody.getId());
        Vaccine vaccine = VaccineMapper.INSTANCE.toVaccine(vaccinePutRequestsBody);
        vaccine.setId(savedVaccine.getId());
        vaccineRepository.save(vaccine);
    }
}
