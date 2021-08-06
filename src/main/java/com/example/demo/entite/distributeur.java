package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class distributeur {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  Integer id  ;	
		private  Date cdate  ;
		private  String nomd  ;
		private  Date udate  ;
		
		@ManyToOne
		private plateforme plateforme;
		
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
		public String getNomd() {
			return nomd;
		}
		public void setNomd(String nomd) {
			this.nomd = nomd;
		}
		public Date getUdate() {
			return udate;
		}
		public void setUdate(Date udate) {
			this.udate = udate;
		}
		public plateforme getPlateforme() {
			return plateforme;
		}
		public void setPlateforme(plateforme plateforme) {
			this.plateforme = plateforme;
		}
		
		
}
