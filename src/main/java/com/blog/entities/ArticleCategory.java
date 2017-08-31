package com.blog.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "article_category")
public class ArticleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "articleCategory", cascade = CascadeType.ALL)
    private Set<Article> article;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Article> getArticle() {
        return article;
    }
    public void setArticle(Set<Article> article) {
        this.article = article;
    }
}