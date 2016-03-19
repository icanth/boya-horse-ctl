package boya.microservice.demo.product

import boya.microservice.demo.api.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by boyagaga on 3/19/16.
 */
@RestController
@Scope("session")
public class ProductController implements Serializable {

    @Autowired
    ProductService productService

    @RequestMapping(value = "/getproductsbyname", method = RequestMethod.GET, produces = "application/json")
    def getProductsByName(@RequestParam String name) {
        return [
                "code"    : 200,
                "products": productService.findProductsByName(name)
        ]
    }
}
