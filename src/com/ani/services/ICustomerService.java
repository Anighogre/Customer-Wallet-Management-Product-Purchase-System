package com.ani.services;

import java.io.InputStream;

import com.ani.beans.Customer;

public interface ICustomerService 
{
	public int addCustomer(Customer customer);
	public void fetchDetails(int user_id);
	public int deleteUser(int user_id);
	public void addMoney(double amount, int user_id);
	public void purchaseProduct(double amount, int user_id);
	public void viewBalance(int user_id);
	public void updateUserPhoto(InputStream inputStream, int user_id);
	
}
