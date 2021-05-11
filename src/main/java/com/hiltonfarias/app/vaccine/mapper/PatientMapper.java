package com.hiltonfarias.app.vaccine.mapper;

import com.hiltonfarias.app.vaccine.domain.Patient;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPostRequestsBody;
import com.hiltonfarias.app.vaccine.requests.requestPatient.PatientPutRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    public static final PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    public abstract Patient toPatient(PatientPostRequestsBody patientPostRequestsBody);
    public abstract Patient toPatient(PatientPutRequestsBody patientPutRequestsBody);
}
