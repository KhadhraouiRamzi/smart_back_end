package com.example.demo.entite;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class chanson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date cdate;
	private String nom;
	private String genre;
	private Date datec;
	private String type;
	private String rbt_src;
	private String featuring;
	private Date udate;

	@ManyToOne
	private album album;

	@ManyToOne
	private user user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "paltforme_chanson", joinColumns = @JoinColumn(name = "chanson_id"), inverseJoinColumns = @JoinColumn(name = "platforme_id"))
	private Set<plateforme> platformes = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "operateur_chanson", joinColumns = @JoinColumn(name = "chanson_id"), inverseJoinColumns = @JoinColumn(name = "operateur_id"))
	private Set<operateur> operateurs= new HashSet<>();

	/*
	 * @ManyToMany(mappedBy = "details", fetch = FetchType.LAZY) private
	 * Set<details> details = new HashSet<>(); 
	 * 
	 * 
	 * @Transient private Integer idDetail = new Integer(0);
	 * 
	 */

/*	@Transient
	private Integer idUser = new Integer(0);*//*

	public Integer getIdUser() {
		return this.user != null ? this.user.getId() : this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDatec() {
		return datec;
	}

	public void setDatec(Date datec) {
		this.datec = datec;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRbt_src() {
		return rbt_src;
	}

	public void setRbt_src(String rbt_src) {
		this.rbt_src = rbt_src;
	}

	public String getFeaturing() {
		return featuring;
	}

	public void setFeaturing(String featuring) {
		this.featuring = featuring;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public album getAlbum() {
		return album;
	}

	public void setAlbum(album album) {
		this.album = album;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}


	public Set<plateforme> getPlatformes() {
		return platformes;
	}

	public void setPlatformes(Set<plateforme> platformes) {
		this.platformes = platformes;
	}

	public Set<operateur> getOperateurs() {
		return operateurs;
	}

	public void setOperateurs(Set<operateur> operateurs) {
		this.operateurs = operateurs;
	}

	public chanson() {
		super();
	}

	public chanson(Integer id, Date cdate, String nom, String genre, Date datec, String type, String rbt_src, String featuring, Date udate, com.example.demo.entite.album album, com.example.demo.entite.user user, Set<plateforme> platformes, Set<operateur> operateurs) {
		this.id = id;
		this.cdate = cdate;
		this.nom = nom;
		this.genre = genre;
		this.datec = datec;
		this.type = type;
		this.rbt_src = rbt_src;
		this.featuring = featuring;
		this.udate = udate;
		this.album = album;
		this.user = user;
		this.platformes = platformes;
		this.operateurs = operateurs;
	}
}
