package com.proyecto_Dientes_Limpios.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_Dientes_Limpios.modelo.ComentariosModel;
import com.proyecto_Dientes_Limpios.service.ComentarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/coment")
public class ComentarioController {
	@Autowired
	private ComentarioService postService;
	
	//Obtener los datos del Posts
	@GetMapping() // http://localhost: 80800/comentarios
	public ArrayList<ComentariosModel> obtenerComentarios(){
		return postService.obtenerComentarios();
	}
	
	@PostMapping() //http: localhost: 80800/comentarios
	public ComentariosModel guardarComentarios(@RequestBody ComentariosModel postModel) {
		return this.postService.guardarComentarios(postModel);
	}
}
