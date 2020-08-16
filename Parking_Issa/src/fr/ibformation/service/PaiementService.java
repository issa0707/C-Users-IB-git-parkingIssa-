package fr.ibformation.service;

import java.util.List;

import fr.ibformation.bo.Parking;
import fr.ibformation.bo.Voiture;

public interface PaiementService {
	
	Parking parking = new Parking();
	
	public double calculPaiement(Voiture voiture, int tarifBase, int tarifSupp, int minutesAvantSupp);

	public void entrerVoiture(Voiture voiture);

	public void sortirVoiture(String plaque);
	
	public List<Voiture> findAll();
	
}
