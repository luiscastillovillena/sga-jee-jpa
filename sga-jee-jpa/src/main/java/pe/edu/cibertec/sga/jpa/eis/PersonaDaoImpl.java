 package pe.edu.cibertec.sga.jpa.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.cibertec.sga.jpa.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao{

	@PersistenceContext(unitName="PersonaPU") 
	EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas() {
		return em.createNamedQuery("Persona.findAll").getResultList();
	}
	
	public Persona findPersonaById(Persona persona) {
		return em.find(Persona.class, persona.getIdPersona());
	}

	public Persona findPersonaByEmail(Persona persona) {
		// Se define una consulta
		Query query = em.createQuery("from Persona p where p.email = :parEmail");
		
		// parEmail es usado en la anterior consulta
		// aqui se define su contenido
		query.setParameter("parEmail", persona.getEmail());
		
		// Ejecuci�n de la consulta
		return (Persona) query.getSingleResult();
	}

	public void insertPersona(Persona persona) {
		em.persist(persona);
	}

	public void updatePersona(Persona persona) {
		em.merge(persona);		// merge pone el obj. en la transacci�n para que pueda
								// ser reconocido por el API JPA y para revisar si 
								// hay una diferencia con el registro en memoria y el
								// valor que se encuentra en la bd. Si hay una diferencia
								// entonces al hacer commit de manera autom�tica el API 
								// har� el update.
	}

	public void deletePersona(Persona persona) {
		em.merge(persona);
		em.remove(persona);		// No se puede borrar directamente si no esta en 
								// memoria.
	}
}
