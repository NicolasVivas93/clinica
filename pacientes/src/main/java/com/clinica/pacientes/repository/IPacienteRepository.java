package com.clinica.pacientes.repository;

import com.clinica.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    
    @Query(value = "SELECT * FROM paciente p WHERE p.dni = :dni", nativeQuery = true)
    public Paciente findByDni(String dni);
}
