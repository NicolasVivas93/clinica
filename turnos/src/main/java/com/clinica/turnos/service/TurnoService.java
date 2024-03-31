
package com.clinica.turnos.service;

import com.clinica.turnos.model.Paciente;
import com.clinica.turnos.model.Turno;
import com.clinica.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService {
    
    @Autowired
    private ITurnoRepository turnoRepo;
    
    @Autowired
    private RestTemplate apiConsumir;

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
        
        Paciente paciente = apiConsumir.getForObject("http://localhost:9001/paciente/traerdni/" + dniPaciente, Paciente.class);    
        String nombreCompletoPaciente = paciente.getNombre() + " " + paciente.getApellido();
        
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setMotivoTurno(motivo);
        turno.setNombrePaciente(nombreCompletoPaciente);
        
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
