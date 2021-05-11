package com.hiltonfarias.app.vaccine.mapper;

import com.hiltonfarias.app.vaccine.domain.Vaccine;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestsVaccine.VaccinePutRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class VaccineMapper {
    public static final VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    public abstract Vaccine toVaccine(VaccinePostRequestsBody vaccinePostRequestsBody);
    public abstract Vaccine toVaccine(VaccinePutRequestsBody vaccinePutRequestsBody);
}
