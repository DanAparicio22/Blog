package com.blog.repositories;

import com.blog.entities.Article;
import com.blog.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	Iterable<Comment> findByArticleId(Article articleId);
}