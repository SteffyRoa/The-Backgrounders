package com.proyecto_Dientes_Limpios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.AdministradorModel;
import com.proyecto_Dientes_Limpios.repository.AdministradorRepository;


@Service
public class AdministradorService {
	
	
	@Autowired
	private AdministradorRepository AdministradorRepository;
	
	public ArrayList<AdministradorModel> obtenerComentarios(){
		return(ArrayList<AdministradorModel>) AdministradorRepository.findAll();
	}

	public List<AdministradorModel> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
