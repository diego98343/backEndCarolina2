package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product>findAll();

    Product save(Product product);

    Product findById(int id);

    void delete(int id);
    List<Product> findProductWithSorting(String field);

     Page<Product> findProductsWithPagination(int offset, int pageSize);

//     Page<Product> findProductsWithPaginationandSorting(int offset, int pageSize, String field);
     List<Product> findProductsByName(String productName);
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