package com.fssa.projectprovision.validation;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.PersonalTask;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPersonalTaskValidator {

    @Test
    void testValidateTaskName() {
    
        PersonalTask task1 = new PersonalTask();
        task1.setTaskName("Valid Task Name");

        PersonalTask task2 = new PersonalTask();
        task2.setTaskName("");

        assertThrows(ValidationException.class, () -> PersonalTaskValidator.validatePersonalTask(task1));
        assertThrows(ValidationException.class, () -> PersonalTaskValidator.validatePersonalTask(task2));
    }

    @Test
    void testValidateRemainder() {
        
        PersonalTask task1 = new PersonalTask();
        task1.setRemainder(true);

        PersonalTask task2 = new PersonalTask();
        task2.setRemainder(false);

        assertThrows(ValidationException.class, () -> PersonalTaskValidator.validatePersonalTask(task2));
    }

    @Test
    void testValidateTaskDate() {
        PersonalTask task1 = new PersonalTask();
        task1.setTaskDate(LocalDate.now().plusDays(1));

        PersonalTask task2 = new PersonalTask();
        task2.setTaskDate(LocalDate.now().minusDays(1));

        assertThrows(ValidationException.class, () -> PersonalTaskValidator.validatePersonalTask(task2));
    }

    @Test
    void testValidateTaskTime() {
        PersonalTask task1 = new PersonalTask();
        task1.setTaskTime(LocalTime.of(12, 0));

        PersonalTask task2 = new PersonalTask();
        task2.setTaskTime(null);

        assertThrows(ValidationException.class, () -> PersonalTaskValidator.validatePersonalTask(task2));
    }
}
