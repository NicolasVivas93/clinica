
package com.clinica.turnos.service;

import com.clinica.turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;


public interface ITurnoService {
    
    public List<Turno> getTurnos();
    public Turno findTurno(Long id);
    
    public void saveTurno(LocalDate fecha, String motivo, String dniPaciente);
    
    public void editTurno(Long idOrig, Turno turnoModif);
    
    public void deleteTurno(Long id);
}
