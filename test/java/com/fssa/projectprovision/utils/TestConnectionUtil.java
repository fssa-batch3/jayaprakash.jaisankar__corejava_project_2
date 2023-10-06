package com.fssa.projectprovision.utils;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestConnectionUtil {

    private String originalDbUrl;
    private String originalDbUser;
    private String originalDbPassword;

    @Before 
    public void setUp() throws Exception {
        originalDbUrl = System.getenv("DB_URL");
        originalDbUser = System.getenv("DB_USER");
        originalDbPassword = System.getenv("DB_PASSWORD");

        setEnv("DB_URL", "jdbc:mysql://localhost:3306/test_db");
        setEnv("DB_USER", "test_user");
        setEnv("DB_PASSWORD", "test_password");
    }
 
    @After
    public void tearDown() throws Exception {
        setEnv("DB_URL", originalDbUrl);
        setEnv("DB_USER", originalDbUser);
        setEnv("DB_PASSWORD", originalDbPassword);
    }

    @Test
    public void testGetConnection() {
        assertNotNull(System.getenv("DB_URL"));
        assertNotNull(System.getenv("DB_USER"));
        assertNotNull(System.getenv("DB_PASSWORD"));

        Connection connection = ConnectionUtil.getConnection();

        assertNotNull(connection);
        assertTrue(connection instanceof Connection);
        try {
            connection.close();
        } catch (SQLException e) {
           System.out.println(e);
        }
    } 

    private static void setEnv(String key, String value) throws Exception {
        Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
        Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
        theCaseInsensitiveEnvironmentField.setAccessible(true);

        @SuppressWarnings("unchecked")
        Object env = theCaseInsensitiveEnvironmentField.get(null);

        Field field = env.getClass().getDeclaredField("m");
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        java.util.Map<String, String> map = (java.util.Map<String, String>) field.get(env);
        map.put(key, value);
    }
}
