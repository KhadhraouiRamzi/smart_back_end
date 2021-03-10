package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class hist_communication {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  Integer id  ;	
		private  Date cdate  ;
		private  String nom  ;
		private  String genre  ;
		private  Date datec  ;
		private  String type  ;
		private  String rbt_src  ;
		private  String featuring  ;
 		private  Date udate  ;
 		  		

		@ManyToOne
		private communication communication;
		

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


		public communication getCommunication() {
			return communication;
		}


		public void setCommunication(communication communication) {
			this.communication = communication;
		}

 
		
}
