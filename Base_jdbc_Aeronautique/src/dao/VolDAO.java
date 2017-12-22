package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;

/**
 * étape 2 : le patron de conception DAO, le lien vers notre table PILOTE
 * On étend la classe DAO avec un Pilote
 * @author abi
 *
 */
public class VolDAO extends DAO<Vol> {

	private static final String TABLE = "Vol";
	private static final String CLE_PRIMAIRE = "numVol";
	// 2 constantes de classe : le nom de la table, la clé primaire


	/* !!! DATES : pour les bases de données, on passera par java.sql.Timestamp 
	 * Pour le find :
	 * GregorianCalendar hArr = new GregorianCalendar();
	 * hArr.setTimeInMillis (rs.getTimestamp("harr").getTime());
	 * Pour le create :
	 * Timestamp ts = new Timestamp (vol.gethDep().getTimeInMillis());
	 * pst.setTimestamp(3,ts);
	 * 
	 * NB : les mois dans le constructeur de Gregorian Calendar vont de 0 à 11.
	 * 
	 * En utilisant SimpleDateFormat, on peut avoir un affichage avec des termes français.
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy zzzz G", Locale.FRENCH);
	 * 
	 */


	/**
	 * On donne un vol en entrée qu'on va écrire dans la base de données
	 * La requête à utiliser est un INSERT INTO
	 * On utilise encore TimeStamp
	 */
	@Override
	public boolean create(Vol obj) {

		boolean succes=true;
		try {

			String req = "insert into " + TABLE + "(numPil, numAv, villeDep, villeArr, hDep, hArr) values( ?,?,?,?,?,?);";
			Timestamp ts = new Timestamp (obj.gethDep().getTimeInMillis());
			Timestamp ts2 = new Timestamp (obj.gethArr().getTimeInMillis());
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getPilote().getNumPil());
			pst.setInt(2, obj.getAvion().getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(3, obj.getVilleArr());
			pst.setTimestamp(4,ts);
			pst.setTimestamp(5,ts2);
			pst.executeUpdate();
			obj.setNumVol(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}
	// Le prepared Statement prépare notre requete.
				// On peut utiliser les méthodes setInt, setTimestamp, setString...
				// Puis on utilise executeUpdate

				// Ensuite, il faut remettre à jour l'identifiant de l'objet java,
				// généré automatiquement par la base de données

	/**
	 * On donne un vol en entrée qu'on va supprimer de la base de données
	 * La requête à utiliser est un DELETE FROM
	 * 
	 */
	@Override
	public boolean delete(Vol obj) {
		boolean succes=true;
		String req = "delete from " + TABLE + " where numVol= ?" + ";";
		PreparedStatement pst;
		try {
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getNumVol());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			succes = false;
			System.out.println("Echec de la tentative delete vol : " + e.getMessage()) ;
			e.printStackTrace();
		} 
		return succes;		
	}

	/**
	 * On donne un vol en entrée qu'on va mettre à jour dans la base de données
	 * La requête à utiliser est un UPDATE SET
	 * 
	 */
	@Override
	public boolean update(Vol obj) {
		boolean succes=true;
		try {
			String req = "update " + TABLE + "(set numPil=?, numAv=?, villeDep=?, villeArr=?, hDep=?, hArr=? where " +CLE_PRIMAIRE +"= ? " ;
			Timestamp ts = new Timestamp (obj.gethDep().getTimeInMillis());
			Timestamp ts2 = new Timestamp (obj.gethArr().getTimeInMillis());
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getPilote().getNumPil());
			pst.setInt(2, obj.getAvion().getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(3, obj.getVilleArr());
			pst.setTimestamp(4,ts);
			pst.setTimestamp(5,ts2);
			pst.executeUpdate();
			obj.setNumVol(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));// requete, preparedStatement, setInt, setString, setTimeStamp etc. puis executeUpdate
		} catch (SQLException e) {
			succes = false;
			System.out.println("Echec de la tentative d'update Vol : " + e.getMessage()) ;
			e.printStackTrace();
		} 
		return succes;	
	}

	/**
	 * On donne un identifiant entier en entrée qu'on cherche dans la base de données
	 * La requête à utiliser est un SELECT FROM WHERE avec la clé primaire
	 * 
	 */
	@Override
	public Vol find(int id) {
		Vol vol = null;	
		try {
			String req = "select * from " + TABLE + " where " + CLE_PRIMAIRE + "= " + id + ";" ;
			GregorianCalendar hDep = new GregorianCalendar();
			GregorianCalendar hArr = new GregorianCalendar();
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			ResultSet rs =pst.executeQuery();
			
			rs.next();
			//id= rs.getInt("numVol");
			Pilote Pilote= (new PiloteDAO()).find(rs.getInt("numPil"));
			Avion Avion = (new AvionDAO()).find(rs.getInt("numAv"));
			String villeDep= rs.getString("villeDep");
			String villeArr= rs.getString("villeArr");
			hDep.setTimeInMillis (rs.getTimestamp("hdep").getTime());
			hArr.setTimeInMillis (rs.getTimestamp("harr").getTime());
			
			
			vol = new Vol(id , Pilote, Avion, villeDep, villeArr, hDep, hArr);
			// TODO manipulation d'un resultSet, création d'un objet Vol
		} catch (SQLException e) {
			System.out.println("Echec de la tentative de find Vol : " + e.getMessage()) ;
			e.printStackTrace();
		}
		return vol;
	}



}
