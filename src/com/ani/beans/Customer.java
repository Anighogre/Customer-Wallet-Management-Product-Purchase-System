package com.ani.beans;

import java.io.InputStream;

public class Customer 
{
	private int user_id;
	private String name;
	private String email;
	private double wallet_balance;
	private String address;
	private InputStream inputStream;
	
	public Customer ()
	{
		
	}
	
	public Customer(int user_id, String name, String email, double wallet_balance, String address,
			InputStream inputStream) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.wallet_balance = wallet_balance;
		this.address = address;
		this.inputStream = inputStream;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getWallet_balance() {
		return wallet_balance;
	}

	public void setWallet_balance(double wallet_balance) {
		this.wallet_balance = wallet_balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", name=" + name + ", email=" + email + ", wallet_balance="
				+ wallet_balance + ", address=" + address + ", inputStream=" + inputStream + "]";
	}
	
	
}
