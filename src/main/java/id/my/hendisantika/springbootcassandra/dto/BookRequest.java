package id.my.hendisantika.springbootcassandra.dto;

import lombok.Data;

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
public class BookRequest {
    private String title;
    private String description;
    private String author;
    private int year;
}
