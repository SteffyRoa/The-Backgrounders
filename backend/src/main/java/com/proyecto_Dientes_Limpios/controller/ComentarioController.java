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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.ComentariosModel;
import com.proyecto_Dientes_Limpios.service.ComentarioService;


@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ComentarioController {

	@Autowired
	private ComentarioService postService;
	
	//Obtener los datos del Posts
	@GetMapping()
	public ResponseEntity<List<ComentariosModel>> obtenerComentarios(){
		List<ComentariosModel> comentarios = null;
		try {
			comentarios =  postService.obtenerComentarios();
			System.out.println(comentarios);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
	
	@PostMapping() //http: localhost: 80800/comentarios
	public ComentariosModel guardarComentarios(@RequestBody ComentariosModel postModel) {
		return this.postService.guardarComentarios(postModel);
	}
}
