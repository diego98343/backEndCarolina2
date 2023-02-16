package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductCustomRepos.ProductSearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, ProductSearchRepository {


}
