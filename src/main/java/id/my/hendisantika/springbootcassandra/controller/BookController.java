package id.my.hendisantika.springbootcassandra.controller;

import id.my.hendisantika.springbootcassandra.model.Book;
import id.my.hendisantika.springbootcassandra.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cassandra
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = bookRepository.findAll();
        return ResponseEntity.status(200).body(bookList);
    }
}
