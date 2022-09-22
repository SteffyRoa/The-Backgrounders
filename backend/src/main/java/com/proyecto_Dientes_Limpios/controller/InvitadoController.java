package com.proyecto_Dientes_Limpios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.InvitadoModel;
import com.proyecto_Dientes_Limpios.service.InvitadoService;

@RestController
@RequestMapping("/nueva")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class InvitadoController {


	@Autowired
	private InvitadoService service;
	
	@PostMapping()
	public InvitadoModel guardarUsuario(@RequestBody InvitadoModel invitado){
        return this.service.guardarInvitado(invitado);
    }
}
