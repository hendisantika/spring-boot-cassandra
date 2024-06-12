package id.my.hendisantika.springbootcassandra.repository;

import id.my.hendisantika.springbootcassandra.model.Car;
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
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface CarRepository extends CassandraRepository<Car, UUID> {
}
