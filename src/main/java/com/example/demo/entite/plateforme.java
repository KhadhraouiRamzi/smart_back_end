package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.*; 

@Entity
public class plateforme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id  ;	
	private  Date cdate  ;
	private  String nom  ;
	private  Date datep  ;
	private  float part  ;
	private  Date udate ;


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

	public Date getDatep() {
		return datep;
	}

	public void setDatep(Date datep) {
		this.datep = datep;
	}

	public float getPart() {
		return part;
	}

	public void setPart(float part) {
		this.part = part;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}
 	
	public plateforme() {
		super();
	}
	
}
