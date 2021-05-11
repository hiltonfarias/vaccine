package com.hiltonfarias.app.vaccine.mapper;

import com.hiltonfarias.app.vaccine.domain.Application;
import com.hiltonfarias.app.vaccine.requests.requestApplication.ApplicationRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ApplicationMapper {

    public static final ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    public abstract Application toApplication(ApplicationRequestsBody applicationRequestsBody);
}
