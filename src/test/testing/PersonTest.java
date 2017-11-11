package testing;

import hibernatevalidation.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static hibernatevalidation.PersonCreator.*;
import static org.junit.Assert.*;

public class PersonTest {

    private static Validator validator;
    private static HashMap<String, Double> weightTable;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        weightTable = new HashMap<>();
        weightTable.put("str1", 1.00);
        weightTable.put("str2", 2.00);
    }

    @Test
    public void nameIsNull() {
        Person person = new Person(null, 2, "testPhone", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }


    @Test
    public void ageOversize() {
        Person person = new Person("testName", 200, "testPhone", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void ageIsNegative() {
        Person person = new Person("testName", -3, "testPhone", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void ageIsZero() {
        Person person = new Person("testName", 0, "testPhone", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void phoneNumberIsShort(){
        Person person = new Person("testName", 2, "+333 24", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void emailIsNull() {
        Person person = new Person("testName", 2, "+333 24333", null, "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void favouriteMovieIsNull() {
        Person person = new Person("testName", 2, "+333 24333", "email", null, "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void cityNameIsNull() {
        Person person = new Person("testName", 2, "+333 24333", "email", "favMovie", null, "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void streetNameIsNull() {
        Person person = new Person("testName", 2, "+333 24333", "email", "favMovie", "testCity", null,
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void professionIsValid() {
        Person person = new Person("testName", 2, "+333 24333", "email", "favMovie", "testCity", "testStreet",
                new Programmer(),
                weightTable, createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(4, constraintViolations.size());
    }

    @Test
    public void weightTableIsEmpty() {
        Person person = new Person("testName", 2, "+333 24333", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                new HashMap<>(), createPersonHobbies(new String[]{"h1", "h2", "h3"}));
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void listOfHobbiesIsEmpty() {
        Person person = new Person("testName", 2, "testPhone", "email", "favMovie", "testCity", "testStreet",
                new Programmer(50000, 20, "testing", "Scala"),
                weightTable, new ArrayList<>());
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
}