package fr.eni.encheres.bo;
/**
 * 
 * @author Lydie Allart
 *
 */
public class Categorie {
	
	
	private int noCategorie;
	private String libelle;
	
	public Categorie() {
		super();
	}
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Categorie [libelle=" + libelle + "]";
	}
	
	


}

