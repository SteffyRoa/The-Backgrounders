package com.proyecto_Dientes_Limpios.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.OdontologoModel;
import com.proyecto_Dientes_Limpios.repository.OdontologoRepository;

@Service
public class OdontologoService {

	@Autowired
	private OdontologoRepository OdontologoRepository;

	public ArrayList<OdontologoModel> obtenerOdontologo(){
		return(ArrayList<OdontologoModel>) OdontologoRepository.findAll();
	}
}
