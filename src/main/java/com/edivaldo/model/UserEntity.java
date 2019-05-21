package com.edivaldo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
//@Data
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = -1995008769486167671L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private Long idTwitter;

	private byte[] name;
	private Long seguidores;
	private byte[] codigoIdioma;
	private String idioma;
	private byte[] pais;
	private byte[] timeZone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdTwitter() {
		return idTwitter;
	}
	public void setIdTwitter(Long idTwitter) {
		this.idTwitter = idTwitter;
	}
	public byte[] getName() {
		return name;
	}
	public void setName(byte[] name) {
		this.name = name;
	}
	public Long getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(Long seguidores) {
		this.seguidores = seguidores;
	}
	public byte[] getCodigoIdioma() {
		return codigoIdioma;
	}
	public void setCodigoIdioma(byte[] codigoIdioma) {
		this.codigoIdioma = codigoIdioma;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public byte[] getPais() {
		return pais;
	}
	public void setPais(byte[] pais) {
		this.pais = pais;
	}
	public byte[] getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(byte[] timeZone) {
		this.timeZone = timeZone;
	}

}
