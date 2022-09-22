package com.proyecto_Dientes_Limpios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;
import com.proyecto_Dientes_Limpios.repository.PacienteRepository;

@Service
public class PacienteRService  {

	@Autowired
	private PacienteRepository pacienteRepository;
	

	public List<PacienteRModel> getUser( ) {
        //ArrayList<PacienteRModel> lista = (ArrayList<PacienteRModel>) pacienteRepository.findAll();
		return (List<PacienteRModel>) pacienteRepository.findAll();
        //return pacienteRepository.findByNombre(nombre);
	}

	public PacienteRModel guardarUsuario(PacienteRModel usuario){
		//mensaje();
		 return pacienteRepository.save(usuario);	
	}
	
	
	public PacienteRModel getUserId(String correo, String contra){

        ArrayList<PacienteRModel> lista = (ArrayList<PacienteRModel>) pacienteRepository.findAll();

        PacienteRModel persona = new PacienteRModel(); 
        
        for (int i = 0; i < lista.size(); i++) {

        	if(correo.equals(lista.get(i).getCorreo())) {
        		if( contra.equals(lista.get(i).getContrasena()) ) {
	        		persona = lista.get(i);
        		}
        	}
			
		}
        
        return persona;

    }


	
	
	
	

}
