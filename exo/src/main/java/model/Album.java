package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

    @ManyToOne
    @JoinColumn(name ="artiste_id")
	private Artiste artiste;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "date_sortie")
	private Date dateDeSortie;
	
	@Column(name = "duree")
	private int dureeEnSeconde;
	
	public Album() {

	}
	
	public Album(long id, Artiste artiste, String titre, Date dateDeSortie, int dureeEnSeconde) {
		super();
		this.id = id;
		this.artiste = artiste;
		this.titre = titre;
		this.dateDeSortie = dateDeSortie;
		this.dureeEnSeconde = dureeEnSeconde;
	}
	public Artiste getArtiste() {
		return artiste;
	}
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDeSortie() {
		return dateDeSortie;
	}
	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}
	public int getDureeEnSeconde() {
		return dureeEnSeconde;
	}
	public void setDureeEnSeconde(int dureeEnSeconde) {
		this.dureeEnSeconde = dureeEnSeconde;
	}

	
	
}
