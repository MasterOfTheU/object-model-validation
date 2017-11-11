package hibernatevalidation;

import java.util.ArrayList;

import static hibernatevalidation.PersonCreator.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> personList = createPersonObjects();
        personList.forEach(PersonCreator::convertObjectToJSON);
    }

    public static ArrayList<Person> createPersonObjects() {

        ArrayList<Person> personList = new ArrayList<>();

        PersonCreator personCreator = new PersonCreator();
        Person person = personCreator.createPerson("Tomas Christen", 30, "+232 4444", "tchr@gmail.com","Lost in Translation","New York", "Abbey Road 5a/2", new Writer(10000, 5, "novelist", "John Jackson"),
                createWeightTable(new ArrayList<String>(){
                    {
                        add("2009.02.02");
                        add("2011.11.02");
                        add("2011.11.18");
                    }
                }, new double[]{ 124.33, 114.05, 113.25 }),
                createPersonHobbies(new String[]{"Playing piano", "Cooking", "Drawing"}));

        Person person2 = personCreator.createPerson("Nick Macklow", 20, "+277 4520", "nnnnnn@gmail.com","Titanic","L.A", "West 4f", new Programmer(15000, 3, "Python dev", "Python"),
                createWeightTable(new ArrayList<String>(){
                    {
                        add("2008.02.05");
                        add("2011.11.02");
                        add("2012.12.18");
                    }
                }, new double[]{ 133.33, 104.05, 155.25 }),
                createPersonHobbies(new String[]{"Coding", "Playing with cat", "Bowling"}));
        personList.add(person);
        personList.add(person2);

        return personList;
    }

}
