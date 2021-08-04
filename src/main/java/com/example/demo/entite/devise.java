 package com.example.demo.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class devise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date cdate ;
	private String nomd;
	private String code;
	private float cours;
	private Date datecours;
	private Date udate ;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getCours() {
		return cours;
	}
	
	public float getCoursDate(Date date1 ,Date date2) {
		if(getDatecours().after(date1) && getDatecours().before(date2) )
		return this.getCours();
		else
			return 0;
	}
	
	public void setCours(float cours) {
		this.cours = cours;
	}
	public Date getDatecours() {
		return datecours;
	}
	public void setDatecours(Date datecours) {
		this.datecours = datecours;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	
	
}
