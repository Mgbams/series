package fr.orsys.kingsley.series.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String acheminement;

	@Column(name="code_insee")
	private String codeInsee;

	@Column(name="code_postal")
	private String codePostal;

	@Column(name="cordonnees_gps")
	private String cordonneesGps;

	private double latitude;

	private String libelle;

	private double longitude;

	private String nom;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="ville")
	private List<Utilisateur> utilisateurs;

	public Ville() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcheminement() {
		return this.acheminement;
	}

	public void setAcheminement(String acheminement) {
		this.acheminement = acheminement;
	}

	public String getCodeInsee() {
		return this.codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCordonneesGps() {
		return this.cordonneesGps;
	}

	public void setCordonneesGps(String cordonneesGps) {
		this.cordonneesGps = cordonneesGps;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setVille(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setVille(null);

		return utilisateur;
	}

}