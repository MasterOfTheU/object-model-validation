package testing;

import hibernatevalidation.Writer;
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

public class WriterTest {

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
        Writer writer = new Writer();
        writer.printProfession();
        String expected = "This person works as Writer.\n";
        String actualResult = outContent.toString();
        assertEquals(expected, actualResult);
    }

    //region GETTERS & SETTERS

    @Test
    public void getSalary() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        Field field =  writer.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        field.set(writer, 1200);
        int actualResult = writer.getSalary();
        assertEquals(1200, actualResult);
    }

    @Test
    public void getYearsOfExperience() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        Field field =  writer.getClass().getDeclaredField("yearsOfExperience");
        field.setAccessible(true);
        field.set(writer, 22);
        int actualResult = writer.getYearsOfExperience();
        assertEquals(22, actualResult);

    }

    @Test
    public void getGenre() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        Field field =  writer.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        field.set(writer, "horror");
        String actualResult = writer.getGenre();
        assertEquals("horror", actualResult);
    }

    @Test
    public void getInspiredBy() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        Field field =  writer.getClass().getDeclaredField("inspiredBy");
        field.setAccessible(true);
        field.set(writer, "Tom Macnovel");
        String actualResult = writer.getInspiredBy();
        assertEquals("Tom Macnovel", actualResult);
    }

    @Test
    public void setSalary() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        writer.setSalary(4000);
        Field field =  writer.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        assertEquals(4000, field.get(writer));
    }

    @Test
    public void setYearsOfExperience() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        writer.setYearsOfExperience(25);
        Field field =  writer.getClass().getDeclaredField("yearsOfExperience");
        field.setAccessible(true);
        assertEquals(25, field.get(writer));
    }

    @Test
    public void setGenre() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        writer.setGenre("science fiction");
        Field field =  writer.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        assertEquals("science fiction", field.get(writer));
    }

    @Test
    public void setInspiredBy() throws NoSuchFieldException, IllegalAccessException {
        Writer writer = new Writer();
        writer.setInspiredBy("Isaac Asimov");
        Field field =  writer.getClass().getDeclaredField("inspiredBy");
        field.setAccessible(true);
        assertEquals("Isaac Asimov", field.get(writer));
    }

    //endregion

    //region CONSTRAINTS
    @Test
    public void salaryIsNegative() {
        Writer writer = new Writer(-4000, 2, "testGenre", "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void salaryOversize() {
        Writer writer = new Writer(2000000000, 2, "testGenre", "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void salaryIsZero() {
        Writer writer = new Writer(0, 2, "testGenre", "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void experienceIsNegative() {
        Writer writer = new Writer(15000, -5, "testGenre", "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void experienceOversize() {
        Writer writer = new Writer(15000, 60, "testGenre", "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void genreIsNull() {
        Writer writer = new Writer(15000, 30, null, "testInspBy");
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void fieldInspiredByIsNull() {
        Writer writer = new Writer(15000, 30, "testGenre", null);
        Set<ConstraintViolation<Writer>> constraintViolations = validator.validate(writer);
        assertEquals(1, constraintViolations.size());
    }

    //endregion

}