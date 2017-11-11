package testing;

import hibernatevalidation.Person;
import hibernatevalidation.PersonCreator;
import hibernatevalidation.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static hibernatevalidation.PersonCreator.*;
import static org.junit.Assert.*;

public class PersonCreatorTest {

    private PersonCreator personCreator;
    private Person person;

    @Before
    public void setUp(){
        personCreator = new PersonCreator();
    }

    @Test
    public void testCreatePerson() throws Exception {
        person = personCreator.createPerson("testName", 20, "+333 3333", "email@org", "movie", "city", "street",
                                new Writer(),
                                new HashMap<>(),
                                new ArrayList<>()
        );
        assertNotNull(person);
    }

    @Test
    public void testCreateWeightTable() {
        ArrayList<String> dates = new ArrayList<>();
        dates.add("date 1");
        dates.add("date 2");
        dates.add("date 3");

        double[] values = new double[] {1.00, 2.00, 3.00};
        assertNotNull(createWeightTable(dates, values));
    }

    @Test
    public void testCreatePersonHobbies() {
        String[] hobbiesArray = new String[] {"h1", "h2", "h3"};
        assertNotNull(createPersonHobbies(hobbiesArray));
    }

    @Test
    public void testConvertObjectToJSON() {
        assertNotNull(convertObjectToJSON(person));

    }

}