
package com.clinica.turnos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Turno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTurno;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    
    private String motivoTurno;
    private String nombrePaciente;
    private String obsTurno;
}
