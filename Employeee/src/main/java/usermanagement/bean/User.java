package usermanagement.bean;

public class User {
	// Creating Beans
	private int id;
	private String name;
	private String password;
	private String email;
	private String country;
	private String confirmPass;

	public User() {
		super();
	}

	

	public User(String name, String password, String email, String country, String confirmPass) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.confirmPass = confirmPass;
	}



	public User(int id, String name, String password, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getConfirmPass() {
		return confirmPass;
	}



	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
				+ country + ", confirmPass=" + confirmPass + "]";
	}



	

}
