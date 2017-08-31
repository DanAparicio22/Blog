package com.blog.services;

import com.blog.entities.Article;
import com.blog.entities.ArticleCategory;
import com.blog.repositories.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService{

    private ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    @Qualifier(value = "articleCategoryRepository")
    public void setArticleRepository(ArticleCategoryRepository articleCategoryRepository) {
        this.articleCategoryRepository = articleCategoryRepository;
    }

    @Override
    public Iterable<ArticleCategory> listAllArticleCategory() {
        return articleCategoryRepository.findAll();
    }

    @Override
    public ArticleCategory getArticleCategoryById(Integer id) {
        return articleCategoryRepository.findOne(id);
    }

    @Override
    public ArticleCategory saveArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryRepository.save(articleCategory);
    }

    @Override
    public void deleteArticleCategory(Integer id) {
        articleCategoryRepository.delete(id);
    }
}