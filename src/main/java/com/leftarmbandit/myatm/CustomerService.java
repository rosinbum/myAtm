package com.leftarmbandit.myatm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	CustomerDAO customerDAO;
	
	public Customer getCustomer(long id, int pin) throws CustomerNotFoundException{
		//only accept 4 digit pin
		if(pin<10000 && pin>=0){
			return customerDAO.getCustomer(id, pin);		}
		else{
			throw new CustomerNotFoundException();
		} 
	}
	public double getAccountBalance(Customer customer) throws CustomerNotFoundException{
		customer= customerDAO.getCustomer(customer.getId(), customer.getPin());
		return customer.getAccountBalance();
	}
	
	public Customer deposit(Customer customer, double amount) throws CustomerNotFoundException{
		return changeBalance(customer, amount);
	}
	
	public Customer withdraw(Customer customer, double amount) throws CustomerNotFoundException, InsufficientFundsException{
		if(amount > customer.getAccountBalance())
			throw new InsufficientFundsException();
		return changeBalance(customer, amount*-1);
	}
	
	private Customer changeBalance(Customer customer, double amount) throws CustomerNotFoundException{
		customer= customerDAO.getCustomer(customer.getId(), customer.getPin());
		customer.setAccountBalance(customer.getAccountBalance()+amount);
		customerDAO.updateCustomer(customer);
		return customer;
	}
	
	public void updateBalance(Customer customer){
		customerDAO.updateCustomer(customer);
	}
	
	@Autowired
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	
}
