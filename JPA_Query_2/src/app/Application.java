package app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PersonaDAO;
import entities.Concerto;
import entities.Evento;
import entities.Gara_Di_Atletica;
import entities.Genere;
import entities.Location;
import entities.Partecipazione;
import entities.Partita_Di_Calcio;
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;
import utils.JpaUtil;

public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		EventoDAO sd = new EventoDAO(em);
		PersonaDAO pDAO = new PersonaDAO(em);
		LocationDAO lDAO = new LocationDAO(em);
		
		Persona aldo = new Persona("Aldo", "Baglio", "aldobaglio@email.it", LocalDate.now(), Sesso.MASCHIO, new HashSet<>());
		Persona maria = new Persona("Maria", "Rossi", "mariarossi@email.it", LocalDate.now(), Sesso.FEMMINA, new HashSet<>());
		
		Location loc1 = new Location("Giardino Degli Aranci", "Roma");
		
		Evento cena1 = new Evento("Cena", LocalDate.now(), "Cena di beneficenza", TipoEvento.PRIVATO, 30, loc1, new HashSet<>());
		Evento cena2 = new Evento("Pranzo", LocalDate.now(), "Pranzo di beneficenza", TipoEvento.PUBBLICO, 50, loc1, new HashSet<>());
		Evento concerto1 = new Concerto("Queen", LocalDate.now(), "Concerto bello", TipoEvento.PUBBLICO, 50, loc1, new HashSet<>(), Genere.ROCK, false);
		Evento partita1 = new Partita_Di_Calcio("Derby", LocalDate.now(), "Derby Roma - Lazio", TipoEvento.PUBBLICO, 80000, loc1,  new HashSet<>(), "Roma", "Lazio", "Roma", 1, 1);
		Evento gara1 = new Gara_Di_Atletica("Nazionali Calisthenics", LocalDate.now(), "Finali di Calisthenics", TipoEvento.PUBBLICO, 100, loc1,  new HashSet<>(), new HashSet<>(), aldo);
		
		pDAO.save(maria);
		pDAO.save(aldo);
		lDAO.save(loc1);
		
		Partecipazione p1 = new Partecipazione(aldo, concerto1, Stato.CONFERMATA);
		Partecipazione p2 = new Partecipazione(aldo, cena2, Stato.CONFERMATA);
		
		
		Set<Partecipazione> lp1 = new HashSet<>();
//	
		cena1.getPartecipazioni().add(p1);
		cena2.getPartecipazioni().add(p2);
		concerto1.getPartecipazioni().add(p1);
		partita1.getPartecipazioni().add(p2);
		gara1.getPartecipazioni().add(p1);
		
		
		p1.setEvento(concerto1);
		p1.setPersona(maria);
		
		p2.setEvento(cena2);
		p2.setPersona(aldo);

		
		
//		logger.info("GUARDA QUI: "+ p1.getEvento());
//		sd.delete(47);
//		sd.delete(48);
		em.getTransaction().begin();
		em.persist(concerto1);
		em.persist(partita1);
		em.persist(gara1);
		em.persist(cena2);
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();

		sd.refresh(4);
		em.close();

		emf.close();
	}

}
