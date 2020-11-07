package api.rest.indra.infrastucture.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad encargada de mapear los datos de las personas
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Data
@Entity
@Table(name = "personas")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Persona
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    
    @Column(nullable = false)
    private String nombres; 
    
    @Column(nullable = false)
    private String apellidos;
    
    @Column(nullable = false)
    private Long cedula;
    
    @Column(nullable = false, length = 1)
    private String genero;
    
    @Column(nullable = false)
    private Integer edad;
}
