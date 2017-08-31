package com.blog.services;

import com.blog.entities.Article;
import com.blog.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

	private ArticleRepository articleRepository;

	@Autowired
	@Qualifier(value = "articleRepository")
	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public Iterable<Article> listAllArticle() {
		return articleRepository.findAll();
	}

	@Override
	public Article getArticleById(Integer id) {
		return articleRepository.findOne(id);
	}

	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(Integer id) {
		articleRepository.delete(id);
	}
}