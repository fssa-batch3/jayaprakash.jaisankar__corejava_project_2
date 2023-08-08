package stampmodule.dao.test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stampmodule.model.Stamp;
import stampmodule.validation.StampValidator;

public class RupeesValidationTest {

    @Test
    public void testValidRupees() {
        Stamp stamp = new Stamp();
        stamp.setRupees(100);
        assertTrue(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testZeroRupees() {
        Stamp stamp = new Stamp();
        stamp.setRupees(0);
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testNegativeRupees() {
        Stamp stamp = new Stamp();
        stamp.setRupees(-10.0);
        assertFalse(StampValidator.validateStamp(stamp));
    }

    
}