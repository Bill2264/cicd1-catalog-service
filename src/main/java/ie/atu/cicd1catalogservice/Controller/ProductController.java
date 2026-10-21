package ie.atu.cicd1catalogservice.Controller;

import ie.atu.cicd1catalogservice.Model.Product;
import ie.atu.cicd1catalogservice.Service.ProductService;
import ie.atu.cicd1catalogservice.dto.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct()
    {
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  Product createProduct(@RequestBody CreateProductRequest request)
    {
        return  productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return  productService.getById(id);
    }

    @GetMapping("/min-price")
    public List<Product> getProductByminprice(@RequestParam("price") BigDecimal price)
    {
        return productService.findByMinPrice(price);
    }

    @GetMapping("/by-category")
    public List<Product> getProductByCategory(@RequestParam("name") String categoryName)
    {
        return productService.findbyCategoryName(categoryName);
    }
}
