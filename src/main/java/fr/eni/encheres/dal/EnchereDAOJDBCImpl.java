package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;


/**
 * 
 * @author Lydie Allart
 *
 */
	public class EnchereDAOJDBCImpl implements EnchereDAO {
		/**
		 * Requêtes SQL
		 */
		private static final String SQL_INSERT= "INSERT INTO ENCHERES "
				+ "(no_utilisateur, no_article, date_enchere, montant_enchere) "
				+ " VALUES(?,?,?,?)";
		private static final String SQL_SELECT_ALL = "SELECT "
				+ "(no_utilisateur, no_article, date_enchere, montant_enchere)"
				+ "FROM ENCHERES";
		private static final String SQL_SELECT_BY_ID = "SELECT "
				+ "(no_utilisateur, no_article, date_enchere, montant_enchere)"
				+ "FROM Enchere"
				+ "WHERE no_article = ? AND no_utilisateur=?,";
		private static final String SQL_SelectByNoArticle = "SELECT  "
				+ "noArticle, nomArticle, description, dateDebutEncheres, dateFinEnchere,  miseAPrix, prixVente, estVendu"
				+ "WHERE no_article = ?"
				+ "FROM ENCHERES";
		private static final String SQL_SelectByNoUtilisateur = "SELECT "
				+ "noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur"
				+ "WHERE no_utilisateur=?"
				+" FROM ENCHERES";
		/*
		 * Insertion d'une nouvelle enchère
		 */
		public void insert(Enchere enchere) throws BusinessException {
			
			
			if(enchere == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_NULL);
				throw businessException;
			}
			
			try (Connection cn = ConnectionProvider.getConnection()) {
				try {
					//On prépare la requête:
					PreparedStatement ps = cn.prepareStatement(SQL_INSERT, 
							PreparedStatement.RETURN_GENERATED_KEYS);
					
					ps.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
					ps.setInt(2, enchere.getMontantEnchere());
					
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next())
						
					enchere.setDateEnchere(LocalDateTime.of((rs.getDate("dateEnchere").toLocalDate()), 
								rs.getTime("dateEnchere").toLocalTime()));
					enchere.setMontantEnchere(rs.getInt("montantEnchere"));
					
					rs.close();
					ps.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_ECHEC);
				throw businessException;
			}
		}
		
		/*
		 * Sélectionner toutes les enchères
		 */
		public List<Enchere> selectAll() throws BusinessException {
			List<Enchere> listeEnchere = new ArrayList<>();
			
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL);
				ResultSet rs = ps.executeQuery();
				Enchere enchere = new Enchere();
				
				while(rs.next()) {
					
					listeEnchere.add(enchere);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
				throw businessException;
			}
			
			return listeEnchere;
		}
		/*
		 * Sélection d'une enchère par son noUtilisateur, noArticle....
		 */
		public Enchere selectById(int noUtilisateur,int noArticle) throws BusinessException {
			Enchere enchere = new Enchere();
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				//on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					enchere.setDateEnchere(LocalDateTime.of((rs.getDate("dateEnchere").toLocalDate()), 
							rs.getTime("dateEnchere").toLocalTime()));
					enchere.setMontantEnchere(rs.getInt("montantEnchere"));
					
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
				throw businessException;
			}
			return enchere;
		}
		
		/*
		 * Sélection d'une enchère par son noArticle....
		 */
		public Enchere selectByArticle(int noArticle) throws BusinessException {
			Enchere enchere = new Enchere();
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				//on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					enchere.setDateEnchere(LocalDateTime.of((rs.getDate("dateEnchere").toLocalDate()), 
							rs.getTime("dateEnchere").toLocalTime()));
					enchere.setMontantEnchere(rs.getInt("montantEnchere"));
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
				throw businessException;
			}
			return enchere;
		}
		/*
		 * Sélection d'une enchère par son noUtilisateur....
		 */
		public List<Enchere> selectByUtilisateur(int noUtilisateur) throws BusinessException {
			
			Enchere enchere = new Enchere();
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				//on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_UTILISATEUR);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					enchere.setDateEnchere(LocalDateTime.of((rs.getDate("dateEnchere").toLocalDate()), 
							rs.getTime("dateEnchere").toLocalTime()));
					enchere.setMontantEnchere(rs.getInt("montantEnchere"));	
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
				throw businessException;
			}
			return enchere;
		}
		
		@Override
		public void insert(Enchere enchere, Article article, int noUtilisateur, int noArticle)
				throws BusinessException {
		}

		@Override
		public List<Enchere> selectByNoUtilisateur(int noUtilisateur) throws BusinessException {
			return null;
		}

		@Override
		public List<Enchere> selectByNoArticle(int noArticle) throws BusinessException {
			return null;
		}


}

