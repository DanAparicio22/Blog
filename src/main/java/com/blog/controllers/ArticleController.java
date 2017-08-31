package com.blog.controllers;

import com.blog.Main;
import com.blog.services.ArticleCategoryService;
import com.blog.services.ArticleService;
import com.blog.services.AutorService;
import com.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.blog.entities.Article;
import com.blog.entities.Comment;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ArticleController {
	private ArticleService articleService;
	private CommentService commentService;
	private ArticleCategoryService articleCategoryService;
	private AutorService autorService;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
		this.articleCategoryService = articleCategoryService;
	}

	@Autowired
	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("articles", articleService.listAllArticle());
		return "articles";
	}

	@RequestMapping("/article/{id}")
	public String showArticle(@PathVariable Integer id, Model model) {
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "showArticle";
	}

	@RequestMapping(value = "/article/like", method = RequestMethod.POST)
	public String likeArticle(Article article) {
		article.setLikes(article.getLikes() + 1);
		articleService.saveArticle(article);
		return "redirect:/article/" + article.getId();
	}

	@RequestMapping(value = "/article/dislike", method = RequestMethod.POST)
	public String dislikeArticle(Article article) {
		if(article.getLikes() > 0) {
			article.setLikes(article.getLikes() - 1);
			articleService.saveArticle(article);
		}
		return "redirect:/article/" + article.getId();
	}

	@RequestMapping("/article/new")
	public String addArticle(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("articleCategorys", articleCategoryService.listAllArticleCategory());
		model.addAttribute("autors",autorService.listAllAutor());
		return "editArticle";
	}

	@RequestMapping("/article/edit/{id}")
	public String editArticle(@PathVariable Integer id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		model.addAttribute("articleCategorys", articleCategoryService.listAllArticleCategory());
		model.addAttribute("autors",autorService.listAllAutor());
		return "editArticle";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public String saveArticle(@Valid Article article, BindingResult bindingResult, Model model) {
		article.validateTitle(bindingResult);
		article.validateText(bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("articleCategorys", articleCategoryService.listAllArticleCategory());
			model.addAttribute("autors",autorService.listAllAutor());
			return "editArticle";
		} else {
			articleService.saveArticle(article);
			return "redirect:/";
		}
	}

	@RequestMapping("/article/delete/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		articleService.deleteArticle(id);
		return "redirect:/";
	}

	@RequestMapping("/article/newcomment/{id}")
	public String addComment(@PathVariable Integer id, Model model) {
		Article x = articleService.getArticleById(id);
		Comment y = new Comment();
		y.setArticleId(x);
		model.addAttribute("comment", y);
		return "editComment";
	}
}