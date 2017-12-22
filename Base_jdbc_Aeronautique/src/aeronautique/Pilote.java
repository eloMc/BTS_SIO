package aeronautique;

public class Pilote {
	private int numPil;
	private String nomPil;
	private String adr;
	private int sal;
	/**
	 * @param numPil
	 * @param nomPil
	 * @param adr
	 * @param sal
	 */
	public Pilote(int numPil, String nomPil, String adr, int sal) {
		super();
		this.setNumPil(numPil);
		this.setNomPil(nomPil);
		this.setAdr(adr);
		this.setSal(sal);
	}
	
	/**
	 * 
	 * @return permet de récupérer le numPil dans la table Pilote
	 */
	public int getNumPil() {
		return numPil;
	}
	
	/**
	 * 
	 * @param numPil permet d'attribuer le numPil auto généré de la database à l'objet
	 */
	public void setNumPil(int numPil) {
		this.numPil = numPil;
	}
	
	/**
	 * 
	 * @return permet de récupérer le nomPil dans la table Pilote
	 */
	public String getNomPil() {
		return nomPil;
	}
	
	/**
	 * 
	 * @param nomPil permet d'attribuer le nomPil de la database à l'objet
	 */
	public void setNomPil(String nomPil) {
		this.nomPil = nomPil;
	}
	
	/**
	 * 
	 * @return permet de récupérer l'adresse  dans la table Pilote
	 */
	public String getAdr() {
		return adr;
	}
	/**
	 * 
	 * @param adr permet d'attribuer l'adresse de la database à l'objet
	 */
	public void setAdr(String adr) {
		this.adr = adr;
	}
	/**
	 * 
	 * @return permet de récupérer le salaire du pilote  dans la table Pilote
	 */
	public int getSal() {
		return sal;
	}
	
	/**
	 * 
	 * @param sal permet d'attribuer le salaire du pilote de la database à l'objet
	 */
	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Pilote [numPil=" + numPil + ", nomPil=" + nomPil + ", adr=" + adr + ", sal=" + sal + "]";
	}
	
	

}
