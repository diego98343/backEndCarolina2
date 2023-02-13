package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productServiceFile;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderRepository;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceML implements ProductService {

    @Autowired
    ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ProductServiceML(ProductRepository productRepository,
                            OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
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

    @Override
    public List<Product> findProductWithSorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Page<Product> findProductsWithPagination(int offset,int pageSize){
       Page<Product> products =  productRepository.findAll(PageRequest.of(offset,pageSize));
        return products;
    }



}
