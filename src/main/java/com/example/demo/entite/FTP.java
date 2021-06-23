package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class FTP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date cdate;
	private String haut;
	private String identifiant;
	private String mp;
	private Integer port;

	@OneToOne
	private user user;

    @Transient
    private Integer idUser = new Integer(0);

	public Integer getIdUser() {
         return this.user!=null?this.user.getId():this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
 
	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
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

	public String getHaut() {
		return haut;
	}

	public void setHaut(String haut) {
		this.haut = haut;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public FTP() {
		super();
	}

}
