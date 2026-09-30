package ie.atu.cicd1catalogservice.Service;

import ie.atu.cicd1catalogservice.Model.Product;
import ie.atu.cicd1catalogservice.Repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        product.setId(null);
        return productRepository.save(product);
    }

    public Product getById(Long id)
    {
        return productRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found"));
    }
}
