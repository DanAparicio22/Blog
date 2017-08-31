package com.blog.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
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
