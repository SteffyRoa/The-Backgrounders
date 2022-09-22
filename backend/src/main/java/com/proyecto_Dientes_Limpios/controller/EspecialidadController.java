package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.EspecialidadModel;
import com.proyecto_Dientes_Limpios.modelo.OdontologoModel;
import com.proyecto_Dientes_Limpios.service.EspecialidadService;
import com.proyecto_Dientes_Limpios.service.OdontologoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/especialidad")

public class EspecialidadController {
	
	@AutoWired 
	EspecialidadService service;

	
	@GetMapping()
	public ResponseEntity<List<EspecialidadModel>> getAllUsers(){
		List<EspecialidadModel> odontologos = null;

}
