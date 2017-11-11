package hibernatevalidation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

import static hibernatevalidation.Metrics.*;
import static java.util.Collections.*;

public class PersonCreator {

    /**
     * Creates an object with given values.
     * @param weightTable HashMap is filled dynamically with help of anonymous class.
     * @param hobbies ArrayList is filled dynamically with values from string array.
     * @return Returns initialized Person object.
     * @see PersonCreator#createWeightTable(ArrayList, double[])
     * @see PersonCreator#createPersonHobbies(String[])
     */
    public Person createPerson(String fullName, int age, String phone, String email, String favMovie, String city, String street, Profession profession, HashMap<String, Double> weightTable, ArrayList<String> hobbies) {
        startMetrics();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Person p = new Person(fullName,age,phone,email,favMovie,city,street,profession,weightTable,hobbies);

        printMethodName(methodName);
        stopMetrics();
        gatherPerformance(methodName);
        return p;
    }

    /**
     * @param dates Array of weighing dates.
     * @param values Values of person's weight.
     * @return Returns table of weight values.
     */
    public static HashMap<String, Double> createWeightTable(ArrayList<String> dates, double[] values) {
        startMetrics();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        HashMap<String, Double> weightTable = new HashMap<>();
        if (dates.size() == values.length) {
            for (int i = 0; i < dates.size(); i++) {
                weightTable.put(dates.get(i), values[i]);
            }
        }
        else System.out.printf("Could not create map due to inequality of arrays.\n");

        printMethodName(methodName);
        stopMetrics();
        gatherPerformance(methodName);
        return weightTable;
    }

    /**
     * @param hobbiesArray Gets an array of strings and forms ArrayList of hobbies for object initialization.
     * @return List of person's hobbies.
     */
    public static ArrayList<String> createPersonHobbies(String[] hobbiesArray) {
        ArrayList<String> hobbies = new ArrayList<>();

        if (hobbiesArray.length != 0) {
            addAll(hobbies, hobbiesArray);
        } else {
            System.out.printf("Could not create list due to empty array.\n");
        }
        return hobbies;
    }


    /**
     * @param person Person object that will be converted to JSON format.
     * @return Returns JSON string.
     */
    public static String convertObjectToJSON(Person person) {
        startMetrics();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);

        printMethodName(methodName);
        stopMetrics();
        gatherPerformance(methodName);
        return jsonString;
    }
}
