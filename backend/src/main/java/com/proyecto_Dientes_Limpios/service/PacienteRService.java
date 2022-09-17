package com.proyecto_Dientes_Limpios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.interfaces.IpacienteRService;
import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;
import com.proyecto_Dientes_Limpios.repository.PacienteRepository;

@Service
public class PacienteRService implements IpacienteRService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnvioEmail mailService;
	
	@Override
	public List<PacienteRModel> getUser() {
		return (List<PacienteRModel>) pacienteRepository.findAll();
	}

	public PacienteRModel guardarUsuario(PacienteRModel usuario){
		mensaje();
		 return pacienteRepository.save(usuario);	
	}
	
	public void mensaje() {
		System.out.println("envio de mail");
		mailService.sendEmail("com2173047251@gmail.com", "Hola", "Esto es una prueba");
	}
       
    
	

}
