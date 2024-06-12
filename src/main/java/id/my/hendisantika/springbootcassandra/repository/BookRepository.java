package id.my.hendisantika.springbootcassandra.repository;

import id.my.hendisantika.springbootcassandra.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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
@Repository
public interface BookRepository extends CassandraRepository<Book, UUID> {
}
