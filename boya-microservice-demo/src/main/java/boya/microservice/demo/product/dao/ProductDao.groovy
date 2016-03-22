package boya.microservice.demo.product.dao

import boya.microservice.demo.api.dto.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by boyagaga on 3/19/16.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

}

