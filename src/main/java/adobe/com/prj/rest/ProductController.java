package adobe.com.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import adobe.com.prj.entity.Product;
import adobe.com.prj.service.OrderService;

@RestController
public class ProductController {

	@Autowired
	private OrderService orderservice;
	
	@RequestMapping(value="products", method= RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){
		return orderservice.getProducts();
	}
	
	@RequestMapping(value="products/{id}",method=RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id")int id) {
		return orderservice.getProduct(id);		
	}
	
	@RequestMapping(value="products",method=RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		orderservice.addProduct(p);
		return new ResponseEntity<Product>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="products/filter",method=RequestMethod.GET)
	public @ResponseBody List<Product> getProductsByPrice(@RequestParam("price") double price){
		return orderservice.getProductsByPrice(price);
	}
}
