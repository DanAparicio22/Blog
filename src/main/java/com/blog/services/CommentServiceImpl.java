package com.blog.services;

import com.blog.entities.Article;
import com.blog.entities.Comment;
import com.blog.repositories.CommentRepository;
import org.codehaus.groovy.ast.expr.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepository;

	@Autowired
	@Qualifier(value = "commentRepository")
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public Iterable<Comment> listAllComment() {
		return commentRepository.findAll();
	}

	@Override
	public Iterable<Comment> listAllCommentByArticleId(Article articleId) {
		return commentRepository.findByArticleId(articleId);
	}

	@Override
	public Comment getCommentById(Integer id) {
		return commentRepository.findOne(id);
	}

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(Integer id) {
		commentRepository.delete(id);
	}
}