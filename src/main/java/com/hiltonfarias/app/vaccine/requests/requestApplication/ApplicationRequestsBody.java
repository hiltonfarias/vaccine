package com.hiltonfarias.app.vaccine.requests.requestApplication;

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
public class ApplicationRequestsBody {

    private Long id;

    @NotBlank(message = "The application requires an email")
//    @Schema(description = "This is a valid email", example = "teste@email.com", required = true)
    private String email;

    @NotBlank(message = "The application requires a vaccine name")
    private String nameVaccine;

    private LocalDate date;
}
