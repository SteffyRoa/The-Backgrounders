package com.proyecto_Dientes_Limpios.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteRModel, Long> {

	public abstract List<PacienteRModel> findByNombre(String nombre);

}
