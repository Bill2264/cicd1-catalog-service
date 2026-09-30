package ie.atu.cicd1catalogservice.Repository;

import ie.atu.cicd1catalogservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
