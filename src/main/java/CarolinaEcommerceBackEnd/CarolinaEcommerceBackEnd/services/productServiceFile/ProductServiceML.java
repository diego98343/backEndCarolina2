package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productServiceFile;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceML implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceML(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product>findAll(){
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product){

         productRepository.save(product);
         return product;
    }

    @Override
    public Product findById(int id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        return null;
    }


    @Override
    public void delete (int id){
        Product expense= findById(id);
        productRepository.delete(expense);
    }



}
