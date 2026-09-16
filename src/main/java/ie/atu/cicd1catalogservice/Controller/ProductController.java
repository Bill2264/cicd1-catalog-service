package ie.atu.cicd1catalogservice.Controller;

import ie.atu.cicd1catalogservice.Model.Product;
import ie.atu.cicd1catalogservice.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAll();
    }

    @PostMapping
    public  Product createProduct(@RequestBody Product product)
    {
        return  productService.createProduct(product);
    }
}
