package com.example.demo.entite;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class ImageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String type;
	private byte[] picByte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public ImageModel() {
		super();
	}

	public ImageModel(String name, String type, byte[] picByte) {
		
		this.name =name;
		this.type = type;
		this.picByte = picByte;

	}

}
