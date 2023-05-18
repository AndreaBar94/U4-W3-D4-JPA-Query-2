package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor

public class Location {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String city;
	
	public Location(String nome, String city) {
		super();
		this.nome = nome;
		this.city = city;
	}
	
	
}
