package com.proyecto_Dientes_Limpios.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.interfaces.IcitaService;
import com.proyecto_Dientes_Limpios.modelo.CitaModel;
import com.proyecto_Dientes_Limpios.repository.CitasRepository;

@Service
public class CitaService implements IcitaService {
	
	@Autowired
	private CitasRepository citaRepository;

	public List<CitaModel> getCitaByID(Integer id) {
		return  (List<CitaModel>) citaRepository.findAll();
	}


	public CitaModel guardarCita(CitaModel cita){
		 return citaRepository.save(cita);	
	}
     


}
