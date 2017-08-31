package com.blog.services;

import com.blog.entities.Autor;

public interface AutorService {
    Iterable<Autor> listAllAutor();
    Autor getAutorById(Integer id);
    Autor saveAutor(Autor autor);
    void deleteAutor(Integer id);
}