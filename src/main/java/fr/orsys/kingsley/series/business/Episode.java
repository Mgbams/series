package fr.orsys.kingsley.series.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the episode database table.
 * 
 */
@Entity
@NamedQuery(name="Episode.findAll", query="SELECT e FROM Episode e")
public class Episode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="duree_en_minutes")
	private int dureeEnMinutes;

	private String nom;

	//bi-directional many-to-one association to Saison
	@ManyToOne
	private Saison saison;

	public Episode() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDureeEnMinutes() {
		return this.dureeEnMinutes;
	}

	public void setDureeEnMinutes(int dureeEnMinutes) {
		this.dureeEnMinutes = dureeEnMinutes;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Saison getSaison() {
		return this.saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

}