import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.products.service.ProductService;
import com.products.service.ServiceApplication;
import com.products.service.controller.ProductController;
import com.products.service.models.Product;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = ProductController.class)
@SpringBootTest( classes = ServiceApplication.class)
@AutoConfigureMockMvc 
public class ProductContollerUnitTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProductService service;

  @Test
  public void givenProducts_whenGetProducts_thenReturnJsonArray() throws Exception {

    Product product = new Product("Lenovo Yoga", "Laptop", "Electronics", 45000.00);

    List<Product> allProducts = Arrays.asList(product);

    given(service.getProducts()).willReturn(allProducts);

    mvc.perform(get("/products/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].productName", is(product.getProductName())))
        .andExpect(jsonPath("$[0].productType", is(product.getProductType())))
        .andExpect(jsonPath("$[0].productCategory", is(product.getProductCategory())))
        .andExpect(jsonPath("$[0].basePrice", is(product.getBasePrice())));
  }

  @Test
  public void givenProduct_whenGetProduct_thenReturnJson() throws Exception {
    Long id = (long) 1;
    Product product = new Product(id,"Lenovo Yoga", "Laptop", "Electronics", 45000.00);

    given(service.getProduct(id)).willReturn(product);

    mvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void givenProduct_whenPutProduct_thenReturnJson() throws Exception {

    Product product = new Product("Lenovo Yoga", "Laptop", "Electronics", 45000.00);

    Long id = (long) 10000;
    product.setProductID(id);

    given(service.editProduct(product, id)).willReturn(product);

    mvc.perform(get("/products/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void givenProduct_whenPostProduct_thenReturnJson() throws Exception {

    Product product = new Product("Lenovo Yoga", "Laptop", "Electronics", 45000.00);


    given(service.saveProduct(product)).willReturn(product);

    mvc.perform(get("/products/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}
