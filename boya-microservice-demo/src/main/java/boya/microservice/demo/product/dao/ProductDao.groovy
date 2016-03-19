package boya.microservice.demo.product.dao

import boya.microservice.demo.api.dto.Product
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by boyagaga on 3/19/16.
 */
public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

}

