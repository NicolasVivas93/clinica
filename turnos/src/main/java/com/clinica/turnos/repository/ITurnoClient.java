package com.clinica.turnos.repository;

import com.clinica.turnos.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "pacienteapi", url = "http://localhost:9001/paciente/traerdni")
public interface ITurnoClient {
    
    @GetMapping("/{dniPaciente}")
    @ResponseBody
    public Paciente getPacientePorDni(@PathVariable("dniPaciente") String dniPac);
}
