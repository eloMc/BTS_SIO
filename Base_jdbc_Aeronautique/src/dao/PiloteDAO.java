package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Pilote;

public class PiloteDAO extends DAO<Pilote>{

	public static final String TABLE="PILOTE";
	public static final String CLE_PRIMAIRE="numPil";

	/**
	 *  Permet la création d'un pilote dans la base.
	 */
	public boolean create(Pilote obj) {
		boolean succes= true;
		try {

			String req = "insert into " + TABLE + "(nomPil, adr, sal) values( ?,?,?);";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomPil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			pst.executeUpdate();

			obj.setNumPil(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			// récupère id générée

		} catch (SQLException e) {
			System.out.println("Echec de la tentative de create Pilote : " + e.getMessage()) ;
			succes= false;
			e.printStackTrace();
		}

		return succes;
	}

	/**
	 * Permet d'effacer un pilote de la base
	 */
	@Override
	public boolean delete(Pilote obj) {
		boolean succes=true;
		String req = "delete from " + TABLE + " where numPil= ?" + ";";
		PreparedStatement pst;
		try {
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getNumPil());
			pst.executeUpdate();


		} catch (SQLException e) {
			succes=false;
			System.out.println("Echec de la tentative delete pilote : " + e.getMessage()) ;
			e.printStackTrace();
		}

		return succes;
	}

	/**
	 * Permet la mise à jour d'un pilote dans la base
	 */
	@Override
	public boolean update(Pilote obj) {

		boolean succes= true;
		try {

			String req = "update " + TABLE + " set nomPil= ?, adr= ? , sal= ?  where " +CLE_PRIMAIRE +"= ? " ;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomPil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			pst.setInt(4, obj.getNumPil());
			pst.executeUpdate();



		} catch (SQLException e) {
			System.out.println("Echec de la tentative d'update Pilote : " + e.getMessage()) ;
			succes= false;
			e.printStackTrace();
		}

		return succes;
	}

	/**
	 * Permet de récupérer les données d'un pilote dans la base
	 */
	@Override
	public Pilote find(int id) {
		Pilote rep = null;
		try {
			String req = "select * from " + TABLE + " where " + CLE_PRIMAIRE + " = " + id + ";" ;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			String nom = rs.getString("nomPil");
			String adr = rs.getString("adr");
			int sal = rs.getInt("sal");
			rep = new Pilote(id, nom, adr, sal);


		} catch (Exception e) {
			System.out.println("Echec de la tentative de find Pilote : " + e.getMessage()) ;
		}

		return rep;
	}

}
