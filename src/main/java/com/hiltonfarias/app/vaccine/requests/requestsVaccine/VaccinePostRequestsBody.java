package com.hiltonfarias.app.vaccine.requests.requestsVaccine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccinePostRequestsBody {

    @NotBlank(message = "Vaccine's name cannot be white")
    private String name;

    @NotBlank(message = "Laboratory's name cannot be white")
    private String laboratory;

    @NotBlank(message = "The vaccine type must not be white")
    private String typeOfVaccine;
}
