package edu.uptc.example.service;

import edu.uptc.example.entityes.Book;
import edu.uptc.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){

        return bookRepository.findAll();
    }


}
