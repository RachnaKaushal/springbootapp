package adobe.com.prj.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adobe.com.prj.entity.Order;
import adobe.com.prj.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//Here in get call all the details of customers and product also come
	//items : one to many by default is lazy and many to one is eager
	@RequestMapping(value="orders",method=RequestMethod.GET)
	public @ResponseBody List<Order> getOrders()
	{
		return orderService.getOrders();
	}
	
	
	@RequestMapping(value="orders",method=RequestMethod.POST)
	public ResponseEntity<Order> placeOrder(@RequestBody Order order){
		orderService.placeOrder(order);
		return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
}
