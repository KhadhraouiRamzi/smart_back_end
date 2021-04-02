package com.example.demo.entite;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import sun.text.resources.cldr.FormatData;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date cdate;
	private Date udate;
	private String nom;
	private String prenom;
	private byte[] image;

	public String name;
	private String type;
	private byte[] picByte;
	private File[] files;

	private String nArtistique;
	private String phone;
	private String email;
	private String password;
	private Date date;
	private String nationnalite;
	private String cin;
	private Date datecin;
	private Byte[] contrat;
	private double part = 0.0;
	private double retenu = 0.0;
	private String proposition;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<role> roles = new HashSet<>();

	@ManyToOne
	private marketing marketing;

	@Transient
	private Integer idMarketing = new Integer(0);

	@Transient
	private Integer idRole = new Integer(0);

	public Set<role> getRoles() {
		return roles;
	}

	public void setRoles(Set<role> roles) {
		this.roles = roles;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
		// return this.roles != null ? this.roles.getClass() : this.idRole;
	}

	public Integer getIdMarketing() {
		return this.marketing != null ? this.marketing.getId() : this.idMarketing;
	}

	public void setIdMarketing(Integer idMarketing) {
		this.idMarketing = idMarketing;
	}

	public marketing getMarketing() {
		return marketing;
	}

	public void setMarketing(marketing marketing) {
		this.marketing = marketing;
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getnArtistique() {
		return nArtistique;
	}

	public void setnArtistique(String nArtistique) {
		this.nArtistique = nArtistique;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDatecin() {
		return datecin;
	}

	public void setDatecin(Date datecin) {
		this.datecin = datecin;
	}

	public Byte[] getContrat() {
		return contrat;
	}

	public void setContrat(Byte[] contrat) {
		this.contrat = contrat;
	}

	public double getPart() {
		return part;
	}

	public void setPart(double part) {
		this.part = part;
	}

	public double getRetenu() {
		return retenu;
	}

	public void setRetenu(double retenu) {
		this.retenu = retenu;
	}

	public String getProposition() {
		return proposition;
	}

	public void setProposition(String proposition) {
		this.proposition = proposition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public user() {
		super();
	}

	public user(String name, String type, byte[] picByte) {

		this.name = name;
		this.type = type;
		this.picByte = picByte;

	}

	public user(Integer id, Integer idRole) {
		this.id = id;
		this.idRole = idRole;
	}

	public user(Integer id, Date cdate, Date udate, String nom, String prenom, byte[] image, String name, String type,
			byte[] picByte, String nArtistique, String phone, String email, String password, Date date,
			String nationnalite, String cin, Date datecin, Byte[] contrat, double part, double retenu,
			String proposition, Set<role> roles, com.example.demo.entite.marketing marketing) {
		super();
		this.id = id;
		this.cdate = cdate;
		this.udate = udate;
		this.nom = nom;
		this.prenom = prenom;
		this.image = image;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
		this.nArtistique = nArtistique;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.date = date;
		this.nationnalite = nationnalite;
		this.cin = cin;
		this.datecin = datecin;
		this.contrat = contrat;
		this.part = part;
		this.retenu = retenu;
		this.proposition = proposition;
		this.roles = roles;
		this.marketing = marketing;
	}

}
