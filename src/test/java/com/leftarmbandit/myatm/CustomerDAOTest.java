package com.leftarmbandit.myatm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerDAOTest extends CustomerDAO {
	
	
	
	@Test
	public void createNew() throws CustomerNotFoundException{
		Customer customer = getCustomer(1234l, 123);
		assertEquals(1, customers.size());	
	}
	
	@Test
	public void createMultipul() throws CustomerNotFoundException{
		getCustomer(1234, 1234);
		getCustomer(12345, 1234);
		try{
			getCustomer(1234, 9999);
		}
		catch(CustomerNotFoundException e){} // expected exception
		assertEquals(2, customers.size());
		
	}
	

}
