package model;

import java.sql.Date;

public class Client {
	private String idClient;
	private String userName;
	private String password; 
	private String fullName;
	private String sex;
	private String address;
	private String deliveryAddress;
	private String shoppingAdress;
	private Date dob;
	private String phoneNumber;
	private String email;
	private boolean registerEmail;
	
	public Client() {
		super();
	}
	public Client(String idClient, String userName, String password, String fullName, String sex, String address,
			String deliveryAddress, String shoppingAdress, Date dob, String phoneNumber, String email,
			boolean registerEmail) {
		super();
		this.idClient = idClient;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.shoppingAdress = shoppingAdress;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.registerEmail = registerEmail;
	}
	
	
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getShoppingAdress() {
		return shoppingAdress;
	}
	public void setShoppingAdress(String shoppingAdress) {
		this.shoppingAdress = shoppingAdress;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRegisterEmail() {
		return registerEmail;
	}
	public void setRegisterEmail(boolean registerEmail) {
		this.registerEmail = registerEmail;
	}
}
