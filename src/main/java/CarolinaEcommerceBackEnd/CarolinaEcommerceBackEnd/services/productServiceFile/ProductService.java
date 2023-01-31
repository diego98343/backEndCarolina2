package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productServiceFile;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    List<Product>findAll();

    Product save(Product product);

    Product findById(int id);

    void delete(int id);

//    List<Product>findProductsByCategoryId(int id);


}

















//Category.servisml
//    @Autowired
//    ProductCategoryRepository productCategoryRepository;
//
//
//    @Override
//    public List<ProductCategory> findAll(){
//       return productCategoryRepository.findAll();
//    }
//
//
//    @Override
//    public ProductCategory save(ProductCategory productCategory){
//        productCategoryRepository.save(productCategory);
//
//        return productCategory;
//    }