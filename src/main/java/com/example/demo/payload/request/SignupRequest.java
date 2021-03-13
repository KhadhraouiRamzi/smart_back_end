package com.example.demo.payload.request;

import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(min = 6, max = 40)
    private  String nom  ;

    @NotBlank
    @Size(min = 6, max = 40)
    private  String prenom  ;

    private  Byte[] image ;

    @NotBlank
    @Size(min = 6, max = 40)
    private  String nArtistique  ;

    @NotBlank
    @Size(min = 8, max = 11)
    private  String phone  ;

    @NotBlank
    @Size(min = 20, max = 40)
    private  String nationnalite  ;

    @NotBlank
    @Size(min = 8)
    private  String cin  ;

    private  Byte[] contrat  ;

    private  float part  ;

    private  float retenu ;

    @NotBlank
    @Size(min = 20, max = 40)
    private  String proposition ;

    private  Date date  ;

    private  Date datecin  ;

    private Date cdate  ;

    private Date udate;



  
/*    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }*/
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getnArtistique() {
        return nArtistique;
    }

    public void setnArtistique(String nArtistique) {
        this.nArtistique = nArtistique;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Byte[] getContrat() {
        return contrat;
    }

    public void setContrat(Byte[] contrat) {
        this.contrat = contrat;
    }

    public float getPart() {
        return part;
    }

    public void setPart(float part) {
        this.part = part;
    }

    public float getRetenu() {
        return retenu;
    }

    public void setRetenu(float retenu) {
        this.retenu = retenu;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatecin() {
        return datecin;
    }

    public void setDatecin(Date datecin) {
        this.datecin = datecin;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }
}
