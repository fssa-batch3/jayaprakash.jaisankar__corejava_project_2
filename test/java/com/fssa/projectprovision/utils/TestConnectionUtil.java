package com.fssa.projectprovision.utils;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException; 

import static org.junit.jupiter.api.Assertions.*;

public class TestConnectionUtil {

    private String originalDbUrl;
    private String originalDbUser;
    private String originalDbPassword;

    @BeforeAll
    public static void setupEnv() {
        setEnv("DB_URL", "jdbc:mysql://localhost:3306/test_db");
        setEnv("DB_USER", "test_user");
        setEnv("DB_PASSWORD", "test_password");
    }

    @AfterAll
    public static void restoreEnv() {
        setEnv("DB_URL", null);
        setEnv("DB_USER", null);
        setEnv("DB_PASSWORD", null);
    }

    @BeforeEach
    public void setUp() {
        originalDbUrl = System.getenv("DB_URL");
        originalDbUser = System.getenv("DB_USER");
        originalDbPassword = System.getenv("DB_PASSWORD");
    }

    @AfterEach
    public void tearDown() {
        setEnv("DB_URL", originalDbUrl);
        setEnv("DB_USER", originalDbUser);
        setEnv("DB_PASSWORD", originalDbPassword);
    }

    @Test
    public void testGetConnection() {
        assertNotNull(System.getenv("DB_URL"));
        assertNotNull(System.getenv("DB_USER"));
        assertNotNull(System.getenv("DB_PASSWORD"));

        assertDoesNotThrow(() -> {
            try (Connection connection = ConnectionUtil.getConnection()) {
                assertNotNull(connection);
                assertTrue(connection instanceof Connection);
            }
        });
    }

    @Test
    public void testGetConnectionSuccess() {
        assertDoesNotThrow(() -> {
            try (Connection connection = ConnectionUtil.getConnection()) {
                assertNotNull(connection);
            }
        });
    }

    @Test
    public void testGetConnectionWithClassNotFoundException() {
        System.setProperty("jdbc:mysql://localhost:3306/jayaprakash_jaisankar_corejava_project", "com.fssa.projectprovision");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ConnectionUtil.getConnection());
        assertTrue(exception.getCause() instanceof ClassNotFoundException);
    }

    @Test
    public void testGetConnectionWithSQLException() {
        DriverManager.setLogWriter(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ConnectionUtil.getConnection());
        assertTrue(exception.getCause() instanceof SQLException);
    }


    private static void setEnv(String key, String value) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
