package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date cdate;
	private String nom;
	private Date dateF;
	private float part;
	private float montant;
	private String proposition;
	private Date udate;
	 
	
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
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public float getPart() {
		return part;
	}
	public void setPart(float part) {
		this.part = part;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getProposition() {
		return proposition;
	}
	public void setProposition(String proposition) {
		this.proposition = proposition;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}


}
