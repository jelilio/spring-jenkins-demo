package com.japharr.demo.service;

import com.japharr.demo.entity.Book;
import com.japharr.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();
}
