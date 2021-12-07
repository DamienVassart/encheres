package fr.eni.encheres.bo;

/**
 * Définit la classe Retrait
 * @author Damien Vassart
 *
 */
public class Retrait {
	private String rue;
	private String codePostal;
	private String ville;

	/**
	 * Constructeur pour la classe Retrait
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Constructeur vide
	 */
	public Retrait() {
		super();
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return this.rue;
	}
	
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}
	
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return this.ville;
	}
	
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
}
