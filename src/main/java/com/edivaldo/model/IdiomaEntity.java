package com.edivaldo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "idioma")
//@Data
public class IdiomaEntity implements Serializable {
	
	private static final long serialVersionUID = -1995008769486167671L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String codigoIdioma;
	private String idioma;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoIdioma() {
		return codigoIdioma;
	}
	public void setCodigoIdioma(String codigoIdioma) {
		this.codigoIdioma = codigoIdioma;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
