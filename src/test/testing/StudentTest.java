package testing;

import hibernatevalidation.Profession;
import hibernatevalidation.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.Assert.*;

public class StudentTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void printProfession() {
        Profession student = new Student();
        String expected = "This person is a Student.\n";
        String actualResult = "This person is a " + student.getClass().getSimpleName() + ".\n";
        assertEquals(expected, actualResult);
    }

    //region GETTERS & SETTERS

    @Test
    public void getUniversityName() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("universityName");
        field.setAccessible(true);
        field.set(student, "NTUU KPI");
        String actualResult = student.getUniversityName();
        assertEquals("NTUU KPI", actualResult);
    }

    @Test
    public void getScholarship() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("scholarship");
        field.setAccessible(true);
        field.set(student, 200);
        int actualResult = student.getScholarship();
        assertEquals(200, actualResult);
    }

    @Test
    public void getCourseYear() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("courseYear");
        field.setAccessible(true);
        field.set(student, 4);
        int actualResult = student.getCourseYear();
        assertEquals(4, actualResult);
    }

    @Test
    public void getSpecialization() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("specialization");
        field.setAccessible(true);
        field.set(student, "Computer Science");
        String actualResult = student.getSpecialization();
        assertEquals("Computer Science", actualResult);
    }

    @Test
    public void setUniversityName() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("universityName");
        field.setAccessible(true);
        field.set(student, "University of Michigan");
        String actualResult = student.getUniversityName();
        assertEquals("University of Michigan", actualResult);
    }

    @Test
    public void setScholarship() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("scholarship");
        field.setAccessible(true);
        field.set(student, 1200);
        int actualResult = student.getScholarship();
        assertEquals(1200, actualResult);
    }

    @Test
    public void setCourseYear() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("courseYear");
        field.setAccessible(true);
        field.set(student, 1);
        int actualResult = student.getCourseYear();
        assertEquals(1, actualResult);
    }

    @Test
    public void setSpecialization() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field field =  student.getClass().getDeclaredField("specialization");
        field.setAccessible(true);
        field.set(student, "Human Services Management");
        String actualResult = student.getSpecialization();
        assertEquals("Human Services Management", actualResult);
    }

    //endregion

    //region CONSTRAINTS

    @Test
    public void universityIsNull() {
        Student student = new Student(null, 2000, 3, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void scholarshipIsNegative() {
        Student student = new Student("uni", -20, 3, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void scholarshipOversize() {
        Student student = new Student("uni", 20000, 3, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void scholarshipIsZero() {
        Student student = new Student("uni", 0, 3, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void courseYearIsNegative() {
        Student student = new Student("uni", 200, -1, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void courseYearOversize() {
        Student student = new Student("uni", 200, 7, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void courseYearIsZero() {
        Student student = new Student("uni", 200, 0, "spec");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void specializationIsNull() {
        Student student = new Student("uni", 2000, 3, null);
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertEquals(1, constraintViolations.size());
    }

    //endregion
}