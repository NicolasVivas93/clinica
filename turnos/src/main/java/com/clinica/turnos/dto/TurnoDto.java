
package com.clinica.turnos.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TurnoDto {
    
    private LocalDate fecha;
    private String motivoTurno;
    private String dniPaciente;
    
}
