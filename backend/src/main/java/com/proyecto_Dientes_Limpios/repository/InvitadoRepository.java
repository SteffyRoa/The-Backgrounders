package com.proyecto_Dientes_Limpios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_Dientes_Limpios.modelo.InvitadoModel;

@Repository
public interface InvitadoRepository extends CrudRepository<InvitadoModel, Long> {

}
