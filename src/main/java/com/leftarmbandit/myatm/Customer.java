package com.leftarmbandit.myatm;

public class Customer {
	private double accountBalance = 0;
	private long id;
	private int pin;
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public Customer setAccountBalance(double balance) {
		this.accountBalance = balance;
		return this;
	}
	public int getPin() {
		return pin;
	}
	public Customer setPin(int pin) {
		this.pin = pin;
		return this;
	}
	public long getId() {
		return id;
	}
	public Customer setId(long id) {
		this.id = id;
		return this;
	}
	
	
	
}
