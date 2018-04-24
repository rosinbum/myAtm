package com.leftarmbandit.myatm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leftarmbandit.myatm.Customer;
import com.leftarmbandit.myatm.CustomerNotFoundException;
import com.leftarmbandit.myatm.CustomerService;
import com.leftarmbandit.myatm.InsufficientFundsException;

@Controller
public class HomeController {
	private CustomerService customerService;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/pin/{pin}/{id}")
	@ResponseBody
	public String pin(HttpServletRequest request, HttpServletResponse response, @PathVariable int pin, @PathVariable long id){	
			try {
				Customer customer = customerService.getCustomer(id, pin);			
				request.getSession().setAttribute("customer", customer);
				return "true";
			} catch (CustomerNotFoundException e) {
				request.getSession().removeAttribute("customer");
				return "false";
			}	
	}
	
	@RequestMapping(value="/balance")
	@ResponseBody
	public String getBalance(HttpServletRequest request) throws CustomerNotFoundException{
		Customer customer = getCustomer(request);
		return ""+customerService.getAccountBalance(customer);
	}
	
	@RequestMapping(value="/withdraw/{amount}")
	@ResponseBody
	public String withdraw(HttpServletResponse response, HttpServletRequest request, @PathVariable int amount) throws CustomerNotFoundException{
		Customer customer = getCustomer(request);
		try {
			customer = customerService.withdraw(customer, amount);
		} catch (InsufficientFundsException e) {
			try {
				response.sendError(403, "Insufficient Funds");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}		
		return ""+customer.getAccountBalance();
	}
	
	@RequestMapping(value="/deposit/{amount}")
	@ResponseBody
	public String deposit(HttpServletRequest request, @PathVariable int amount) throws CustomerNotFoundException{
		Customer customer = getCustomer(request);
		customer = customerService.deposit(customer, amount);	
		return ""+customer.getAccountBalance();
	}
	
	private Customer getCustomer(HttpServletRequest request) {
		return (Customer) request.getSession().getAttribute("customer");
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
