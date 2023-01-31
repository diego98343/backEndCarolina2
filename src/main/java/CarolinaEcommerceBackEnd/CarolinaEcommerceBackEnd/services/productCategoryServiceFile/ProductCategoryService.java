package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productCategoryServiceFile;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findAll();

    ProductCategory save(ProductCategory productCategory);


    ProductCategory findById(int id);


    void delete(int id);
}
