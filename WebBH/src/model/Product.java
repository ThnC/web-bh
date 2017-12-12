
package model;

public class Product implements Comparable<Product> {

	private String product_id;
	private Category category;
	private String product_name;
	private String product_image;
	private double product_price;
	private int product_quantity;
	private String product_description;
	private Product product;

	

	public Product() {
		super();
	}



	public Product(String product_id, Category category, String product_name, String product_image,
			double product_price, int product_quantity, String product_description, Product product) {
		super();
		this.product_id = product_id;
		this.category = category;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_description = product_description;
		this.product = product;
	}





	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getProduct_image() {
		return product_image;
	}



	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}



	public double getProduct_price() {
		return product_price;
	}



	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}



	public int getProduct_quantity() {
		return product_quantity;
	}



	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}



	public String getProduct_description() {
		return product_description;
	}



	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public int compareTo(Product sp) {
		return Integer.parseInt(this.product_id) - Integer.parseInt(sp.product_id);
	}

}
