package com.proyecto_Dientes_Limpios.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_Dientes_Limpios.interfaces.IcitaService;
import com.proyecto_Dientes_Limpios.modelo.CitaModel;
import com.proyecto_Dientes_Limpios.modelo.InvitadoModel;
import com.proyecto_Dientes_Limpios.modelo.PacienteRModel;
import com.proyecto_Dientes_Limpios.repository.CitasRepository;
import com.proyecto_Dientes_Limpios.repository.InvitadoRepository;
import com.proyecto_Dientes_Limpios.repository.PacienteRepository;

@Service
public class CitaService implements IcitaService {
	
	@Autowired
	private CitasRepository citaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnvioEmail mailService;
	
	@Autowired
	private InvitadoRepository invitadoRepository;
	
	
	public PacienteRModel getCitaByID(Long id) {
		Optional<PacienteRModel> user = pacienteRepository.findById(id);
		return user.orElse(null);
	}
	
	public List<CitaModel> getCitas() {
		return  (List<CitaModel>) citaRepository.findAll();
	}


	public CitaModel guardarCita(CitaModel cita){
		
		 String horas[] = {"9:00:00","9:30:00","10:00:00","11:00:00","12:00:00","12:30:00","13:00:00","15:00:00","15:30:00","16:00:00"};
		 int index = 0;
		
		 ArrayList<CitaModel> lista = (ArrayList<CitaModel>) citaRepository.findAll();

		 CitaModel citaG;
		 /*Primero encontrar las citas con la fecha*/
	     for (int i = 0; i < lista.size(); i++) {

	    	 if(lista.get(i).getFechaC().toString().equals(cita.getFechaC().toString())) {
	        	index++;
	    	 }
				
		}
	     
	     System.out.println(cita.getInvitado().getId());
	     //Verificamos que hay citas disponibles
	     if(index<10) {
	    	 cita.setHoraC(horas[index]);
	    	  
	    	 if(cita.getInvitado().getId() != 0) {
	    		 cita.setCita(null);
	    		 citaG = citaRepository.save(cita);
	    		 Optional<InvitadoModel> invitado = invitadoRepository.findById( cita.getInvitado().getId());
	    		 mensaje(invitado.get().getCorreo(), cita.getHoraC(), cita.getFechaC().toString());
	    	 }else {
	    		 cita.setInvitado(null);
	    		 citaG = citaRepository.save(cita);
	    		 Optional<PacienteRModel> user = pacienteRepository.findById(cita.getCita().getId());
	    		 System.out.println(user.get().getCorreo());
	    		 mensaje(user.get().getCorreo(),cita.getHoraC(), cita.getFechaC().toString());
	    	 }
		     
		     return citaG;	
	     }else {
	    	 return null; 
	     }
	     
	     
  
		 
	}
     
	public void mensaje(String correo, String hora, String fecha) {
		System.out.println("envio de mail "+ correo);
		mailService.sendEmail(correo, "Cita Confirmada", "Muchas gracias por haber agendando en el Consultorio Dental Dientes Limpios, tu cita fue agendada el dia "+fecha+" a la hora de "+hora);
	}
	
	public void mensajeError(String correo, String hora, String fecha) {
		System.out.println("envio de mail "+ correo);
		mailService.sendEmail(correo, "Cita no disponible", "Muchas gracias por haber agendando en el Consultorio Dental Dientes Limpios, pero lamentablemente no tenemos horarios disponibles, no eres tu es el sistema :(");
	}

	// eliminar
	public void eliminar(Long idC) {
		citaRepository.deleteById(idC);
	}
	

}
