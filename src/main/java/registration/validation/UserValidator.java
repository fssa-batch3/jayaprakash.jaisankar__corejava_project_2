package registration.validation;

import java.util.regex.Pattern;

import jayaprakash.jaisankar_backend.UserManagementCRUD.InvalidUserException;
import registration.model.User;

public class UserValidator {

	public static boolean validateEmail(String string) {
		// Validate email using a simple regex pattern
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		return Pattern.matches(regex, (CharSequence) string);
	}

	public static boolean validatePassword(String password) {
		// Validate password using regex pattern for a strong password
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		return Pattern.matches(regex, password);
	}

	public static boolean validateUser(User user) throws InvalidUserException {
		// TODO Auto-generated method stub
		if(user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("user details not valid");
		}
	}
	
	  public static boolean validatename(String name) {
	        // Perform name validation logic here
	        
	        return name.matches("[A-Za-z]+");
	    }
	
	  public static boolean validateMiddlename(String middlename) {
	        // Perform middlename validation logic here
	        
	        return middlename.matches("[A-Za-z]+");
	    }

	    public static boolean validateLastname(String lastname) {
	        // Perform lastname validation logic here
	      
	        return lastname.matches("[A-Za-z]+");
	    }

	    public static boolean validatePhone(String phone) {
	        // Perform phone validation logic here
	      
	        return phone.matches("\\d{10}");
	    }

	    public static boolean validateAge(int age) {
	        // Perform age validation logic here
	      
	        return age >= 0 && age <= 120;
	    }

	 
	    public static boolean validateRole(String role) {
	        // Perform role validation logic here
	       
	        return role.equals("admin") || role.equals("user");
	    }

	  

	    public static boolean validateId(String id) {
	        // Perform id validation logic here
	    
	        return id.matches("[0-9]+");
	    }
}
