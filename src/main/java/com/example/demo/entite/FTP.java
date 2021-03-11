package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.*;


@Entity
public class FTP {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  Integer id  ;	
		private  Date cdate  ;
		private String haut;
		private  Integer port  ;	
		private  String nomU  ;

		@OneToOne
		private user user;

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
		public String getNomU() {
			return nomU;
		}
		public void setNomU(String nomU) {
			this.nomU = nomU;
		}	

		
		public FTP() {
			super();
		}
 
		
}
