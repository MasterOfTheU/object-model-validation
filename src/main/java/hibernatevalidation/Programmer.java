package hibernatevalidation;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;*/

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class Programmer implements Profession {

    @NotNull @Positive @Max(100000000) private int salary;
    @NotNull @Positive @Max(50) private int yearsOfExperience;
    @NotNull private String specialization;
    @NotNull private String mainProgrammingLanguage;

    public Programmer() {
    }

    public Programmer(int salary, int yearsOfExperience, String specialization, String mainProgrammingLanguage) {
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.mainProgrammingLanguage = mainProgrammingLanguage;
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

    public String getSpecialization() {
        return this.specialization;
    }

    public String getMainProgrammingLanguage() {
        return this.mainProgrammingLanguage;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setMainProgrammingLanguage(String mainProgrammingLanguage) {
        this.mainProgrammingLanguage = mainProgrammingLanguage;
    }
}
