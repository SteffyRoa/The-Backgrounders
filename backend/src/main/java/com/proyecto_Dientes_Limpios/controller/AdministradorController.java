package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.AdministradorModel;
import com.proyecto_Dientes_Limpios.service.AdministradorService;



	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("/administrador")
	public class AdministradorController {
		
		@Autowired
		private AdministradorService service;
		
		@GetMapping()
		public ResponseEntity<List<AdministradorModel>> getAllUsers(){
			List<AdministradorModel> pacientesR = null;
			try {
				pacientesR = service.getUser();
				System.out.println(pacientesR);
			}catch(Exception ex) {
				ex.getMessage();
			}
			return ResponseEntity.status(HttpStatus.OK).body(pacientesR);
		}
		
}
