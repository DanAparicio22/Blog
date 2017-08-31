package com.blog.repositories;

import com.blog.entities.ArticleCategory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArticleCategoryRepository extends CrudRepository<ArticleCategory, Integer> {

}