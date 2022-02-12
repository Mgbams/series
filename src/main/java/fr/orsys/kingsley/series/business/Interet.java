package fr.orsys.kingsley.series.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the interet database table.
 * 
 */
@Entity
@NamedQuery(name="Interet.findAll", query="SELECT i FROM Interet i")
public class Interet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String nom;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany
	@JoinTable(
		name="utilisateur_interets"
		, joinColumns={
			@JoinColumn(name="interets_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="utilisateurs_id")
			}
		)
	private List<Utilisateur> utilisateurs;

	public Interet() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}