package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partecipazione")
@Getter
@Setter
@NoArgsConstructor

public class Partecipazione {
	
	@Id
	@GeneratedValue
	private UUID id;
	private Stato stato;
	
	@ManyToOne
	@JoinColumn(name = "evento", referencedColumnName = "id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "persona", referencedColumnName = "id")
	private Persona persona;
	
	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		super();
		
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}
	
	
}
