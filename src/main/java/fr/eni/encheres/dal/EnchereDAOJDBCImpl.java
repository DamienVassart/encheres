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

/**
 * 
 * @author Lydie Allart
 *
 */
public class EnchereDAOJDBCImpl implements EnchereDAO {
	// Requêtes SQL
	private static final String SQL_INSERT = "INSERT INTO ENCHERES "
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere) " + " VALUES(?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT "
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere)" + "FROM ENCHERES";
	private static final String SQL_SELECT_BY_ID = "SELECT "
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere)" + "FROM Enchere"
			+ "WHERE no_article = ? AND no_utilisateur=?";
	private static final String SQL_SelectByNoArticle = "SELECT  "
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere)" + "FROM ENCHERES" + "WHERE no_article = ?";
	private static final String SQL_SelectByNoUtilisateur = "SELECT "
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere)" + " FROM ENCHERES"
			+ "WHERE no_utilisateur=?";

	@Override
	// Insertion d'une nouvelle enchère----
	public void insert(Enchere enchere, Article article, int noUtilisateur, int noArticle) throws BusinessException {
		Connection cn = null;
		PreparedStatement ps = null;

		if (enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_NULL);
			throw businessException;
		}

		try {
			try {
				cn = ConnectionProvider.getConnection();
				ps = cn.prepareStatement(SQL_INSERT);

				ps.setInt(1, noUtilisateur);
				ps.setInt(2, noArticle);
				ps.setDate(3, enchere.getDateEnchere());
				ps.setInt(4, enchere.getMontantEnchere());

				ps.executeUpdate();

				ps.close();

			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;
		}
	}

	@Override
	// Sélectionner toutes les enchères
	public List<Enchere> selectAll() throws BusinessException {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Enchere> listeEnchere = new ArrayList<Enchere>();

		try {
			cn = ConnectionProvider.getConnection();
			ps = cn.prepareStatement(SQL_SELECT_ALL);
			rs = ps.executeQuery();
			Enchere enchere = new Enchere();

			while (rs.next()) {

				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontantEnchere(rs.getInt("montant_enchere"));
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

	@Override
	// Sélection d'une enchère par son noUtilisateur, noArticle....
	public Enchere selectById(int noUtilisateur, int noArticle) throws BusinessException {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Enchere enchere = new Enchere();

		try {
			cn = ConnectionProvider.getConnection();
			ps = cn.prepareStatement(SQL_SELECT_BY_ID);
			ps.setInt(noUtilisateur, noArticle);

			rs = ps.executeQuery();
			if (rs.next()) {

				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("dateEnchere"));
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

	// Sélection d'une enchère par son noArticle....
	public List<Enchere> selectByNoArticle(int noArticle) throws BusinessException {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Enchere> listeNoArticle = new ArrayList<Enchere>();

		try {
			cn = ConnectionProvider.getConnection();
			ps = cn.prepareStatement(SQL_SelectByNoArticle);
			ps.setInt(1, noArticle);
			rs = ps.executeQuery();
			Enchere enchere = new Enchere();

			if (rs.next()) {

				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("dateEnchere"));
				enchere.setMontantEnchere(rs.getInt("montantEnchere"));

				listeNoArticle.add(enchere);
			}
			rs.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;
		}
		return null;
	}

	@Override
	// Sélection d'une enchère par son noUtilisateur....
	public List<Enchere> selectByNoUtilisateur(int noUtilisateur) throws BusinessException {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Enchere> listeNoUtilisateur = new ArrayList<Enchere>();

		try {
			cn = ConnectionProvider.getConnection();
			ps = cn.prepareStatement(SQL_SelectByNoUtilisateur);
			ps.setInt(1, noUtilisateur);
			rs = ps.executeQuery();
			Enchere enchere = new Enchere();

			if (rs.next()) {

				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("dateEnchere"));	
				enchere.setMontantEnchere(rs.getInt("montantEnchere"));

				listeNoUtilisateur.add(enchere);
			}

			rs.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;
		}

		return null;
	}
}
