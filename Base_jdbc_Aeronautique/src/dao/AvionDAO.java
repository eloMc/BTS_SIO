package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import aeronautique.Avion;

public class AvionDAO extends DAO<Avion> {
	
	private static final String TABLE = "Avion";
	private static final String CLE_PRIMAIRE = "numAv";
	// 2 constantes de classe : le nom de la table, la clé primaire
	
	
	
	@Override
	public boolean create(Avion obj) {
		boolean succes= true;
		try {

			String req = "insert into " + TABLE + "(nomAv, capacite, loc) values( ?,?,?);";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomAv());
			pst.setInt(2, obj.getCapacite());
			pst.setString(3, obj.getLoc());
			pst.executeUpdate();

			obj.setNumAv(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			// récupère id générée

		} catch (SQLException e) {
			System.out.println("Echec de la tentative de create Pilote : " + e.getMessage()) ;
			succes= false;
			e.printStackTrace();
		}

		return succes;
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean delete(Avion obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Avion obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Avion find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
