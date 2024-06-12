package id.my.hendisantika.springbootcassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cassandra
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @PrimaryKey
    private UUID id;

    private String make;

    private String model;

    private int year;

}
