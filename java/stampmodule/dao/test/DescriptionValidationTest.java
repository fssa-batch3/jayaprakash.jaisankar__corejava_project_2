package stampmodule.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stampmodule.model.Stamp;
import stampmodule.validation.StampValidator;

public class DescriptionValidationTest {

//    @Test
//    public void testValidDescription() {
//        Stamp stamp = new Stamp();
//        stamp.setDescription("Valid description");
//
//        assertTrue(StampValidator.validateStamp(stamp));
//    }

    @Test
    public void testEmptyDescription() {
        Stamp stamp = new Stamp();
        stamp.setDescription("");

        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testNullDescription() {
        Stamp stamp = new Stamp();
        stamp.setDescription(null);

        assertTrue(StampValidator.validateStamp(stamp));
    }
}
