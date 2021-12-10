package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * 
 * @author Lydie Allart
 *
 */
public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		super();
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public void insert(String pseudo, String nom, String prenom, String email, String telephone,
					String rue, String codePostal, String ville, String motDePasse)
					throws BusinessException {
		BusinessException ex = new BusinessException();
		Utilisateur utilisateur = null;
		
		
		this.validerPseudo(pseudo, ex);
		this.validerNom(nom, ex);
		this.validerPrenom(prenom, ex);
		this.validerEmail(email, ex);
		this.validerTelephone(telephone, ex);
		this.validerRue(rue, ex);
		this.validerCodePostal(codePostal, ex);
		this.validerVille(ville, ex);
		this.validerMotDePasse(motDePasse, ex);
		
		if(!ex.hasErreurs()) {
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom); 
			utilisateur.setEmail(email); 
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			
			Retrait retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCodePostal(codePostal);
			retrait.setVille(ville);
			
			this.utilisateurDAO.insert(utilisateur, retrait);
			
		} else {
			throw ex;
		}
	}
	
	public void update(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse)
			throws BusinessException {
			BusinessException ex = new BusinessException();
			Utilisateur utilisateur = null;

			this.validerPseudo(pseudo, ex);
			this.validerNom(nom, ex);
			this.validerPrenom(prenom, ex);
			this.validerEmail(email, ex);
			this.validerTelephone(telephone, ex);
			this.validerRue(rue, ex);
			this.validerCodePostal(codePostal, ex);
			this.validerVille(ville, ex);
			this.validerMotDePasse(motDePasse, ex);
	
			if(!ex.hasErreurs()) {
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom); 
			utilisateur.setEmail(email); 
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			
			Retrait retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCodePostal(codePostal);
			retrait.setVille(ville);
			
			this.utilisateurDAO.update(utilisateur, retrait);
			
		} else {
			throw ex;
		}
	}
	
	public List<Utilisateur> getUtilisateurs() throws BusinessException {
		return this.utilisateurDAO.selectAll(); 
	}
	
	private void validerPseudo(String pseudo, BusinessException ex) {
		if(pseudo == null || pseudo.trim().equals("") || pseudo.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR); 
	}
	private void validerNom(String nom, BusinessException ex) {
		if(nom == null || nom.trim().equals("") || nom.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR); 
	}
	private void validerPrenom(String prenom, BusinessException ex) {
		if(prenom == null || prenom.trim().equals("") || prenom.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR); 
	}
	private void validerEmail(String email, BusinessException ex) {
		if(email == null || email.trim().equals("") || email.trim().length() > 300)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR);
	}
	private void validerTelephone(String telephone, BusinessException ex) {
		if(telephone == null || telephone.trim().equals("") || telephone.trim().length() > 10)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TEL_ERREUR);
	}
	private void validerRue(String rue, BusinessException ex) {
		if(rue == null || rue.trim().equals("") || rue.trim().length() > 300)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_RUE_ERREUR);
	}
	private void validerCodePostal(String codePostal, BusinessException ex) {
		if(codePostal == null || codePostal.trim().equals("") || codePostal.trim().length() > 15)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_CPO_ERREUR);
	}
	private void validerVille(String ville, BusinessException ex) {
		if(ville == null || ville.trim().equals("") || ville.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_VILLE_ERREUR);
	}
	private void validerMotDePasse(String motDePasse, BusinessException ex) {
		if(motDePasse == null || motDePasse.trim().equals("") || motDePasse.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MDP_ERREUR);
	}

}

