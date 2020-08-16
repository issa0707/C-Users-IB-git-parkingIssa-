package fr.ibformation.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.ibformation.bo.Parking;
import fr.ibformation.bo.Voiture;
import fr.ibformation.service.PaiementService;
import fr.ibformation.service.PaiementServiceImpl;

public class Laucher {

	public static void main(String[] args) {
		
		PaiementService paiementService = new PaiementServiceImpl();

		Parking parking = new Parking();

		//Voiture voiture = new Voiture();

		
		Scanner sc = new Scanner(System.in);
		String plaque;
		afficherMenu(parking);

		int saisie;
		do {
			List<Voiture> voitures = new ArrayList<>();
			
			System.out.println(voitures);
			afficherMenu(parking);
			saisie = sc.nextInt();
			sc.nextLine();
			switch (saisie) {
			case 1:
				System.out.println("entrer une plaque");
				plaque = sc.nextLine();
				Voiture voiture = new Voiture(plaque, LocalDateTime.now());
				paiementService.entrerVoiture(voiture);
			/*	if (parking.getVoitures().contains(new Voiture(plaque))) {
					
					System.out.println("cette voiture existe déjà");
					
				} else {
					
					System.out.println("cette voiture n'existe pas");
					parking.setVoitures(voitures);
					voitures.add(voiture);

				} */
				

				break;

			case 2:
				System.out.println("entrer la plaque de la voiture à sortir :");
				plaque = sc.nextLine();
				//Voiture voiture = new Voiture()
				paiementService.sortirVoiture(plaque);
				
				/*double prix = parking.sortirVoiture(plaque);
				if(prix != 0){
					System.out.println("Vous devez payer " + prix + " euros.");	
				}
					*/						
				break;

			case 3:
				
					paiementService.findAll();
				
					
				/*if (parking.getVoitures().isEmpty()) {
					System.out.println("Le parking est vide");
				} else {
					System.out.println(voitures);
				} */
				
				break;

			case 4:

				break;
			}

		} while (saisie != 4);
		
		sc.close();

	}

	private static void afficherMenu(Parking parking) {
		System.out.println("Bienvenue dans le parking VINCI - Places disponibles : " + parking.getNbrPlacesRestantes());
		System.out.println("1 - Ajouter une voiture");
		System.out.println("2 - Faire sortir une voiture");
		System.out.println("3 - Afficher la liste des voitures du parking");
		System.out.println("4 - Quitter");
	}

}
