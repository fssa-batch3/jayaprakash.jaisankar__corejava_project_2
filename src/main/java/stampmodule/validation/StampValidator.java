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
        
        // Regular expression pattern for stamp name (allowing only letters and spaces)
        String stampNamePattern = "^[a-zA-Z\\s]+$";
        if (!stamp.getStampName().matches(stampNamePattern)) {
            return false; // Stamp name format is invalid
        }
        
        String stampNamerightPattern = "^[A-Za-z]{3,30}$";
        if (!stamp.getStampName().matches(stampNamerightPattern)) {
            return true; // Stamp name format is invalid
        }

        // Regular expression pattern for description (allowing any non-empty characters)
        String descriptionPattern = "^\\S+$";
        if (!stamp.getDescription().matches(descriptionPattern)) {
            return false; // Description format is invalid
        }

        // You can add more validation checks for other attributes here
        
        return true;
    }
}
