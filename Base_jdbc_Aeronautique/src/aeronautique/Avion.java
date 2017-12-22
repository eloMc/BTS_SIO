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
	 * @return permet de récupérer le numAv dans la table Avion
	 */
	public int getNumAv() {
		return numAv;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer le numAv auto généré de la database à l'objet
	 */
	public void setNumAv(int numAv) {
		this.numAv = numAv;
	}
	
	/**
	 * 
	 * @return permet de récupérer le nomAv dans la table Avion 
	 */
	public String getNomAv() {
		return nomAv;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer le nomAv de la database à l'objet
	 */
	public void setNomAv(String nomAv) {
		this.nomAv = nomAv;
	}
	
	/**
	 * 
	 * @return permet de récupérer la capacité de l'avion dans la table Avion 
	 */
	public int getCapacite() {
		return capacite;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer la capacité de l'avion de la database à l'objet
	 */
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * 
	 * @return permet de récupérer la localisation de l'avion dans la table Avion 
	 */
	public String getLoc() {
		return loc;
	}
	
	/**
	 * 
	 * @param numAv permet d'attribuer la localisation de l'avion de la database à l'objet
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	

}
