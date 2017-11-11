package hibernatevalidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Writer implements Profession {

    @NotNull @Positive @Max(100000000) private int salary;
    @NotNull @Positive @Max(50) private int yearsOfExperience;
    @NotNull private String genre;
    @NotNull private String inspiredBy;

    public Writer() {
    }

    public Writer(int salary, int yearsOfExperience, String genre, String inspiredBy) {
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.genre = genre;
        this.inspiredBy = inspiredBy;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName().toUpperCase() + " OBJECT INFO\n "
                + "salary: " + getSalary()
                + " yearsOfExperience: " + getYearsOfExperience()
                + " genre: " + getGenre()
                + " inspiredBy: : " + getInspiredBy();
    }

    @Override
    public void printProfession() {
        System.out.printf("This person works as %s.\n", getClass().getSimpleName());
    }

    public int getSalary() {
        return this.salary;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getInspiredBy() {
        return this.inspiredBy;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setInspiredBy(String inspiredBy) {
        this.inspiredBy = inspiredBy;
    }

}
