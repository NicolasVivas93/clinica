
package com.clinica.turnos.controller;

import com.clinica.turnos.dto.TurnoDto;
import com.clinica.turnos.model.Paciente;
import com.clinica.turnos.model.Turno;
import com.clinica.turnos.repository.ITurnoClient;
import com.clinica.turnos.service.ITurnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    
    @Autowired
    private ITurnoService turnoServ;
    
    @Autowired
    private ITurnoClient turnoClient;
    
    @PostMapping("/crear")
    public String createTurno(@RequestBody TurnoDto turno) {
        turnoServ.saveTurno(turno.getFecha(), turno.getMotivoTurno(), turno.getDniPaciente());
        return "Turno creado";
    }
    
    @GetMapping("/traer")
    public List<Turno> getTurnos() {
        return turnoServ.getTurnos();
    }
    
    // Llamada desde Feign
    @GetMapping("/traerPorDni/{dniPaciente}")
    public Paciente getPacientePorDni(@PathVariable ("dniPaciente") String dniPaciente) {
        return turnoClient.getPacientePorDni(dniPaciente);
    }
    
    @GetMapping("/buscar/{id}")
    public Turno findTurno(@PathVariable Long id) {
        return turnoServ.findTurno(id);
    }
    
    @PutMapping("/editar/{idOrig}")
    public Turno editTurno(@PathVariable Long idOrig, @RequestBody Turno turnoModif) {
        turnoServ.editTurno(idOrig, turnoModif);
        Turno turnoEditado = turnoServ.findTurno(idOrig);
        return turnoEditado;
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id) {
        turnoServ.deleteTurno(id);
        return "Turno eliminado";
    }
    
}
