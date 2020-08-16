package fr.ibformation.bo;

import java.time.LocalDateTime;

public class Voiture {
	
	private String plaque;
	private LocalDateTime DateHeureEntree;
	
	public Voiture() {
		
	}

	public Voiture(String plaque) {
		this.plaque = plaque;
	}
	
	

	public Voiture(String plaque, LocalDateTime dateHeureEntree) {
		super();
		this.plaque = plaque;
		DateHeureEntree = LocalDateTime.now();
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public LocalDateTime getDateHeureEntree() {
		return DateHeureEntree;
	}

	public void setDateHeureEntree(LocalDateTime dateHeureEntree) {
		DateHeureEntree = dateHeureEntree;
	}

	@Override
	public String toString() {
		return "Voiture [plaque=" + plaque + ", DateHeureEntree=" + DateHeureEntree + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plaque == null) ? 0 : plaque.hashCode());
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
		Voiture other = (Voiture) obj;
		if (plaque == null) {
			if (other.plaque != null)
				return false;
		} else if (!plaque.equals(other.plaque))
			return false;
		return true;
	}
	
}