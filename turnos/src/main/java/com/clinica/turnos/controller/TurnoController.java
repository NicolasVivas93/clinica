
package com.clinica.turnos.controller;

import com.clinica.turnos.model.Turno;
import com.clinica.turnos.service.ITurnoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    
    @Autowired
    private ITurnoService turnoServ;
    
    @PostMapping("/crear")
    public String createTurno(@RequestBody LocalDate fecha, @RequestBody String motivo, @RequestBody String dniPaciente) {
        turnoServ.saveTurno(fecha, motivo, dniPaciente);
        return "Turno creado";
    }
    
    @GetMapping("/traer")
    public List<Turno> getTurnos() {
        return turnoServ.getTurnos();
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
