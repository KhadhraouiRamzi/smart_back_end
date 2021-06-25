package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;



@Entity
public class historique {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  Integer id  ;	
		private  Date cdate  ;
		private  Byte[] contrat  ;
		private  String partBen  ;
		private  float montPaye  ;
		private  float montNPaye  ;
		private  float retenu  ;
		private  Date  udate  ;
		
		@ManyToOne
		private user user;
		
		@ManyToOne
		private marketing marketing;

		@OneToOne
		private details details;

	public details getDetails() {
		return details;
	}

	public void setDetails(details details) {
		this.details = details;
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

		public Byte[] getContrat() {
			return contrat;
		}

		public void setContrat(Byte[] contrat) {
			this.contrat = contrat;
		}

		public String getPartBen() {
			return partBen;
		}

		public void setPartBen(String partBen) {
			this.partBen = partBen;
		}

		public float getMontPaye() {
			return montPaye;
		}

		public void setMontPaye(float montPaye) {
			this.montPaye = montPaye;
		}

		public float getMontNPaye() {
			return montNPaye;
		}

		public void setMontNPaye(float montNPaye) {
			this.montNPaye = montNPaye;
		}

		public float getRetenu() {
			return retenu;
		}

		public void setRetenu(float retenu) {
			this.retenu = retenu;
		}

		public Date getUdate() {
			return udate;
		}

		public void setUdate(Date udate) {
			this.udate = udate;
		}

		public user getUser() { return user; }

		public void setUser(user user) { this.user = user; }

		public marketing getMarketing() {
			return marketing;
		}

		public void setMarketing(marketing marketing) {
			this.marketing = marketing;
		}

		public historique() {
			super();
		}
		
}
