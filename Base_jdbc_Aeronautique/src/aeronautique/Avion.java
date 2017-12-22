package aeronautique;

public class Avion {
	private int numAv;
	private String nomAv;
	private int capacite;
	private String loc;
	/**
	 * @param numAv
	 * @param nomAv
	 * @param capacite
	 * @param loc
	 */
	public Avion(int numAv, String nomAv, int capacite, String loc) {
		super();
		this.setNumAv(numAv);
		this.setNomAv(nomAv);
		this.setCapacite(capacite);
		this.setLoc(loc);
	}
	
	/**
	 * 
	 * @return permet de r�cup�rer le numAv dans la table Avion
	 */
	public int getNumAv() {
		return numAv;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer le numAv auto g�n�r� de la database � l'objet
	 */
	public void setNumAv(int numAv) {
		this.numAv = numAv;
	}
	
	/**
	 * 
	 * @return permet de r�cup�rer le nomAv dans la table Avion 
	 */
	public String getNomAv() {
		return nomAv;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer le nomAv de la database � l'objet
	 */
	public void setNomAv(String nomAv) {
		this.nomAv = nomAv;
	}
	
	/**
	 * 
	 * @return permet de r�cup�rer la capacit� de l'avion dans la table Avion 
	 */
	public int getCapacite() {
		return capacite;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer la capacit� de l'avion de la database � l'objet
	 */
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * 
	 * @return permet de r�cup�rer la localisation de l'avion dans la table Avion 
	 */
	public String getLoc() {
		return loc;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer la localisation de l'avion de la database � l'objet
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	

}
