package testing;

import hibernatevalidation.Person;
import org.junit.Test;

import java.util.ArrayList;

import static hibernatevalidation.Main.createPersonObjects;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testCreatePersonObjects() throws Exception {
        ArrayList<Person> personList = createPersonObjects();
        assertNotNull(personList);
    }

}