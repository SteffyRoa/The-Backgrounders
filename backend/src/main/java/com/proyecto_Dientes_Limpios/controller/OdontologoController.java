package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto_Dientes_Limpios.modelo.OdontologoModel;
import com.proyecto_Dientes_Limpios.service.OdontologoService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

	@Autowired
	private OdontologoService service;

	@GetMapping()
	public ResponseEntity<List<OdontologoModel>> getAllUsers(){
		List<OdontologoModel> odontologos = null;
	try {
			odontologos = service.obtenerOdontologo();
			System.out.println(odontologos);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(odontologos);

	}
}
