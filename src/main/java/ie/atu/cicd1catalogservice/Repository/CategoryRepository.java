package ie.atu.cicd1catalogservice.Repository;

import ie.atu.cicd1catalogservice.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
