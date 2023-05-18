package dao;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import entities.Persona;
import entities.Sesso;


public class PersonaDAO {
	
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Persona s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Persona salvata");
	}

	public Persona findById(String id) {
		Persona found = em.find(Persona.class, UUID.fromString(id));
		return found;
	}

	public void delete(long id) {
		Persona found = em.find(Persona.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Persona con id " + id + " eliminata!");
		}
	}

	public void refresh(long id) {
		Persona found = em.find(Persona.class, id);
		if(found != null) {
			found.setNome("Ugo");
		found.setCognome("Rossi");
		found.setDataDiNascita(LocalDate.now());
		found.setEmail("ugo.rossi@email.it");
		found.setGenere(Sesso.MASCHIO);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
		}else {
			System.out.println("Nessuna persona trovata");
		}
		
	}
}
