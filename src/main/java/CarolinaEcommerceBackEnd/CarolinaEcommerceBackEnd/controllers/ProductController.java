package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Attachment;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.ProductCategory;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductCustomRepos.ProductSearchRepository;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductRepository;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productCategoryServiceFile.ProductCategoryService;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.productServiceFile.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    @Autowired
    public ProductCategoryService productCategoryService;



    @GetMapping("/products")
    public ResponseEntity<List<Product>> get() {
      List<Product> product= productService.findAll();
      return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    //find product by name controller
    @GetMapping("/products/searchByName/{productName}")
    public ResponseEntity<List<Product>>sortByname(@PathVariable("productName")String productName){

        List<Product> productsByName = productService.findProductsByName(productName);

        return  new ResponseEntity<List<Product>>(productsByName,HttpStatus.OK);

    }

    @GetMapping("/products/searchByReference/{productReference}")
    public ResponseEntity<List<Product>>searchProductByReference(@PathVariable("productReference")String productReference){

        List<Product> products = productRepository.findByReference(productReference);

        return  new ResponseEntity<List<Product>>(products,HttpStatus.OK);

    }

    //find product by category controller
    @GetMapping("/products/searchByCategory/{productCategory}")
    public ResponseEntity<List<Product>>sortByCategory(@PathVariable("productCategory")int productCategory){

        List<Product> products = productRepository.findByCategory(productCategory);

        return  new ResponseEntity<List<Product>>(products,HttpStatus.OK);

    }

    // sort product by give field from bigger to smaller
    @GetMapping("/product/sortBy/{field}")
    private ResponseEntity<List<Product>> getProductWithSort(@PathVariable String field){
        List<Product> allProducts= productService.findProductWithSorting(field);

        return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
    }

    //get all products with pagination

    @GetMapping("/products/pagination/{offset}/{pageSize}")
    private ResponseEntity<Page<Product>> getProductWithPagination(@PathVariable int offset,@PathVariable int pageSize) {
        Page<Product> allProducts = productService.findProductsWithPagination(offset, pageSize);
        return new ResponseEntity<Page<Product>>(allProducts, HttpStatus.OK);
    }


    //custom repository query

    @PostMapping("/products")
    public ResponseEntity<Product>save( @RequestBody Product product){
        Product product1 = productService.save(product);
        return new  ResponseEntity<Product>(product1,HttpStatus.CREATED);
    }
//    @GetMapping("productsBaseOnCategory/{id}")
//    public List<Product> returnAllProductsUsingCategoryId(@PathVariable("id")int id){
//
//        List<Product> allProducts = productService.findAll();
//
//        for(Product product : allProducts){
//
//        }
//       return null;
//    }


    //----------------------------------------------POST_REQUEST_MULTIPLE-----------------------------------------------------------

    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile")MultipartFile[] file)
                                {

        try{
            Set<Attachment> images = uploadImage(file);
            product.setProductImage(images);;

            return  productService.save(product);

        }catch(Exception e){
           System.out.println(e.getMessage());
        }

          return null;
    }



    public Set<Attachment> uploadImage(MultipartFile[] multipartFiles) throws IOException {

        Set<Attachment> imageModels= new HashSet<>();

        for(MultipartFile file:multipartFiles){
           Attachment imageModel= new Attachment(
                   file.getOriginalFilename(),
                   file.getContentType(),
                   file.getBytes()
           );
           imageModels.add(imageModel);
        }
        return imageModels;
    }


//------------------------------------------------------------------------------------------------------------

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable("id")int id){
        Product expense= productService.findById(id);
        return new ResponseEntity<Product>(expense,HttpStatus.OK);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        productService.delete(id);
        return new ResponseEntity<String>("Expense is deleted",HttpStatus.OK);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")int id, @RequestBody Product product){

        Product tempProduct  = productService.findById(id);

        tempProduct.setProductName(product.getProductName());
        tempProduct.setProductPrice(product.getProductPrice());
        tempProduct.setDescription(product.getDescription());
        tempProduct.setImageURl(product.getImageURl());
        tempProduct.setUnitsInStock(product.getUnitsInStock());
        tempProduct.setProductReference(product.getProductReference());
        tempProduct.setProductCategory(product.getProductCategory());

        Product updatedProduct = productService.save(tempProduct);
        return ResponseEntity.ok( updatedProduct);
    }






}
