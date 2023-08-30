package model;

public class OrderDetails {
	private String idOrderDetails;
	private Order order;
	private Product product;
	private double count;
	private double cost;
	private double discount;
	private	double price;
	private double taxVAT;
	private double totalMoney;
	public OrderDetails() {
	}
	public OrderDetails(String idOrderDetails, Order order, Product product, double count, double cost, double discount,
			double price, double taxVAT, double totalMoney) {
		this.idOrderDetails = idOrderDetails;
		this.order = order;
		this.product = product;
		this.count = count;
		this.cost = cost;
		this.discount = discount;
		this.price = price;
		this.taxVAT = taxVAT;
		this.totalMoney = totalMoney;
	}
	public String getIdOrderDetails() {
		return idOrderDetails;
	}
	public void setIdOrderDetails(String idOrderDetails) {
		this.idOrderDetails = idOrderDetails;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTaxVAT() {
		return taxVAT;
	}
	public void setTaxVAT(double taxVAT) {
		this.taxVAT = taxVAT;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}
