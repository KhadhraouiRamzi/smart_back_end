package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class communication {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
			private  Integer id  ;	
			private  Date cdate  ;
			private  String path  ;
			private  Byte[] image ;
			private  String url  ;
			private  Date dateC  ;
			private  String place  ;
			private  Date udate  ;


			@ManyToOne
			private artiste artiste;
			
			@ManyToOne
			private fournisseur fournisseur;

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

			public String getPath() {
				return path;
			}

			public void setPath(String path) {
				this.path = path;
			}

			public Byte[] getImage() {
				return image;
			}

			public void setImage(Byte[] image) {
				this.image = image;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public Date getDateC() {
				return dateC;
			}

			public void setDateC(Date dateC) {
				this.dateC = dateC;
			}

			public String getPlace() {
				return place;
			}

			public void setPlace(String place) {
				this.place = place;
			}

			public Date getUdate() {
				return udate;
			}

			public void setUdate(Date udate) {
				this.udate = udate;
			}

			public artiste getArtiste() {
				return artiste;
			}

			public void setArtiste(artiste artiste) {
				this.artiste = artiste;
			}

			public fournisseur getFournisseur() {
				return fournisseur;
			}

			public void setFournisseur(fournisseur fournisseur) {
				this.fournisseur = fournisseur;
			}
			
			
	}


