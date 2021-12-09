package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * 
 * @author Lydie Allart
 *
 */
	public class EnchereDAOJDBCImpl implements EnchereDAO {
		/**
		 * Requêtes SQL
		 */
		private static final String SQL_INSERT= "INSERT INTO ENCHERES VALUES(?,?,?,?);";
		private static final String SQL_SELECT_ALL = "SELECT * FROM ENCHERES WHERE noArticle=?, noUtilisateur=?;";
		private static final String SQL_SELECT_BY_ID = "SELECT FROM Encheres WHERE no_article = ?, noUtilisateur=?;";
		private static final String SQL_UPDATE = "UPDATE ENCHERES SET dateEnchere = ?, "
				+ "montantEnchere = ?\r\n"
				+ "WHERE noArticle=?, noUtilisateur=?;";
		private static final String SQL_DELETE = "DELETE FROM Encheres WHERE no_article = ?, noUtilisateur=?;";
		
		
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
					PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL, 
							PreparedStatement.RETURN_GENERATED_KEYS);
					
					ps.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
					ps.setInt(2, enchere.getMontantEnchere());
					
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next())
						enchere.setDateEnchere(LocalDate.of((rs.getDate("date_enchere").toLocalDate()), 
								rs.getTime("date_enchere").toLocalTime()));
					
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
		 * Mise à jour d'une enchère existante ?
		 */
		public void update(Enchere enchere) throws BusinessException {
			
			try(Connection cn = ConnectionProvider.getConnection()) {
				// on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_UPDATE);
				
				ps.setTimestamp(1, enchere.getDateEnchere());//(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
				ps.setInt(2, enchere.getMontantEnchere());
				
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next())
					enchere.setNoArticle(rs.getInt(1));
				
				ps.executeUpdate();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_ECHEC);//serait mieux avec un noEnchere
				throw businessException;
		
			}
		}
		
		/*
		 * Suppression d'une enchère
		 */
		public void delete(int noArticle) throws BusinessException {
			try (Connection cn = ConnectionProvider.getConnection()) {
				//on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_DELETE);
				
				ps.setInt(1, noArticle);
				
				ps.executeUpdate();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.DELETE_ENCHERE_ECHEC);//serait mieux avec un noEnchere
				throw businessException;
			}
		}
		
		/*
		 * Sélectionner tous les enchères
		 */
		public List<Enchere> selectAll() throws BusinessException {
			List<Enchere> listeEnchere = new ArrayList<>();
			
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL);
				ResultSet rs = ps.executeQuery();
				Enchere enchere = new Enchere();
				while(rs.next()) {
					
					ps.setInt(1, noArticle, noUtilisateur);//noEnchère ???
					
					listeEnchere.add(enchere);
				}
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);//serait mieux avec un noEnchere
				throw businessException;
			}
			
			return listeEnchere;
		}
		/*
		 * Sélection d'une enchère par son noUtilisateur, noArticle
		 */
		public Enchere selectById(int noUtilisateur,int noArticle) throws BusinessException {
			Enchere enchere = new Enchere();
			try (Connection cn = ConnectionProvider.getConnection()) {
				
				//on prépare la requête
				PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					
					enchere.setNoArticle(rs.getInt("noArticle"));
					
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

	
		}
	}
}
