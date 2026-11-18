package ie.atu.cicd1catalogservice.Service;

import ie.atu.cicd1catalogservice.Model.Category;
import ie.atu.cicd1catalogservice.Model.Product;
import ie.atu.cicd1catalogservice.Repository.CategoryRepository;
import ie.atu.cicd1catalogservice.Repository.ProductRepository;


import ie.atu.cicd1catalogservice.dto.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    public Product createProduct(CreateProductRequest request)
    {
        if (request.categoryId() == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category id is required");
        }
        Category category = categoryRepository
                .findById(request.categoryId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category does not exist"));


        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return productRepository.save(product);
    }

    public Product getById(Long id)
    {
        return productRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found"));
    }

    public List<Product> findByMinPrice(BigDecimal minprice)
    {
        return productRepository.findByMinPrice(minprice);
    }

    public List<Product> findbyCategoryName(String categoryName)
    {
        return productRepository.findByCategoryName(categoryName);
    }
}
