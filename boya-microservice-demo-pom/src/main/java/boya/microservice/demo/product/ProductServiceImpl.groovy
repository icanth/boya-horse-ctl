package boya.microservice.demo.product

import boya.microservice.demo.api.ProductService
import boya.microservice.demo.api.dto.Product
import boya.microservice.demo.product.dao.ProductDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by boyagaga on 3/19/16.
 */
@Service("ProductService")
class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    List<Product> findProductsByName(String name) {
        return productDao.findByName(name)
    }

}
