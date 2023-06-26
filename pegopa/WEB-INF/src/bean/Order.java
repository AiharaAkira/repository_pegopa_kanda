package bean;

import java.sql.Timestamp;

public class Order {

	private int id;
	private String email;
	private String user_name;
	private String address;
	private int quantity;
	private Timestamp orderdate;
	private String content;
	private String deposit;
	private String shipping;
	private int account_id;
	private int uniform_id;
	private String uniform_name;
	private int price;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUniform_id() {
		return uniform_id;
	}
	public void setUniform_id(int uniform_id) {
		this.uniform_id = uniform_id;
	}
	public String getUniform_name() {
		return uniform_name;
	}
	public void setUniform_name(String uniform_name) {
		this.uniform_name = uniform_name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}




}
