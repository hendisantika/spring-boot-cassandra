package id.my.hendisantika.springbootcassandra.repository;

import id.my.hendisantika.springbootcassandra.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cassandra
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @Query("select * from product where product_id in :productIds")
    List<Product> findByProductIds(@Param("productIds") List<UUID> productIds);

    @Query("select * from product where product_id = :productId and product_name in :productNames")
    List<Product> findByProductIdAndNames(@Param("productId") UUID productId, @Param("productNames") List<String> productNames);
}
