import boya.microservice.demo.Application
import boya.microservice.demo.product.ProductController
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.client.RestTemplate
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Created by boyagaga on 3/20/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
class ProductServiceIntegrationTestsForJUnit {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ProductController purchaseController;

    RestTemplate template = new TestRestTemplate();

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build()
    }

    @Test
    public void testFindProductsByName() {
        def result = this.mockMvc.perform(get("/getproductsbyname")
                .param("name", "whitehorse"))
                .andExpect(status().isOk())
                .andExpect(
                content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("code").value(200))
        println result
    }

}
