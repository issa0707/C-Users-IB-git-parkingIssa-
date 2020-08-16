package fr.ibformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.ibformation.bo.Voiture;

public class ParkingDAOImpl implements ParkingDAO {

	@Override
	public void entrerVoiture(Voiture voiture) {
		
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "INSERT INTO Voiture(plaque, dateHeureEntree) VALUES(?,?);";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setString(1, voiture.getPlaque());
			pstmt.setTimestamp(2, Timestamp.valueOf(voiture.getDateHeureEntree()));
					
			pstmt.executeUpdate();
			
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sortirVoiture(String plaque) {
		
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "DELETE FROM Voiture WHERE plaque = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setString(1, plaque);
			pstmt.executeUpdate();
			
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Voiture> findAll() {
		List<Voiture> voitures = new ArrayList<>();
		Connection cnx = DAOUtil.getConnexion();
		String requete = "SELECT * FROM Voiture = ?";
		
		try {
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Voiture voiture = new Voiture();
				voiture.setPlaque(rs.getString("plaque"));		
				voiture.setDateHeureEntree(rs.getTimestamp("dateHeureEntree").toLocalDateTime());
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voitures;
	}
}
