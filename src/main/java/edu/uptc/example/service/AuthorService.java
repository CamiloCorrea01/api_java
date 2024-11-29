package edu.uptc.example.service;

import edu.uptc.example.entityes.Author;
import edu.uptc.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService() {

    }

    public List<Author> getAuthors(){

        return authorRepository.findAll();
    }

    public Author getAuthor( Long id ) {

        Optional<Author> opt = authorRepository.findById(id);

        return opt.isPresent() ? opt.get() : null;
    }

    public Author save( Author author){
        return authorRepository.save( author );
    }

    public List<Author> findByName(String name ){

        return authorRepository.findByName( name );
    }

    public List<Author> getProjection(){

        return authorRepository.getAuthorProjection();
    }

}
