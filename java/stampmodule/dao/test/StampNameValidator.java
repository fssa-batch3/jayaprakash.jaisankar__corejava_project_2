package stampmodule.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stampmodule.model.Stamp;
import stampmodule.validation.StampValidator;

public class StampNameValidator {

	@Test
	public void testValidStampName() {
	    Stamp stamp = new Stamp();
	    stamp.setStampName("StampName"); // Valid stamp name with only letters
	    assertTrue(StampValidator.validateStamp(stamp));
	}


    @Test
    public void testEmptyStampName() {
        Stamp stamp = new Stamp();
        stamp.setStampName("");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testNullStampName() {
        Stamp stamp = new Stamp();
        stamp.setStampName(null);
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testInvalidStampName() {
        Stamp stamp = new Stamp();
        stamp.setStampName("123");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testStampNameWithSpaces() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Stamp Name"); // Contains a space, which should fail the regex pattern
        assertFalse(StampValidator.validateStamp(stamp));
    }


    @Test
    public void testStampNameWithSpecialCharacters() {
        Stamp stamp = new Stamp();
        stamp.setStampName("Stamp@123");
        assertFalse(StampValidator.validateStamp(stamp));
    }
}
