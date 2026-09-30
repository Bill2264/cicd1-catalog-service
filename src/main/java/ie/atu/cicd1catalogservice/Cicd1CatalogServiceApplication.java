package ie.atu.cicd1catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Cicd1CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cicd1CatalogServiceApplication.class, args);
    }

}
