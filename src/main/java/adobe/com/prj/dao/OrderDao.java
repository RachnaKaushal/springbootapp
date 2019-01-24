/**
 * 
 */
package adobe.com.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import adobe.com.prj.entity.Order;

/**
 * @author rakausha
 *
 */
//no extra method since we are just adding and removing the products
public interface OrderDao extends JpaRepository<Order, Integer> {

}
