package fr.eni.encheres.dal;

public interface ArticleDAO {
	
	public List<Article> selectArticle();
	
	
	
	
	public Article insert(Article article);
	
	public Article select(int idArticle);
}
