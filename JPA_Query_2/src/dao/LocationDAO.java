package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Location;

public class LocationDAO {
	
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Location s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Location salvata");
	}

	public Location findById(long id) {
		Location found = em.find(Location.class, id);
		return found;
	}

	public void delete(long id) {
		Location found = em.find(Location.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Location con id " + id + " eliminata!");
		}
	}

	public void refresh(long id) {
		Location found = em.find(Location.class, id);
		if(found != null) {
			found.setNome("Ugo");
		found.setCity("Roma");
		found.setNome("Giardino degli Aranci");
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
		}else {
			System.out.println("Nessuna Location trovata");
		}
		
	}
}
