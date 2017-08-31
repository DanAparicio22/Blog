package com.blog.entities;

import com.blog.Main;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 75)
	private String title;

	@NotNull
	@Size(min = 1, max = 300)
	private String text;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	private Integer likes;

	@ManyToOne
	@JoinColumn(name = "article_category_id")
	private ArticleCategory articleCategory;

	@OneToMany(mappedBy = "articleId", cascade = CascadeType.ALL)
	@OrderBy("id ASC")
	private Set<Comment> comment;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	private Integer showable;

	@PrePersist
	protected void onCreate() {
		date = new Date();
		likes = 0;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getShowable() {
		return showable;
	}
	public void setShowable(Integer showable) {
		this.showable = showable;
	}

	public void validateTitle(BindingResult bindingResult) {
		Integer total = Main.cantPalabras(title);
		if(total > 20) {
			bindingResult.rejectValue("title","error.Article","El titulo no puede tener mas de 20 palabras");
		} else if(total == 0 && !title.equals("")) {
			bindingResult.rejectValue("title","error.Article","El titulo no puede estar vacio");
		}
	}

	public void validateText(BindingResult bindingResult) {
		Integer total = Main.cantPalabras(text);
		if(total > 100) {
			bindingResult.rejectValue("text","error.Article","El texto no puede tener mas de 100 palabras");
		} else if(total == 0 && !text.equals("")) {
			bindingResult.rejectValue("text","error.Article","El texto no puede estar vacio");
		}
	}
}