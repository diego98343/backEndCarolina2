package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductCustomRepos;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;

import java.util.List;

public interface ProductSearchRepository {

 List<Product> findByName(String productName);
 List<Product> findByCategory(int productCategory );
 List<Product> findByReference(String productReference );

 List<Product> findByPrice(int productPrice);
}
