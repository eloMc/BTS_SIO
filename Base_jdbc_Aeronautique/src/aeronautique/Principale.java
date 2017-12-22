package aeronautique;

import controleur.Controleur;
import dao.AvionDAO;
import dao.Connexion;
import dao.PiloteDAO;


/**
 * - Il faut commencer par faire le métier, puis regarder la classe Connexion,
 * puis le Design Pattern DAO sur la table VOL
 * - Ensuite on étend aux autres tables AVION et PILOTE
 * - faire quelques vérifications de base sur la table vol :
 * lors du create, est-ce que les clés étrangères sont dans la table.
 * Il faut lever une exception précise dans le cas contraire.
 * - Essayer des requêtes plus complexes et les proposer dès le menu.
 * - Algorithmique : soigner l'affichage des réponses pour avoir un titre
 * aux colonnes et qu'elles soient de largeur fixe.
 * 
 * Si vous utilisez le type Money sous SQL Server Express, il faut utiliser
 * DECIMAL	avec JDBC et java.math.BigDecimal pour java.
 * 
 * @author abi
 *
 */
public class Principale {

	public static void main(String[] args) {

		/*new Controleur();		
		Connexion.fermer();*/

		//initialisation();
		//testAfficheSelectEtoile();
		//testgetMaxId();
		//gestion();
		//testCreatePilote();
		//testDeletePilote();
		//TestUpdatePilote();
		//testFindPilote();
		//testCreateAvion();
	}

	private static void gestion() {
		// TODO Auto-generated method stub
		Connexion.fermer();
	}

	private static void initialisation() {
		Connexion.executeUpdate("drop table VOL;");		
		Connexion.executeUpdate("drop table AVION;");
		Connexion.executeUpdate("drop table PILOTE;");

		Connexion.executeUpdate("create table AVION " + 
				"(numAv int primary key identity(1,1) not null, " + 
				" nomAV VARCHAR(50), " + 
				" capacite numeric(18, 0), " + 
				" loc VARCHAR(50)\r\n);");
		Connexion.executeUpdate("insert into AVION " +
				"values ('airbus', '200', 'NICE')," +
				" ('pouet56', '380', 'PARIS')," +
				" ('doudou', '150', 'VANNES')," +
				" ('jetprive', '10', 'PARIS')," +
				" ('crashpatatra', '50', 'NEW-YORK')," +
				" ('flute', '400', 'NICE')," +
				" ('cacadoie', '40', 'PARIS');");


		Connexion.executeUpdate("create table PILOTE " +
				"(numPil int primary key identity(1,1) not null,\r\n" +
				" nomPil VARCHAR(50),\r\n" +
				" adr VARCHAR(50),\r\n" +
				//" sal money\r\n);");
				" sal int\r\n);");
		Connexion.executeUpdate("insert into PILOTE " +
				"values ('Durand','NICE',15000)," +
				" ('Dupont','PARIS',20000)," +
				" ('Duchamps','NEW-YORK',3000)," +
				" ('Duplouf','VANNES',25000)," +
				" ('dubouchon','PARIS',20000);");

		Connexion.executeUpdate("create table VOL " +
				"(numVol int primary key identity(1,1) not null, " +
				"numPil int foreign key references PILOTE(numPil), " +
				"numAv int foreign key references AVION(numAv), " +
				"villeDep VARCHAR(50), " +
				"villeArr VARCHAR(50), " +
				"hDep datetime, " +
				"hARR datetime,);");

		Connexion.executeUpdate("insert into VOL " +

				"values ('1','1','NICE','VANNES','10/10/2017 08:00:00','10/10/2017 09:00:00')," +
				" ('2','2','PARIS','NICE','10/10/2017 15:00:00','10/10/2017 16:00:00')," +
				" ('3','5','NEW-YORK','PARIS','10/10/2017 10:00:00','10/10/2017 18:00:00')," +
				" ('4','3','VANNES','NEW-YORK','10/10/2017 18:00:00','11/10/2017 02:00:00')," +
				" ('1','1','VANNES','PARIS','10/10/2017 09:15:00','10/10/2017 10:15:00')," +
				" ('2','2','NICE','PARIS','10/10/2017 17:30:00','10/10/2017 18:30:00')," +
				" ('1','4','PARIS','VANNES','10/10/2017 11:00:00','10/10/2017 12:00:00')," +
				" ('5','1','NICE','VANNES','11/10/2017 08:00:00','11/10/2017 09:00:00')," +
				" ('1','7','PARIS','NICE','11/10/2017 08:00:00','11/10/2017 09:00:00');" ); 


		Connexion.fermer();
	}

	public static void testAfficheSelectEtoile() {
		Connexion.afficheSelectEtoile("AVION", "numAv>1");
		Connexion.fermer();
	}

	public static void testgetMaxId() {

		System.out.println(Connexion.getMaxId("numAv", "AVION"));
		Connexion.fermer();
	}
	

	public static void testCreateAvion() {
		Avion a = new Avion(-1, "testAvion",250,"Vannes");
		AvionDAO avionDAO = new AvionDAO();
		avionDAO.create(a);
		Connexion.fermer();
	}
	
}
