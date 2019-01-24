package adobe.com.prj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class LineItem {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@ManyToOne
		@JoinColumn(name="pid")
		private Product product;
		
		private int qty;
		
		private double amount;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public double getAmount() {

			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		
}
	
	