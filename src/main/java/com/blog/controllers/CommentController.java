package com.blog.controllers;

import com.blog.services.ArticleService;
import com.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.blog.entities.Article;
import com.blog.entities.Comment;

import javax.validation.Valid;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class CommentController {
	private ArticleService articleService;
	private CommentService commentService;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value = "/comment/like", method = RequestMethod.POST)
	public String likeComment(Comment comment) {
		comment.setLikes(comment.getLikes() + 1);
		commentService.saveComment(comment);
		return "redirect:/article/" + comment.getArticleId().getId();
	}

	@RequestMapping(value = "/comment/dislike", method = RequestMethod.POST)
	public String dislikeComment(Comment comment) {
		if(comment.getLikes() > 0) {
			comment.setLikes(comment.getLikes() - 1);
			commentService.saveComment(comment);
		}
		return "redirect:/article/" + comment.getArticleId().getId();
	}

	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public String saveComment(@Valid Comment comment, BindingResult bindingResult) {
		comment.validateText(bindingResult);
		if(bindingResult.hasErrors()) {
			return "editComment";
		} else {
			commentService.saveComment(comment);
			return "redirect:/article/" + comment.getArticleId().getId();
		}
	}

	@RequestMapping("/article/editcomment/{id}")
	public String editComment(@PathVariable Integer id, Model model) {
		Comment x = commentService.getCommentById(id);
		model.addAttribute("comment", x);
		return "editComment";
	}

	@RequestMapping("/article/deletecomment/{id}")
	public String deleteComment(@PathVariable Integer id) {
		Integer aux = commentService.getCommentById(id).getArticleId().getId();
		commentService.deleteComment(id);
		return "redirect:/article/" + aux;
	}
}