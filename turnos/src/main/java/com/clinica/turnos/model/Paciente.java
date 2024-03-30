
package com.clinica.turnos.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Paciente {
    
    private Long id; 
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;   
    private String telefono;
}
