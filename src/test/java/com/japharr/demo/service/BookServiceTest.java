package com.japharr.demo.service;

import com.japharr.demo.entity.Book;
import com.japharr.demo.repository.BookRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @AfterAll
    void clear() {
        bookRepository.deleteAll();
    }

    @Test
    void find_all_test() {
        Book book1 = new Book(1L, "How to Program, Java", "Deitel and Deitel");
//        Book book2 = new Book(2L, "How to Program, C", "Deitel and Deitel");
//        List<Book> books = List.of(book1, book2);
//        Mockito.when(bookRepository.findAll()).thenReturn(books);
        bookRepository.save(book1);
        BookService bookService = new BookServiceImpl(bookRepository);

        List<Book> result = bookService.findAll();
        Book firstBook = result.get(0);

        assertEquals(result.size(), 3);
        assertEquals(firstBook.getId(), 2);
        assertEquals(firstBook.getTitle(), "How to Program, Java");
    }
}
