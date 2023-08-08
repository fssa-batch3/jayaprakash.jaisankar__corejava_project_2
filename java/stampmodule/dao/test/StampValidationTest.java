package stampmodule.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stampmodule.model.Stamp;
import stampmodule.validation.StampValidator;

public class StampValidationTest {

    @Test
    public void testValidStamp() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Valid Stamp");
        stamp.setRupees(10.0);
        stamp.setImg("valid.png");
        stamp.setDescription("Valid description");
        assertTrue(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testInvalidStampName() {
        Stamp stamp = new Stamp();
        stamp.setStampName("123"); // Invalid according to stampNamerightPattern
        stamp.setRupees(10.0);
        stamp.setImg("valid.png");
        stamp.setDescription("Valid description");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testInvalidRupees() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Valid Stamp");
        stamp.setRupees(-5.0); // Invalid rupees value
        stamp.setImg("valid.png");
        stamp.setDescription("Valid description");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testEmptyImg() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Valid Stamp");
        stamp.setRupees(10.0);
        stamp.setImg("");
        stamp.setDescription("Valid description");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testEmptyDescription() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Valid Stamp");
        stamp.setRupees(10.0);
        stamp.setImg("valid.png");
        stamp.setDescription("");
        assertFalse(StampValidator.validateStamp(stamp));
    }
}

