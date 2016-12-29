package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import pe.edu.cibertec.sga.jpa.domain.Persona;
import pe.edu.cibertec.sga.jpa.servicio.PersonaService;

public class PersonaServiceTest {
	private PersonaService personaService;
	
	@Before
	public void setUp() throws Exception{
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		
		personaService = (PersonaService) 
				contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!pe.edu.cibertec.sga.jpa.servicio.PersonaService");
		
	}
	
	@Test
	public void testEJBPersonaService(){
		System.out.println("iniciando test EJB PersonaService");
		
		assertTrue(personaService != null);

		// El numero de registros a comparar debe ser igual al que hay en la tabla "personas"		
		assertEquals(5, personaService.listarPersonas().size());
		
		System.out.println("El número de personas es igual a:" + personaService.listarPersonas().size());
		
		this.desplegarPersonas(personaService.listarPersonas());
		
		System.out.println("Fin test EJB PersonalService");				
		
	}

	private void desplegarPersonas(List<Persona> personas) {
		for (Persona persona: personas){
			System.out.println(persona);
		}
		
	}
	
	
}
