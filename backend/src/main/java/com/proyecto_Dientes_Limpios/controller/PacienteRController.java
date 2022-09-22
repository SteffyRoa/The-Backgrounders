package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;
import com.proyecto_Dientes_Limpios.service.PacienteRService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientesR")
public class PacienteRController {
	
	@Autowired
	private PacienteRService service;
	
	@GetMapping()
	public ResponseEntity<List<PacienteRModel>> getAllUsers(){

		List<PacienteRModel> pacientesR = null;
		try {
			pacientesR = service.getUser();
			System.out.println(pacientesR);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(pacientesR);
	}
	
	@PostMapping()
	public PacienteRModel guardarUsuario(@RequestBody PacienteRModel usuario){
        return this.service.guardarUsuario(usuario);
    }
	
	@GetMapping("/login") 
    public PacienteRModel getPost(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena) {
        return this.service.getUserId(correo, contrasena);
    }
		

}
