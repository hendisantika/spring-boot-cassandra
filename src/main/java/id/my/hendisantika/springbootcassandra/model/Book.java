package id.my.hendisantika.springbootcassandra.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cassandra
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
@Data
@Table("book")
public class Book {

    @PrimaryKey
    private UUID id;

    private String title;

    private String description;

    private String author;

    private int year;

    private LocalDateTime dateCreated;
}
