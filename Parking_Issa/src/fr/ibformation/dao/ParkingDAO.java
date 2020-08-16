package fr.ibformation.dao;

import java.util.List;

import fr.ibformation.bo.Voiture;

public interface ParkingDAO {

	void entrerVoiture(Voiture voiture);

	void sortirVoiture(String plaque);
	
	public List<Voiture> findAll() ;

}