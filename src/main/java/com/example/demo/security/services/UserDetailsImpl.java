package com.example.demo.security.services;

import com.example.demo.entite.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date cdate  ;
	private Date udate;
	private  String nom  ;
	private  String prenom  ;
	private byte[] image ;
	private  String nArtistique  ;
	private  String phone  ;
	private  String email  ;
	private  Date date  ;
	private  String nationnalite  ;
	private  String cin  ;
	private  Date datecin  ;
	private  Byte[] contrat  ;
	private double part  ;
	private double retenu ;
	private  String proposition ;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, Date cdate, Date udate, String nom, String prenom, byte[] image, String nArtistique, String phone, String email, Date date, String nationnalite, String cin, Date datecin, Byte[] contrat, double part, double retenu, String proposition, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.cdate = cdate;
		this.udate = udate;
		this.nom = nom;
		this.prenom = prenom;
		this.image = image;
		this.nArtistique = nArtistique;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.nationnalite = nationnalite;
		this.cin = cin;
		this.datecin = datecin;
		this.contrat = contrat;
		this.part = part;
		this.retenu = retenu;
		this.proposition = proposition;
		this.password = password;
		this.authorities = authorities;
	}

/*	public UserDetailsImpl(Integer id, String email, String password, List<GrantedAuthority> authorities) {
	}*/

	/*public UserDetailsImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}*/

	public static UserDetailsImpl build(user user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(),
				user.getCdate(),
				user.getUdate(),
				user.getNom(),
				user.getPrenom(),
				user.getImage(),
				user.getnArtistique(),
				user.getPhone(),
				user.getEmail(),
				user.getDate(),
				user.getNationnalite(),
				user.getCin(),
				user.getDatecin(),
				user.getContrat(),
				user.getPart(),
				user.getRetenu(),
				user.getProposition(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
