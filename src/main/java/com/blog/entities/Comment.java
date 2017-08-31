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
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Size(min = 1, max = 200)
	private String text;

	private Integer likes;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article articleId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

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

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Article getArticleId() {
		return articleId;
	}
	public void setArticleId(Article articleId) {
		this.articleId = articleId;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public void validateText(BindingResult bindingResult) {
		Integer total = Main.cantPalabras(text);
		if(total > 50) {
			bindingResult.rejectValue("text","error.Comment","El texto no puede tener mas de 50 palabras");
		} else if(total == 0 && !text.equals("")) {
			bindingResult.rejectValue("text","error.Comment","El texto no puede estar vacio");
		}
	}
}