package model;

public class BillDetails {
	private int bill_detail_id;
	private Bill bill;
	private Product product;
	private int product_quantity;
	private Double product_price;
	
	
	
	public BillDetails() {
		super();
	}



	public BillDetails(int bill_detail_id, Bill bill, Product product, int product_quantity, Double product_price) {
		super();
		this.bill_detail_id = bill_detail_id;
		this.bill = bill;
		this.product = product;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
	}



	public int getBill_detail_id() {
		return bill_detail_id;
	}



	public void setBill_detail_id(int bill_detail_id) {
		this.bill_detail_id = bill_detail_id;
	}



	public Bill getBill() {
		return bill;
	}



	public void setBill(Bill bill) {
		this.bill = bill;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getProduct_quantity() {
		return product_quantity;
	}



	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}



	public Double getProduct_price() {
		return product_price;
	}



	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	
	

	
	
}
