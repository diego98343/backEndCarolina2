package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productCategoryServices;


import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.ProductCategory;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceML implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll(){
        return productCategoryRepository.findAll();
    }


    @Override
    public ProductCategory save(ProductCategory productC){
        productCategoryRepository.save(productC);
        return productC;
    }


    @Override
    public ProductCategory findById(int id){
        if(productCategoryRepository.findById(id).isPresent()){
            return productCategoryRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete (int id){
        ProductCategory expense= findById(id);
        productCategoryRepository.delete(expense);
    }



}
