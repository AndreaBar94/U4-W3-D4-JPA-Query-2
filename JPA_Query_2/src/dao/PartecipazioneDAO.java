package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Partecipazione;

public class PartecipazioneDAO {

	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Partecipazione s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Partecipazione salvata");
	}

	public Partecipazione findById(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void delete(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Partecipazione con id " + id + " eliminata!");
		}
	}

	public void refresh(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		if(found != null) {
			found.setEvento(null);
			found.setPersona(null);
			found.setStato(null);
			System.out.println("PRE REFRESH");
			System.out.println(found);
			em.refresh(found);
			System.out.println("POST REFRESH");
			System.out.println(found);
		}else {
			System.out.println("Nessuna Partecipazione trovata");
		}
		
	}
}
