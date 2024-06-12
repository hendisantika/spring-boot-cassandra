package id.my.hendisantika.springbootcassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;
import id.my.hendisantika.springbootcassandra.model.Book;
import id.my.hendisantika.springbootcassandra.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest
class SpringBootCassandraApplicationTests {
    @Container
    public static final CassandraContainer<?> cassandra
            = new CassandraContainer<>("cassandra:4.1.5").withExposedPorts(9042);
    private static final String KEYSPACE_NAME = "naruto";
    @Autowired
    private BookRepository bookRepository;

    @BeforeAll
    static void setupCassandraConnectionProperties() {
        System.setProperty("spring.cassandra.keyspace-name", KEYSPACE_NAME);
        System.setProperty("spring.cassandra.contact-points", cassandra.getContainerIpAddress());
        System.setProperty("spring.cassandra.port", String.valueOf(cassandra.getMappedPort(9042)));
        createKeyspace(cassandra.getCluster());
    }

    private static void createKeyspace(Cluster cluster) {
        try (Session session = cluster.connect()) {
            session.execute("CREATE KEYSPACE IF NOT EXISTS " + KEYSPACE_NAME +
                    " WITH replication = \n" +
                    "{'class':'SimpleStrategy','replication_factor':'1'};");
        }
    }

    @Test
    void givenCassandraContainer_whenSpringContextIsBootstrapped_thenContainerIsRunningWithNoExceptions() {
        assertThat(cassandra.isRunning()).isTrue();
    }

    @Test
    void givenValidCarRecord_whenSavingIt_thenRecordIsSaved() {
        UUID bookId = UUIDs.timeBased();
        Book newBook = new Book(bookId, "Nissan", "Qashqai", "Hendi Santika", 2018);

        bookRepository.save(newBook);

        List<Book> savedBooks = bookRepository.findAllById(List.of(bookId));
        assertThat(savedBooks.get(0)).isEqualTo(newBook);
    }

}
