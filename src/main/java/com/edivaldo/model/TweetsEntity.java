package com.edivaldo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetsEntity implements Serializable {
	
	private static final long serialVersionUID = -1995008769486167671L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String hashTagText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashTagText() {
		return hashTagText;
	}

	public void setHashTagText(String hashTagText) {
		this.hashTagText = hashTagText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashTagText == null) ? 0 : hashTagText.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TweetsEntity other = (TweetsEntity) obj;
		if (hashTagText == null) {
			if (other.hashTagText != null)
				return false;
		} else if (!hashTagText.equals(other.hashTagText))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
