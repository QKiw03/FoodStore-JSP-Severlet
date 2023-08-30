package model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	private String idOrder;
	private Client client;
	private String shoppingAddress;
	private String deliveryAddress;
	private String status;
	private String payments; 
	private String paymentStatus;
	private double amountPaid;
	private double amountMiss;
	private Date dateOrder;
	private Date dateDelivery;
	public Order() {
	}
	public Order(String idOrder, Client client, String shoppingAddress, String deliveryAddress, String status,
			String payments, String paymentStatus, double amountPaid, double amountMiss, Date dateOrder,
			Date dateDelivery) {

		this.idOrder = idOrder;
		this.client = client;
		this.shoppingAddress = shoppingAddress;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.payments = payments;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.amountMiss = amountMiss;
		this.dateOrder = dateOrder;
		this.dateDelivery = dateDelivery;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getShoppingAddress() {
		return shoppingAddress;
	}
	public void setShoppingAddress(String shoppingAddress) {
		this.shoppingAddress = shoppingAddress;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayments() {
		return payments;
	}
	public void setPayments(String payments) {
		this.payments = payments;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public double getAmountMiss() {
		return amountMiss;
	}
	public void setAmountMiss(double amountMiss) {
		this.amountMiss = amountMiss;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public Date getDateDelivery() {
		return dateDelivery;
	}
	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idOrder);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(idOrder, other.idOrder);
	}
	
}
