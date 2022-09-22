package com.proyecto_Dientes_Limpios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.ComentariosModel;
import com.proyecto_Dientes_Limpios.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository postRepository;
	
	public List<ComentariosModel> obtenerComentarios(){
		return (List<ComentariosModel>) postRepository.findAll();
	}
	
	public ComentariosModel guardarComentarios(ComentariosModel ComentariosModel) {
		return postRepository.save(ComentariosModel);
	}
	
	//actualizar
	public ComentariosModel actualizar(ComentariosModel ComentariosModel) {
		return postRepository.save(ComentariosModel);
	}
}
