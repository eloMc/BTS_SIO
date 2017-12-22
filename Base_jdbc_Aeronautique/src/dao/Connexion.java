package dao;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * étape 1 : la connexion à la base de données
 * @author Alain
 *
 */
public class Connexion {

	private static Connection connect = null;

	private static final String ID = "elo";
	private static final String MDP = "sio";
	private static final String NOM_SERVEUR = "BTSWIN7-99";
	private static final String NOM_BD = "PPEaeronautique";

	/*private static final String ID = "BTSWIN7-99\\admin";
	private static final String MDP = "";
	private static final String NOM_SERVEUR = "NT Service\\MSSQLSERVER";
	private static final String NOM_BD = "PPEaeronautique";*/

	private static final int LARGEUR_COLONNE_TEXTE = 10;
	private static final int LARGEUR_COLONNE_ENTIER = 6;
	private static final int LARGEUR_COLONNE_DATE = 11;

	/**
	 * Patron de conception Singleton
	 * @return l'instance unique de connexion
	 */
	public static Connection getInstance() {
		if (connect==null) {
			// Si la connexion n'a pas encore été faite, on la fait.
			try { 

				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(ID);
				ds.setPassword(MDP);
				ds.setServerName(NOM_SERVEUR);
				ds.setDatabaseName(NOM_BD);
				connect = ds.getConnection();
				System.out.println("connecté");
			}
			catch (SQLException e){
				System.out.println("Echec de la tentative de connexion : " + e.getMessage() + e.getStackTrace()) ;
			}
		}
		return connect;
	}

	/**
	 * Méthode statique d'exécution d'une requête de récupération de données
	 * @param requete
	 * @return
	 */
	public static ResultSet executeQuery(String requete){
		Statement st = null ;
		ResultSet rs = null;
		//System.out.println("requete = "+requete);
		try{
			st = getInstance().createStatement() ;
			rs = st.executeQuery(requete) ;
		}catch(SQLException e){
			System.out.println("Echec de la tentative d'exécution de requete : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return rs;
	}

	/**
	 * Une méthode statique qui permet de faire une mise à jour d'une table (INSERT / UPDATE / DELETE)
	 * Mais cette méthode n'est pas utilisée puisqu'on passe par des prepared statement
	 * dans les classes DAO et on fait des execute update directement sur ces preparedStatement.
	 * @param requete
	 * @return
	 */
	public static boolean executeUpdate(String requete){
		boolean succes = true;
		//System.out.println(requete);
		Statement st = null ;
		try{
			st = getInstance().createStatement() ;
			st.executeUpdate(requete) ;
		}catch(SQLException e){
			succes = false;
			System.out.println("Echec de la tentative d'exécution de Mise à Jour : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return succes;
	}

	/**
	 * Fermeture de la connexion au SGBD SQL ServerExpress
	 */
	public static void fermer()
	{
		try
		{
			getInstance().close();
			System.out.println("deconnexion ok");
		}
		catch (SQLException e)
		{
			connect=null;
			System.out.println("echec de la fermeture");
		}
	}

	/**
	 * Requête qui permet de voir le contenu d'une table
	 * Attention à ne pas perdre la première ligne en testant la table vide
	 * @param table
	 */
	public static void afficheSelectEtoile(String table, String clauseWhere){
		try{
			ResultSet rs = Connexion.executeQuery("select * from "+table+" where " +clauseWhere +";");
			//System.out.println(rs.next());
			while(rs.next()) {
				
				int nbCol=rs.getMetaData().getColumnCount();
				for (int i = 1; i <= nbCol; i++) {
					System.out.print(extraireNomTypeColonneNorme(rs, rs.getMetaData(), i)+" ");
				}
				System.out.println("");
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
	}


	/**
	 * Requête qui permet de récupérer le plus grand id de la table, a priori celui qui vient d'être affecté
	 * à une ligne créée via identity. Utiliser MAX
	 * @param cle
	 * @param table
	 * @return
	 */
	public static int getMaxId(String cle, String table) {
		int id= -1;
			ResultSet rs = Connexion.executeQuery("select MAX (" + cle+ ") from "+table+ ";");
			 try {
				while (rs.next()) {
					for (int i = 1; i <=1 ; i++) {
						id= rs.getInt(i);
					}
					 
				 }
			} catch (SQLException e) {
				System.out.println("Echec de la tentative d'interrogation getMaxId : " + e.getMessage()) ;
				e.printStackTrace();
			}
		return id;
	}
	
	
	public static String extraireNomTypeColonneNorme(ResultSet rs, ResultSetMetaData rsmd, int col) {
		String valeur = null;
		try {
			switch (rsmd.getColumnType(col)) {
			case Types.INTEGER :
				valeur = rs.getInt(col)+"";				
				break;
			case Types.VARCHAR : 
				valeur = rs.getString(col);
				break;
			case Types.NUMERIC : 
				valeur = rs.getInt(col)+"";
				break;
			case Types.TIMESTAMP : 
				valeur = rs.getDate(col)+"";
				break;
			case Types.FLOAT : 
				valeur = rs.getFloat(col)+"";
				break;

			default:
				break;
			}
		} catch (SQLException e) {
			System.out.println("Echec de la tentative d'interrogation extraireNomTypeColonneNorme : " + e.getMessage()) ;
			e.printStackTrace();
		}			
		return valeur;

	}

}
