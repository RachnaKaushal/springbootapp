package adobe.com.prj.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.*;
import java.util.*;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	private String email;
	
	@Column(name="first_name",length=100)
	private String firstName;

	public Customer(String email, String firstName) {
		super();
		this.email = email;
		this.firstName = firstName;
	}
	
	public Customer() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
