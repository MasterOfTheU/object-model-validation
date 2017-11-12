package testing;

import hibernatevalidation.Profession;
import hibernatevalidation.Programmer;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Set;


import static org.junit.Assert.*;

/**
 * This class provides test for hibernate constraints and class getters and setters.
 */
public class ProgrammerTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void printProfession() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Profession programmer = new Programmer();
        programmer.printProfession();
        String expected = "This person works as Programmer.\n";
        String actualResult = outContent.toString();
        assertEquals(expected, actualResult);
    }

    //region GETTERS & SETTERS

    @Test
    public void getSalary() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        Field field =  programmer.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        field.set(programmer, 1200);
        int actualResult = programmer.getSalary();
        assertEquals(1200, actualResult);
    }

    @Test
    public void getYearsOfExperience() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        Field field =  programmer.getClass().getDeclaredField("yearsOfExperience");
        field.setAccessible(true);
        field.set(programmer, 10);
        int actualResult = programmer.getYearsOfExperience();
        assertEquals(10, actualResult);
    }

    @Test
    public void getSpecialization() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        Field field =  programmer.getClass().getDeclaredField("specialization");
        field.setAccessible(true);
        field.set(programmer, "Java dev");
        String actualResult = programmer.getSpecialization();
        assertEquals("Java dev", actualResult);
    }

    @Test
    public void getMainProgrammingLanguage() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        Field field =  programmer.getClass().getDeclaredField("mainProgrammingLanguage");
        field.setAccessible(true);
        field.set(programmer, "Java");
        String actualResult = programmer.getMainProgrammingLanguage();
        assertEquals("Java", actualResult);
    }

    @Test
    public void setSalary() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        programmer.setSalary(1000);
        Field field =  programmer.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        assertEquals(1000, field.get(programmer));
    }

    @Test
    public void setYearsOfExperience() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        programmer.setYearsOfExperience(5);
        Field field =  programmer.getClass().getDeclaredField("yearsOfExperience");
        field.setAccessible(true);
        assertEquals(5, field.get(programmer));
    }

    @Test
    public void setSpecialization() throws NoSuchFieldException, IllegalAccessException {
        Programmer programmer = new Programmer();
        programmer.setSpecialization("JS senior dev");
        Field field =  programmer.getClass().getDeclaredField("specialization");
        field.setAccessible(true);
        assertEquals("JS senior dev", field.get(programmer));
    }

    @Test
    public void setMainProgrammingLanguage() throws NoSuchFieldException, IllegalAccessException{
        Programmer programmer = new Programmer();
        programmer.setMainProgrammingLanguage("JavaScript");
        Field field =  programmer.getClass().getDeclaredField("mainProgrammingLanguage");
        field.setAccessible(true);
        assertEquals("JavaScript", field.get(programmer));
    }

    //endregion

    //region CONSTRAINTS

    @Test
    public void salaryIsNegative() {
        Programmer programmer = new Programmer(-3333, 2, "testSpec", "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void salaryOversize() {
        Programmer programmer = new Programmer(2000000000, 2, "testSpec", "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void salaryIsZero() {
        Programmer programmer = new Programmer(0, 2, "testSpec", "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void experienceIsNegative() {
        Programmer programmer = new Programmer(20000, -50, "testSpec", "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void experienceOversize() {
        Programmer programmer = new Programmer(20000, 51, "testSpec", "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void specializationIsNull() {
        Programmer programmer = new Programmer(20000, 2, null, "testLang");
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void languageIsNull() {
        Programmer programmer = new Programmer(20000, 2, "testSpec", null);
        Set<ConstraintViolation<Programmer>> constraintViolations = validator.validate(programmer);
        assertEquals(1, constraintViolations.size());
    }

    //endregion
}