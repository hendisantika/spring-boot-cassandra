package id.my.hendisantika.springbootcassandra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.springbootcassandra.model.Book;
import id.my.hendisantika.springbootcassandra.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cassandra
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void shouldReturnListOfBooks() throws Exception {
        // Mock data
        Book createBook = new Book();
        createBook.setId(UUID.randomUUID());
        createBook.setTitle("Sample Book");
        createBook.setDescription("Sample Description");
        createBook.setAuthor("John Doe");
        createBook.setYear(2022);
        createBook.setDateCreated(LocalDateTime.now());

        List<Book> books = List.of(createBook);

        // Mocking repository behavior
        when(bookRepository.findAll()).thenReturn(books);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Sample Book"))
                .andExpect(jsonPath("$[0].author").value("John Doe"));
    }
}
