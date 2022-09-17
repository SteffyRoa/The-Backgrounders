package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.CitaModel;
import com.proyecto_Dientes_Limpios.service.CitaService;


@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	@GetMapping( path = "/citas/{id}")
	public ResponseEntity<List<CitaModel>> obtenerUsuarioPorId(@PathVariable("id") int id) {
		List<CitaModel> citas = null;
		try {
			citas = citaService.getCitaByID(id);
			System.out.println(citas);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(citas);
	}
	
	@PostMapping()
	public CitaModel guardarUsuario(@RequestBody CitaModel cita){
        return this.citaService.guardarCita(cita);
    }
}
