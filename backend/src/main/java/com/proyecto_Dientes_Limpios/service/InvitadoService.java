package com.proyecto_Dientes_Limpios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.InvitadoModel;
import com.proyecto_Dientes_Limpios.repository.InvitadoRepository;


@Service
public class InvitadoService {

	@Autowired
	private InvitadoRepository pacienteRepository;
	
	public InvitadoModel guardarInvitado(InvitadoModel invitado){
		 return pacienteRepository.save(invitado);	
	}
}
