package pe.edu.cibertec.sga.jpa.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pe.edu.cibertec.sga.jpa.domain.Persona;
import pe.edu.cibertec.sga.jpa.servicio.PersonaServiceRemote;

public class ClientePersonaService {
	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		
		try {
			// versión simplificada de Glashfish.
			// Si se usa otro servidor verificar en la documentación.
			
			Context jndi = new InitialContext();
			
			PersonaServiceRemote personaService = 
					(PersonaServiceRemote) jndi.lookup("java:global/sga-jee-jpa/PersonaServiceImpl!pe.edu.cibertec.sga.jpa.servicio.PersonaServiceRemote");
			
			List <Persona> personas = personaService.listarPersonas();
			
			for(Persona persona: personas){
				System.out.println(persona);
			}
			
			System.out.println("\nFin llamada EJB desde el cliente");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
}
