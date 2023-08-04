package stampmodule.validation;


import stampmodule.model.Stamp;

public class StampValidator {
    public static boolean validateStamp(Stamp stamp) {
        if (stamp == null) {
            return false; // Stamp object is null
        }
        
        if (stamp.getStampName() == null || stamp.getStampName().isEmpty()) {
            return false; // Stamp name cannot be empty
        }

        if (stamp.getRupees() <= 0) {
            return false; // Rupees must be a positive value
        }

        if (stamp.getDescription() == null || stamp.getDescription().isEmpty()) {
            return false; // Description cannot be empty
        }

        // You can add more validation checks for other attributes here
        
        return true;
    }
}
