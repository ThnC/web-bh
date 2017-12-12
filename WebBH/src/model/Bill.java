package model;

import java.sql.Timestamp;

public class Bill {

	private String bill_id;
	private Users users;
	private String address;
	private String payment;
	private Timestamp date_buy;
	private int bill_status;
	
	public Bill() {
		super();
	}

	public Bill(String bill_id, Users users, String address, String payment, Timestamp date_buy, int bill_status) {
		super();
		this.bill_id = bill_id;
		this.users = users;
		this.address = address;
		this.payment = payment;
		this.date_buy = date_buy;
		this.bill_status = bill_status;
	}

	public String getBill_id() {
		return bill_id;
	}

	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Timestamp getDate_buy() {
		return date_buy;
	}

	public void setDate_buy(Timestamp date_buy) {
		this.date_buy = date_buy;
	}

	public int getBill_status() {
		return bill_status;
	}

	public void setBill_status(int bill_status) {
		this.bill_status = bill_status;
	}


	
}
