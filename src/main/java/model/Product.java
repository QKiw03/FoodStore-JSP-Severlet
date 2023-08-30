package model;

public class Product {
	private String idProduct;
	private String nameProduct;
	private Supplier supplier;
	private int date; // HSD
	private double importPrice; // Giá nhập
	private double cost; // Giá gốc
	private double price; // Giá bán
	private int count;
	private TypeOfFood typeOfFood;;
	private String story;
	public Product() {
	}
	public Product(String idProduct, String nameProduct, Supplier supplier, int date, double importPrice, double cost,
			double price, int count, TypeOfFood typeOfFood, String story) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.supplier = supplier;
		this.date = date;
		this.importPrice = importPrice;
		this.cost = cost;
		this.price = price;
		this.count = count;
		this.typeOfFood = typeOfFood;
		this.story = story;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public TypeOfFood getTypeOfFood() {
		return typeOfFood;
	}
	public void setTypeOfFood(TypeOfFood typeOfFood) {
		this.typeOfFood = typeOfFood;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}

}
