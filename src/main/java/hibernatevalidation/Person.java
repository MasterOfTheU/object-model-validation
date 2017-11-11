package hibernatevalidation;

import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Person {

    @NotNull private String fullName;
    @Positive @Max(122) private int age;
    //Shortest phone number consists of 4 digits & space symbol & '+' symbol & country code (2-3 symbols)
    @NotNull @Size(min = 8, max = 17) private String phone;
    @NotNull private String email;
    @NotNull private String favouriteMovie;
    @NotNull private String cityName;
    @NotNull private String streetName;
    @Valid private Profession profession;
    @NotEmpty private HashMap<String, Double> weightTable = new HashMap<>();
    @NotEmpty private ArrayList<String> hobbies = new ArrayList<>();

    public Person() {
    }

    public Person(String fullName, int age, String phone, String email, String favouriteMovie, String cityName, String streetName, Profession profession, HashMap<String, Double> weightTable, ArrayList<String> hobbies) {
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.favouriteMovie = favouriteMovie;
        this.cityName = cityName;
        this.streetName = streetName;
        this.profession = profession;
        this.weightTable = weightTable;
        this.hobbies = hobbies;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName().toUpperCase() + " OBJECT INFO\n "
                + "fullName: " + getFullName()
                + " age: " + getAge()
                + " phone: " + getPhone()
                + " email: : " + getEmail()
                + " favouriteMovie: " + getFavouriteMovie()
                + " cityName: " + getCityName()
                + " streetName: " + getStreetName()
                + " profession: " + getProfession()
                + " weightTable: " + getWeightTable()
                + " hobbies: " + getHobbies();
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFavouriteMovie() {
        return this.favouriteMovie;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public Profession getProfession() {
        return this.profession;
    }

    public HashMap<String, Double> getWeightTable() {
        return this.weightTable;
    }

    public ArrayList<String> getHobbies() {
        return this.hobbies;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavouriteMovie(String favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public void setWeightTable(HashMap<String, Double> weightTable) {
        this.weightTable = weightTable;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

}
