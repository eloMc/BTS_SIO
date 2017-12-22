package test.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aeronautique.Pilote;
import dao.Connexion;
import dao.PiloteDAO;

class PiloteDAOTest {
	
	
	

	@Test
	void testCreatePilote() {
		Pilote p = new Pilote(-1, "Tartempion","Nice",4520);
		PiloteDAO piloteDAO = new PiloteDAO();
		piloteDAO.create(p);
		Connexion.fermer();
	}
	
	// TODO assertTrue() il faut faire les tests

	@Test
	void testDeletePilote() {
		Pilote numPil=new Pilote(6, null, null, 0);
		PiloteDAO piloteDAO = new PiloteDAO();
		piloteDAO.delete(numPil);
		Connexion.fermer();
	}

	@Test
	void testUpdatePilote() {
		Pilote numPil=new Pilote(6, "Tartempion","Nice", 20000);
		PiloteDAO piloteDAO = new PiloteDAO();
		piloteDAO.update(numPil);
		Connexion.fermer();
	}

	@Test
	void testFindPilote() {
		PiloteDAO piloteDAO = new PiloteDAO();
		Pilote pilote = piloteDAO.find(5);
		System.out.println(pilote);
		Connexion.fermer();
	}

}
