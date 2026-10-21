package ie.atu.cicd1catalogservice.Repository;

import ie.atu.cicd1catalogservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query("SELECT p FROM Product  p WHERE p.price >= :minprice ORDER BY p.price ASC")
    List<Product> findByMinPrice(@Param("minprice") BigDecimal minprice);
}
