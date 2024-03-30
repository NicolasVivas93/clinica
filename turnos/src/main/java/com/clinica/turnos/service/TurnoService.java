
package com.clinica.turnos.service;

import com.clinica.turnos.model.Turno;
import com.clinica.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService {
    
    @Autowired
    private ITurnoRepository turnoRepo;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void saveTurno(LocalDate fecha, String motivo, String dniPaciente) {
        // Buscar el paciente en la api pacientes
        // Busco el paciente a través de la coincidencia con el dni
        // Paciente paciente = paciente traído de la api      
        // String nombreCompletoPaciente = traigo el nombre del paciente que consumí de la api y encontré a través del dni
        
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setMotivoTurno(motivo);
        //turno.setNombrePaciente();
        
        turnoRepo.save(turno);
    }

    @Override
    public void editTurno(Long idOrig, Turno turnoModif) {
        Turno turnoAModif = this.findTurno(idOrig);
        turnoAModif.setFecha(turnoModif.getFecha());
        turnoAModif.setMotivoTurno(turnoModif.getMotivoTurno());
        turnoAModif.setNombrePaciente(turnoModif.getNombrePaciente());
        
        turnoRepo.save(turnoAModif);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }
    
    
}
