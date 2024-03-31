package com.clinica.pacientes.service;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService {
    
    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }
    
    @Override
    public void savePaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }
    
    @Override
    public void editPaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPacienteByDni(String dni) {
        return pacienteRepo.findByDni(dni);
    }

    
}
