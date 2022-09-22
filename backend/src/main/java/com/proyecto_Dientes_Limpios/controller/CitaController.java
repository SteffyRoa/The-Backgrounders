package com.proyecto_Dientes_Limpios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.CitaModel;
import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;
import com.proyecto_Dientes_Limpios.service.CitaService;


@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	@GetMapping( path = "/{id}")
	public Object obtenerUsuarioPorId(@PathVariable("id") Long id) {
		PacienteRModel citas = citaService.getCitaByID(id);
		
       return citas.getCitas();

	}
	
	@GetMapping()
	public ResponseEntity<List<CitaModel>> obtenerCitas() {
		List<CitaModel> citas = null;
		try {
			citas = citaService.getCitas();
			System.out.println(citas);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(citas);
	}
	
	@PostMapping("/usuarios")
	public CitaModel agendarPacienteR(@RequestBody CitaModel cita){
        return this.citaService.guardarCita(cita);
    }
	
	@PostMapping("/invitados")
	public CitaModel agendarInvitado(@RequestBody CitaModel cita){
        return this.citaService.guardarCita(cita);
    }
	
	// Eliminar usuario
	@DeleteMapping(path = "eliminar/{id}") 
	public void eliminar(@PathVariable Long id) {
		citaService.eliminar(id);
	}
}
