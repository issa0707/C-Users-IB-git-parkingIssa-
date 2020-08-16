package fr.ibformation.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import fr.ibformation.bo.Voiture;
import fr.ibformation.dao.ParkingDAO;
import fr.ibformation.dao.ParkingDAOImpl;

public class PaiementServiceImpl implements PaiementService {

	@Override
	public double calculPaiement(Voiture voiture, int tarifBase, int tarifSupp, int minutesAvantSupp) {
		double prix = tarifBase;
		double minuteDansParking = ChronoUnit.MINUTES.between(voiture.getDateHeureEntree(), LocalDateTime.now());
		if (minuteDansParking > minutesAvantSupp) {
			prix =+ (minuteDansParking - minutesAvantSupp) * tarifSupp; 
		}
		return prix/100;
	}

	@Override
	public void entrerVoiture(Voiture voiture) {
		ParkingDAO parkingDAO = new ParkingDAOImpl();
		parkingDAO.entrerVoiture(voiture);
				
	}

	@Override
	public void sortirVoiture(String plaque) {
		ParkingDAO parkingDAO = new ParkingDAOImpl();
		parkingDAO.sortirVoiture(plaque);		
	}
	
	public List<Voiture> findAll(){
		ParkingDAO parkingDAO = new ParkingDAOImpl();
		return parkingDAO.findAll();
	}

}
