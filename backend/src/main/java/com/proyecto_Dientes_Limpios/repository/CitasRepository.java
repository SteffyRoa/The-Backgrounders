package com.proyecto_Dientes_Limpios.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_Dientes_Limpios.modelo.CitaModel;

@Repository
public interface CitasRepository extends CrudRepository<CitaModel, Long> {


	
	//public abstract ArrayList<CitaModel> (Integer prioridad);

}
