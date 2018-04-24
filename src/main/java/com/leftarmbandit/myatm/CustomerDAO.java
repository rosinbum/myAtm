package com.leftarmbandit.myatm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CustomerDAO {
	//This is a fake DAO and will just create new customers with random balances as required
	
	//Data Storage
	protected Map<Long, Customer> customers = new HashMap<Long,Customer>();
	
	public Customer getCustomer(long id, int pin) throws CustomerNotFoundException{	
		if(customers.get(id) != null){
			Customer customer = customers.get(id);
			if(pin == customer.getPin()){
				return customer;
			}
			else{
				throw new CustomerNotFoundException();
			}
		}
		int pennies = (int) (Math.random()*100000); 
		Customer customer =  new Customer().setId(id).setPin(pin).setAccountBalance((pennies/100));
		customers.put(customer.getId(), customer);
		return customer;
	}
	public void updateCustomer(Customer customer){		
		customers.put(customer.getId(), customer);
	}
}
