package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.ProductCategory;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productCategoryServiceFile.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductCategoryController {
    @Autowired
    public ProductCategoryService productCategoryService;
//

    @GetMapping("/productCategories")
    public ResponseEntity<List<ProductCategory>> get(){
       List<ProductCategory> categories= productCategoryService.findAll();
       return new ResponseEntity<List<ProductCategory>>(categories,HttpStatus.OK);
    }

    @PostMapping("/productCategories")
    public ResponseEntity<ProductCategory>save(@RequestBody ProductCategory productCategory){
        ProductCategory productCategory1= productCategoryService.save(productCategory);
        return new ResponseEntity<ProductCategory>(productCategory1,HttpStatus.OK);
    }

    @GetMapping("/productCategories/{id}")
    public ResponseEntity<ProductCategory> get(@PathVariable("id")int id){
        ProductCategory expense= productCategoryService.findById(id);
        return new ResponseEntity<ProductCategory>(expense,HttpStatus.OK);
    }


    @DeleteMapping("/productCategories/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        productCategoryService.delete(id);
        return new ResponseEntity<String>("Expense is deleted",HttpStatus.OK);
    }


}
