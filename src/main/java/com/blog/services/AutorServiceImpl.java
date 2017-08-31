package com.blog.services;

import com.blog.entities.Autor;
import com.blog.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService{

    private AutorRepository autorRepository;

    @Autowired
    @Qualifier(value = "autorRepository")
    public void setAutorRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Iterable<Autor> listAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getAutorById(Integer id) {
        return autorRepository.findOne(id);
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Integer id) {
        autorRepository.delete(id);
    }
}