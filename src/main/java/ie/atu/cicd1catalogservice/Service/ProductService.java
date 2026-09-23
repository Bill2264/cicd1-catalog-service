package ie.atu.cicd1catalogservice.Service;

import ie.atu.cicd1catalogservice.Model.Product;
import ie.atu.cicd1catalogservice.Repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    public Product createProduct(Product product)
    {

        return productRepository.save(product);
    }
}
