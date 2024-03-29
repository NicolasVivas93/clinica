
package com.clinica.pacientes.controller;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.service.IPacienteService;
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
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    private IPacienteService pacienteServ;
    
    @GetMapping("/traer")
    public List<Paciente> getPacientes() {
        return pacienteServ.getPacientes();
    }
    
    @GetMapping("/traer/{id}")
    public Paciente findPaciente(@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }
    
    @PostMapping("/crear")
    public String savePaciente(@RequestBody Paciente paciente) {
        pacienteServ.savePaciente(paciente);
        return "Paciente creado";
    }
    
    @PutMapping("/editar")
    public Paciente editPaciente(@RequestBody Paciente paciente) {
        pacienteServ.editPaciente(paciente);
        return this.findPaciente(paciente.getId());
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteServ.deletePaciente(id);
        return "Paciente eliminado";
    }
    
}
