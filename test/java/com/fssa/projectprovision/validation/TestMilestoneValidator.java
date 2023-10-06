package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;

import com.fssa.projectprovision.model.Milestone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestMilestoneValidator {

    private MilestoneValidator milestoneValidator;
    private Milestone milestone;

    @BeforeEach
    void setUp() {
        milestone = new Milestone();
        milestoneValidator = new MilestoneValidator(milestone);
    }

    @Test
    void testValidTaskDate() {
        LocalDate validTaskDate = LocalDate.now();
        boolean result = false;
        try {
            result = milestoneValidator.validateTaskDate(validTaskDate);
        } catch (ValidationException e) {
            e.printStackTrace();
            fail();
        }
        assertTrue(result);
    }

    @Test
    void testInvalidTaskDate() {
        ValidationException result = assertThrows(ValidationException.class,
                () -> milestoneValidator.validateTaskDate(null));
        assertEquals("Task date cannot be empty", result.getMessage());
    }

    @Test
    void testValidTaskTime() {
        LocalTime validTaskTime = LocalTime.of(10, 30);
        boolean result = false;
        try {
            result = milestoneValidator.validateTaskTime(validTaskTime);
        } catch (ValidationException e) {
            e.printStackTrace();
            fail();
        }
        assertTrue(result);
    }
 
    @Test
    void testInvalidTaskTime() {
        ValidationException result = assertThrows(ValidationException.class,
                () -> milestoneValidator.validateTaskTime(null));
        assertEquals("Task time cannot be empty", result.getMessage());
    }

    @Test
    void testValidTaskText() {
        String validTaskText = "Sample Task";
        boolean result = false;
        try {
            result = milestoneValidator.validateTaskText(validTaskText);
        } catch (ValidationException e) {
            e.printStackTrace();
            fail();
        }
        assertTrue(result);
    }

    @Test
    void testInvalidTaskText() {
        ValidationException result = assertThrows(ValidationException.class,
                () -> milestoneValidator.validateTaskText(null));
        assertEquals("Task text cannot be empty", result.getMessage());
    }
    



}
