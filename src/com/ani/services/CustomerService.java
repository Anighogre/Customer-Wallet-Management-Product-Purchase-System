package com.ani.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ani.beans.Customer;
import com.ani.connection.ConnectionProvider;

public class CustomerService implements ICustomerService {

	@Override
	public int addCustomer(Customer customer) 
	{
		int res = 0;
		Connection con = ConnectionProvider.getConnection();
		String query = "INSERT INTO user_account VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, customer.getUser_id());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setDouble(4, customer.getWallet_balance());
			pstmt.setString(5, customer.getAddress());
			pstmt.setBlob(6, customer.getInputStream());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void fetchDetails(int user_id) 
	{
		Connection con = ConnectionProvider.getConnection();
		String query = "SELECT * FROM user_account WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Customer User ID :"+rs.getInt(1)+"\nCustomer Namae :"+rs.getString(2)+"\nCustomer Email :"+rs.getString(3)+"\nCustomer Available wallet Balance :"+rs.getDouble(4)+"\nCustomer Address :"+rs.getString(5)+"\nProduct Photo :"+rs.getBlob(6)+"\n");
				
				File file = new File("C:\\Users\\ani\\OneDrive\\Pictures\\Product-1.jpg");
				
				try {
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					
					InputStream binaryStream = rs.getBinaryStream(6);
					
					try {
						byte[] allBytes = binaryStream.readAllBytes();
						
						fileOutputStream.write(allBytes);
						System.out.println("Data Successfully Retrived!!\n");
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int deleteUser(int user_id) 
	{
		int res = 0;
		Connection con = ConnectionProvider.getConnection(); 
		String query = "DELETE FROM user_account WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user_id);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void addMoney(double amount, int user_id) 
	{
		Connection con = ConnectionProvider.getConnection(); 
		String query = "UPDATE user_account SET WALLET_BALANCE = WALLET_BALANCE + ? WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, user_id);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount>0)
				System.out.println("✅ Amount Added to wallet Successfully!\n");
			else 
				System.out.println("Aount Not Added\n");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void purchaseProduct(double amount, int user_id) 
	{
		Connection con = ConnectionProvider.getConnection(); 
		String query = "UPDATE user_account SET WALLET_BALANCE = WALLET_BALANCE - ? WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(2, user_id);
			pstmt.setDouble(1, amount);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount>0)
			{
				System.out.println("💰 Product Purchased Successfully!");
			} else {
				System.err.println("💰 Product Not Purchased!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void viewBalance(int user_id) 
	{
		Connection con = ConnectionProvider.getConnection(); 
		String query = "SELECT WALLET_BALANCE FROM user_account WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Available Wallet Balance :"+rs.getDouble(1)+"\n");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUserPhoto(InputStream inputStream, int user_id) 
	{
		Connection con = ConnectionProvider.getConnection(); 
		String query = "UPDATE user_account SET PHOTO=? WHERE USER_ID=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(2, user_id);
			pstmt.setBlob(1, inputStream);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount>0)
			{
				System.out.println("✅ Product’s stored photo is updated Successfully!!\n");
			} else {
				System.err.println("Photo Not updated!!\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
