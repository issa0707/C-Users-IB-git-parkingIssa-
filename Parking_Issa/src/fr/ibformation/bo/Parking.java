package fr.ibformation.bo;

import java.util.ArrayList;
import java.util.List;

import fr.ibformation.service.PaiementService;
import fr.ibformation.service.PaiementServiceImpl;

public class Parking {
	
	private final int NOMBRE_PLACE_MAX = 5;
	private final int TARIF_BASE = 50;
	private final int MINUTES_AVANT_SUPPLEMENT = 10;
	private final int TARIF_SUPPLEMENTAIRE = 4;
	List<Voiture> voitures = new ArrayList<>();
	
	public Parking() {
	}

	public Parking(List<Voiture> voitures) {
		super();
		this.voitures = voitures;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public int getNOMBRE_PLACE_MAX() {
		return NOMBRE_PLACE_MAX;
	}
	
	public int getNbrPlacesRestantes() {
		return NOMBRE_PLACE_MAX - getVoitures().size();
	}
	
	public double sortirVoiture(String plaque) {
		double prix = 0;
		PaiementService paiementService = new PaiementServiceImpl();
		int indice = this.getVoitures().indexOf(new Voiture(plaque)); 
		if (indice != -1) {
			prix = paiementService.calculPaiement(this.getVoitures().get(indice), this.TARIF_BASE, this.TARIF_SUPPLEMENTAIRE, this.MINUTES_AVANT_SUPPLEMENT);
			this.getVoitures().remove(indice);
		}		
		return prix;
	}

	@Override
	public String toString() {
		return "Parking [NOMBRE_PLACE_MAX=" + NOMBRE_PLACE_MAX + ", voitures=" + voitures + "]";
	}
	
}