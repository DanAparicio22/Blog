package com.blog.services;

import com.blog.entities.Article;

public interface ArticleService {
	Iterable<Article> listAllArticle();
	Article getArticleById(Integer id);
	Article saveArticle(Article article);
	void deleteArticle(Integer id);
}