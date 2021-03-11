package com.example.demo.entite;

 
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class chanson {

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
 		  		
 		@ManyToOne(cascade = CascadeType.ALL)
 		private album album;

		@ManyToOne(cascade = CascadeType.ALL)
		private user user;

		
		@ManyToOne
		private plateforme plateforme;
		 		
  	  /*
 		@ManyToMany(mappedBy = "details", fetch = FetchType.LAZY)
 	    private Set<details> details = new HashSet<>();
  		

 		@Transient
 		private Integer idDetail  = new Integer(0);
 		
*/
 		 
 		
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

		public plateforme getPlateforme() {
			return plateforme;
		}

		public void setPlateforme(plateforme plateforme) {
			this.plateforme = plateforme;
		}

		public chanson() {
			super();
		}
		
}
 
