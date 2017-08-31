package com.blog.services;

import com.blog.entities.Article;
import com.blog.entities.Comment;

public interface CommentService {
	Iterable<Comment> listAllComment();
	Iterable<Comment> listAllCommentByArticleId(Article articleId);
	Comment getCommentById(Integer id);
	Comment saveComment(Comment comment);
	void deleteComment(Integer id);
}