package registration.model;

public class User {

	
	private String name;
	
	private String middlename;
	private String lastname;
	private String phone;
	private int age;
	public String email;
	private String role;
	public String password;
	public int id;
	
	
	
	
	public User(String name, String middlename , String lastname , String phone,int age, String email,String role, String password,int id) {
		super();
		
		this.name = name;
		this.middlename = middlename;
		this.lastname = lastname;
		this.phone = phone;
		this.age = age;
		this.email = email;
		this.role = role;
		this.password = password;
		this.id = id;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return "name: " + name + "middlename: " + middlename + "lastname: " + lastname + "phone: " + phone + "age: " + age + "Email: " + email +"role:"+role+ " Password: " + password+"id:"+id;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getmiddlename() {
		return middlename;
	}

	public void setmiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getphone() {
		return phone;
	}

	public void setphone( String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void setid(int id) {
		this.id = id;
	}

	public int getid() {
	return id;
		}
}