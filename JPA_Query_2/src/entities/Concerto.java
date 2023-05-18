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
@NamedQuery(name = "findByName", query = "SELECT d FROM Concerto d WHERE d.titolo = :titolo")

public class Concerto extends Evento{
	
	private Genere genere;
	private boolean inStreaming;
	
	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo,
			int numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazioni, Genere genere,
			boolean inStreaming) {
		
		super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, location, partecipazioni);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}
	
	
}
