package com.proyecto_Dientes_Limpios.service;

import java.util.ArrayList;
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

	private void mensaje() {
		// TODO Auto-generated method stub
		
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
