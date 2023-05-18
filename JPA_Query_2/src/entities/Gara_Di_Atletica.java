package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Gara_Di_Atletica extends Evento{
	
	@OneToMany
	private Set<Persona> setAtleti;
	
	@OneToOne
	private Persona vincitore;

	public Gara_Di_Atletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo,
			int numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazioni,
			Set<Persona> setAtleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, location, partecipazioni);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

	
	
}
