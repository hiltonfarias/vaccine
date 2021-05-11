package com.hiltonfarias.app.vaccine.requests.requestPatient;

//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientPutRequestsBody {

    private Long id;

    @NotBlank(message = "Patient's name cannot be white")
    private String name;

    @NotBlank(message = "The application requires an email")
//    @Schema(description = "This is a valid email", example = "teste@email.com", required = true)
    private String email;

    @NotBlank(message = "The application requires a cpf")
//    @Schema(description = "This is a valid cpf", example = "000.000.000-00", required = true)
    private String cpf;

    private LocalDate birthDate;

}
