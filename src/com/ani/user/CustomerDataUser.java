package com.ani.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ani.beans.Customer;
import com.ani.services.CustomerService;

public class CustomerDataUser 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Customer customer = new Customer();
		CustomerService service = new CustomerService();
		
		while(true)
		{
			System.out.println("=== BUY PRODUCT MENU ===\r\n"
					+ "1. Add New User\r\n"
					+ "2. Fetch User Details\r\n"
					+ "3. Delete User\r\n"
					+ "4. Add Money to Wallet\r\n"
					+ "5. Purchase Product\r\n"
					+ "6. View Wallet Balance\r\n"
					+ "7. Update Photo\r\n"
					+ "8. Exit\r\n"
					+ "");
			
			System.out.println("Enter choice :");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Customer Name :");
				String name = sc.nextLine();
				
				System.out.println("Enter Customer email Id :");
				String email = sc.nextLine();
				
				System.out.println("Enter Customer initial wallet balance :");
				double balance = Double.parseDouble(sc.nextLine());
				
				System.out.println("Enter customer Address :");
				String address = sc.nextLine();
				
				System.out.println("Enter Photo Path :");
				String photo = sc.nextLine();
				
				File file = new File(photo);
				
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					customer = new Customer(id, name, email, balance, address, fileInputStream);
					int customer2 = service.addCustomer(customer);
					
					if(customer2>0)
					{
						System.out.println("✅ User Added Successfully!\n");
					} else {
						System.err.println("User Not added!!\n");
					}
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
			case 2 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				service.fetchDetails(id);
			}
			case 3 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				int deleteUser = service.deleteUser(id);
				
				if(deleteUser>0)
					System.out.println("✅ Customer deleted Successfully!\n");
				else 
					System.out.println("Customer NOT Deleted\n");
			}
			case 4 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount you want to add to Walllet :");
				double amount = Double.parseDouble(sc.nextLine());
				
				service.addMoney(amount, id);
			}
			case 5 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Product Price: ");
				double price = Double.parseDouble(sc.nextLine());
				
				service.purchaseProduct(price, id);
			}
			case 6 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				service.viewBalance(id);
			}
			case 7 ->{
				System.out.println("Enter Customer User ID :");
				int id = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter New Product path :");
				String path = sc.nextLine();
				File file = new File(path);
				
				try {
					service.updateUserPhoto(new FileInputStream(file), id);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 8 ->{
				System.out.println("Thank you for visiting!!!");
				System.exit(0);
			}
			}
		}
	}
}
