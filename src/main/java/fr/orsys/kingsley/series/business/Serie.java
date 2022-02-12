package fr.orsys.kingsley.series.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serie database table.
 * 
 */
@Entity
@NamedQuery(name="Serie.findAll", query="SELECT s FROM Serie s")
public class Serie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String nom;

	@Column(name="prix_en_euros")
	private float prixEnEuros;

	//bi-directional many-to-one association to Achat
	@OneToMany(mappedBy="serie")
	private List<Achat> achats;

	//bi-directional many-to-one association to Saison
	@OneToMany(mappedBy="serie")
	private List<Saison> saisons;

	public Serie() {
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

	public float getPrixEnEuros() {
		return this.prixEnEuros;
	}

	public void setPrixEnEuros(float prixEnEuros) {
		this.prixEnEuros = prixEnEuros;
	}

	public List<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Achat addAchat(Achat achat) {
		getAchats().add(achat);
		achat.setSerie(this);

		return achat;
	}

	public Achat removeAchat(Achat achat) {
		getAchats().remove(achat);
		achat.setSerie(null);

		return achat;
	}

	public List<Saison> getSaisons() {
		return this.saisons;
	}

	public void setSaisons(List<Saison> saisons) {
		this.saisons = saisons;
	}

	public Saison addSaison(Saison saison) {
		getSaisons().add(saison);
		saison.setSerie(this);

		return saison;
	}

	public Saison removeSaison(Saison saison) {
		getSaisons().remove(saison);
		saison.setSerie(null);

		return saison;
	}

}