package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.squadraVincente = :squadraVincente")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.squadraOspite = :squadraVincente")
@NamedQuery(name = "getPartitePareggiate", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.squadraVincente IS NULL")

public class Partita_Di_Calcio extends Evento{

	private String squadraDiCasa;
	private String ospite;
	private String squadraVincente;
	private int nGoalHome;
	private int nGoalAway;
	
	public Partita_Di_Calcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo,
			int numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazioni, String squadraDiCasa,
			String ospite, String squadraVincente, int nGoalHome, int nGoalAway) {
		super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, location, partecipazioni);
		this.squadraDiCasa = squadraDiCasa;
		this.ospite = ospite;
		this.squadraVincente = squadraVincente;
		this.nGoalHome = nGoalHome;
		this.nGoalAway = nGoalAway;
	}
	
}
