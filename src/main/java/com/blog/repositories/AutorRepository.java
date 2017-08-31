package com.blog.repositories;

import com.blog.entities.Article;
import com.blog.entities.Autor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}