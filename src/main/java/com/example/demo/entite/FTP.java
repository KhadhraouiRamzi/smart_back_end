package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class FTP {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  Integer id  ;	
		private  Date cdate  ;
		private String haut;
		private  Integer port  ;	
		private  String nomU  ;
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
