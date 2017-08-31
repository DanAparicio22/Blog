package com.blog.repositories;

import com.blog.entities.Article;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArticleRepository extends CrudRepository<Article, Integer> {
	Iterable<Article> findAllByOrderByIdAsc();
}