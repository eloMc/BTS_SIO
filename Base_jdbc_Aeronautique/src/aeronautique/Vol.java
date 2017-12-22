package aeronautique;

import java.sql.Statement;
import java.util.GregorianCalendar;

import dao.Connexion;

/**
 * étape 0 : les classes métier : le vol
 * on regarde les types de la table VOL
 * @author abi
 *
 */

public class Vol {

	private int numVol;
	private Pilote pilote;
	private Avion avion;
	private String villeDep;
	private String villeArr;
	private GregorianCalendar hDep;
	private GregorianCalendar hArr;
	
	/**
	 * @param numVol
	 * @param pilote
	 * @param avion
	 * @param villeDep
	 * @param villeArr
	 * @param hDep
	 * @param hArr
	 */
	public Vol(int numVol, Pilote pilote, Avion avion, String villeDep, String villeArr, GregorianCalendar hDep,
			GregorianCalendar hArr) {
		super();
		this.setNumVol(numVol);
		this.setPilote(pilote);
		this.setAvion(avion);
		this.setVilleDep(villeDep);
		this.setVilleArr(villeArr);
		this.sethDep(hDep);
		this.sethArr(hArr);
	}// Constructeur sur les champs.
	
	
	
	/**
	 * éventuellement utiliser java.sql.Timestamp et getTimeInMillis pour afficher les dates 
	 */
	
	@Override
	public String toString() {
		return "Vol [numVol=" + numVol + ", pilote=" + pilote + ", avion=" + avion + ", villeDep=" + villeDep
				+ ", villeArr=" + villeArr + ", hDep=" + hDep + ", hArr=" + hArr + "]";
	}

/**
 * 
 * @return permet de récupérer le numVol dans la table Vol
 */
	public int getNumVol() {
		return numVol;
	}


	/**
	 * 
	 * @param numVol permet d'attribuer le numVol auto généré de la database à l'objet
	 */
	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}


	/**
	 * 
	 * @return permet de récupérer le pilote dans la table Vol
	 */
	public Pilote getPilote() {
		return pilote;
	}


	/**
	 * 
	 * @param pilote permet d'attribuer le pilote de la database à l'objet
	 */
	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}



	public Avion getAvion() {
		return avion;
	}



	public void setAvion(Avion avion) {
		this.avion = avion;
	}



	public String getVilleDep() {
		return villeDep;
	}



	public void setVilleDep(String villeDep) {
		this.villeDep = villeDep;
	}



	public String getVilleArr() {
		return villeArr;
	}



	public void setVilleArr(String villeArr) {
		this.villeArr = villeArr;
	}



	public GregorianCalendar gethDep() {
		return hDep;
	}



	public void sethDep(GregorianCalendar hDep) {
		this.hDep = hDep;
	}



	public GregorianCalendar gethArr() {
		return hArr;
	}



	public void sethArr(GregorianCalendar hArr) {
		this.hArr = hArr;
	}

	
	

}
