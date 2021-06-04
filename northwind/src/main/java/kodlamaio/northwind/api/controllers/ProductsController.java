package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	
	private ProductService productService;
	
	@Autowired //ProductService i implements eden sınıfı newleyip getiriyor.(ProductManager->newlerken ProductDao istediği için onu da newliyor)
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
				
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByCategory_CategoryIdIn")
	public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories){
		return this.productService.getByCategory_CategoryIdIn(categories);
		
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByNameAndCategory_CategoryId")
	public DataResult<List<Product>> getByNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByNameAndCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	

}
