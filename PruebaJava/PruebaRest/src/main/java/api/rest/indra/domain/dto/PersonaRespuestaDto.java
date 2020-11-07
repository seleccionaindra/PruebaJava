package api.rest.indra.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Dto que mapea los datos de las personas
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Data
@Builder(toBuilder = true)
@ApiModel(description = "Dto que mapea los datos de las personas")
public class PersonaRespuestaDto
{
    @ApiModelProperty("Identificador")
    private Long  id;
    @ApiModelProperty("Nombres")
    private String  nombres;
    @ApiModelProperty("Apellidos")
    private String  apellidos;
    @ApiModelProperty("Cedula")
    private Long    cedula;
    @ApiModelProperty("Genero")
    private String  genero;
    @ApiModelProperty("Edad")
    private Integer edad;
    
}
