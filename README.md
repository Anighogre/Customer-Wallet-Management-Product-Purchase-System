# 🧾 Customer Wallet Management & Product Purchase System  
*A Java Console-Based Application using OOP, File Handling, and Service Layer Architecture*

This is a console-based Java application that allows customers to register, manage wallet balance, update profile photo, and purchase products.  
It demonstrates **Object-Oriented Programming, Layered Architecture, File Input Handling, Stream Operations, and CRUD-style operations**.

---

## 🚀 Features

### 👤 Customer Management
- Add New Customer with:
  - ID  
  - Name  
  - Email  
  - Address  
  - Profile Photo (stored using FileInputStream)  
  - Initial Wallet Balance  

- Fetch User Details  
- Delete Customer  

---

### 💰 Wallet Management
- Add money to wallet  
- View wallet balance  

---

### 🛒 Purchase System
- Purchase product by entering price  
- Updates wallet balance  
- Prevents purchase if insufficient balance  

---

### 🖼 Profile Photo Update
- Update customer’s stored photo using:
```java
FileInputStream fileInputStream = new FileInputStream(file);

