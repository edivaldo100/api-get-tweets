package com.edivaldo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "tweets")
//@Data
public class TweetsEntity implements Serializable {
	
	private static final long serialVersionUID = -1995008769486167671L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	private byte[] hashTagText;
	
	@OneToOne(cascade=CascadeType.ALL)
	private HashTagEntity hashTag;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getHashTagText() {
		return hashTagText;
	}

	public void setHashTagText(byte[] hashTagText) {
		this.hashTagText = hashTagText;
	}

	public HashTagEntity getHashTag() {
		return hashTag;
	}

	public void setHashTag(HashTagEntity hashTag) {
		this.hashTag = hashTag;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
