package com.fssa.projectprovision.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordutil {

    @Test
    public void testHashPassword() {
        String plainPassword = "myPassword";
        String hashedPassword = Passwordutil.hashPassword(plainPassword);
        assertNotNull(hashedPassword);
        assertNotEquals(plainPassword, hashedPassword);
    }

    @Test
    public void testCheckPassword() {
        String plainPassword = "myPassword";
        String hashedPassword = Passwordutil.hashPassword(plainPassword);
        assertTrue(Passwordutil.checkPassword(plainPassword, hashedPassword));
        assertFalse(Passwordutil.checkPassword("wrongPassword", hashedPassword));
    }
}
