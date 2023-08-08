package stampmodule.dao.test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stampmodule.model.Stamp;
import stampmodule.validation.*;

public class ImgValidationTest {

    @Test
    public void testValidImg() {
        Stamp stamp = new Stamp();
        stamp.setImg("valid.png");
        assertTrue(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testEmptyImg() {
        Stamp stamp = new Stamp();
        stamp.setImg("");
        assertFalse(StampValidator.validateStamp(stamp));
    }

    @Test
    public void testNullImg() {
        Stamp stamp = new Stamp();
        stamp.setImg(null);
        assertFalse(StampValidator.validateStamp(stamp));
    }

    // Add more tests for img validation if needed
}
