package com.proyecto_Dientes_Limpios.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.modelo.ComentariosModel;
import com.proyecto_Dientes_Limpios.repository.ComentarioRepository;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository postRepository;
	
	public ArrayList<ComentariosModel> obtenerComentarios(){
		return(ArrayList<ComentariosModel>) postRepository.findAll();
	}
	
	public ComentariosModel guardarComentarios(ComentariosModel ComentariosModel) {
		return postRepository.save(ComentariosModel);
	}
	
	//actualizar
	public ComentariosModel actualizar(ComentariosModel ComentariosModel) {
		return postRepository.save(ComentariosModel);
	}
}
