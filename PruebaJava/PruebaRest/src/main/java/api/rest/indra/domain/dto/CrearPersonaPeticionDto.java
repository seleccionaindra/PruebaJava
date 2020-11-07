package api.rest.indra.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto que mapea los datos de la peticion para crear una nueva persona
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Data
@ApiModel(description = "Dto que mapea los datos de la peticion para crear una nueva persona")
public class CrearPersonaPeticionDto
{
    @ApiModelProperty("Nombres")
    @NotBlank(message = "El campo nombre es obligatorio")
    private String  nombres;
    @ApiModelProperty("Apellidos")
    @NotBlank(message = "El campo apellido es obligatorio")
    private String  apellidos;
    @ApiModelProperty("Cedula")
    @NotNull(message = "El campo cedula es obligatorio")
    private Long    cedula;
    @NotBlank(message = "El campo genero es obligatorio")
    @ApiModelProperty("Genero")
    private String  genero;
    @NotNull(message = "El campo edad es obligatorio")
    @ApiModelProperty("Edad")
    private Integer edad;
}
