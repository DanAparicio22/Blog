package com.blog.services;

import com.blog.entities.ArticleCategory;

public interface ArticleCategoryService {
    Iterable<ArticleCategory> listAllArticleCategory();
    ArticleCategory getArticleCategoryById(Integer id);
    ArticleCategory saveArticleCategory(ArticleCategory articleCategory);
    void deleteArticleCategory(Integer id);
}
