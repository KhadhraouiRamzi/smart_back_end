package com.example.demo.entite;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id  ;
    private Date cdate  ;
    private Date udate;
    private  String nom  ;
    private  String prenom  ;
    private  Byte[] image ;
    private  String nArtistique  ;
    private  String phone  ;
    private  String email  ;
    private  String password;
    private  Date date  ;
    private  String nationnalite  ;
    private  String cin  ;
    private  Date datecin  ;
    private  Byte[] contrat  ;
    private  float part  ;
    private  float retenu ;
    private  String proposition ;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<role> roles = new HashSet<>();

    @ManyToOne
    private marketing marketing;


    public user() {
    }

    public marketing getMarketing() {
        return marketing;
    }

    public void setMarketing(marketing marketing) {
        this.marketing = marketing;
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

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<role> getRoles() {
        return roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getDatecin() {
        return datecin;
    }

    public void setDatecin(Date datecin) {
        this.datecin = datecin;
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

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
