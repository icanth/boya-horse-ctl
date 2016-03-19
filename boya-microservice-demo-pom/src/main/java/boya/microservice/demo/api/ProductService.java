package boya.microservice.demo.api;

import boya.microservice.demo.api.dto.Product;

import java.util.List;

/**
 * Created by boyagaga on 3/19/16.
 */
public interface ProductService {

    List<Product> findProductsByName(String name);

}
