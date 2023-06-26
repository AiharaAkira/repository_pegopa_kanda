package bean;

public class Account {


	private int id;
	private String pw;
	private String name;
	private String address;
	private String email;
	private int authority;

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public Account(int id, String pw, String name, String address, String email, int authority) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.email = email;
		this.authority = authority;
	}

	public Account(String pw2, String name2, String address2, String email2, int i) {
		super();
		this.pw = pw2;
		this.name = name2;
		this.address = address2;
		this.email = email2;
		this.authority = i;
	}

	public Account(int id2,String pw2, String name2, String address2, String email2) {

		super();
		this.pw = pw2;
		this.name = name2;
		this.address = address2;
		this.email = email2;
		this.id = id2;

	}

	public Account(String pw2, String name2, String email2) {

		super();
		this.pw = pw2;
		this.name = name2;
		this.email = email2;

	}







}
