package jayaprakash.jaisankar_backend;

public class User {
    private String email;
    private String username;
    private String password;
    private String dob;
    private String phone;
    private String firstname;
    private String lastname;

    // Constructor
    public User(String email, String username, String password, String dob, String phone, String firstname, String lastname) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8) {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getemail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getdob() {
        return dob;
    }

    public String getphone() {
        return phone;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "User [email=" + email + ", username=" + username + ", password=" + password + ", dob=" + dob
                + ", phone=" + phone + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }

	public void setphone(String string) {
		// TODO Auto-generated method stub
		
	}
}
