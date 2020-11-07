package api.rest.indra.exceptions.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto que mape los datos de los errores del api
 * @author Kaleth Bahena
 * @version 0.0.1 2020/10/26
 * @since 0.0.1 2020/10/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorMessageDto
{
    private int statusCode;
    private LocalDate timestamp;
    private String message;
    private String description;
}
