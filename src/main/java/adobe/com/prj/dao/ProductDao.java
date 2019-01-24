/**
 * 
 */
package adobe.com.prj.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import adobe.com.prj.entity.Product;

/**
 * @author rakausha
 *
 */
// by this we need not implement get products the function is in JPA repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p where p.quantity > 0")
	List<Product> getAvailableProducts();

	@Query("SELECT p FROM Product p where p.price > :pr")
	List<Product> getProductsAbovePrice(@Param("pr") double price);
	// we are setting query above function without much efforts
	
	
}
