package adobe.com.prj.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import adobe.com.prj.dao.CustomerDao;
import adobe.com.prj.dao.OrderDao;
import adobe.com.prj.dao.ProductDao;
import adobe.com.prj.entity.Customer;
import adobe.com.prj.entity.LineItem;
import adobe.com.prj.entity.Order;
import adobe.com.prj.entity.Product;

@Service
public class OrderService {
//service object will be created
	@Autowired
	//@Qualifier("a") //to tell which bean needs to be injected when there is an ambiguity
	//erroor : need one found three , "a" is given as name of repository if there are multiple implemntation
	private ProductDao productDao;
	
/*	@Autowired
	private CustomerDao customerDao;
*/
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		productDao.save(p); //save is the default method provided
	}


	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll(); //get products become findall
	}


	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.getOne(id);
	}
	
	public List<Product> getProductsByPrice(double price){
		return productDao.getProductsAbovePrice(price);
	}
	
/*	@Transactional
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(c);
		
	}

	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	*/
	
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	/* (non-Javadoc)
	 * @see adobe.com.prj.dao.OrderDao#placeOrder(adobe.com.prj.entity.Order)
	 */
	@Transactional
	public void placeOrder(Order order) {
		orderDao.save(order);
		//products quantity should be decreased
		List<LineItem> items= order.getItems();
		for(LineItem item : items) {
			Product p = productDao.getOne(item.getProduct().getId()); //getone is changed here
			p.setQuantity(p.getQuantity() - item.getQty());
			//here the line 85 pulls the product object into persistence context and from there the objects are automativally synbced to db
		}
	}
	
}
