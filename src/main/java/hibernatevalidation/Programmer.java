package hibernatevalidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programmer implements Profession {

    @NotNull @Positive @Max(100000000) private int salary;
    @NotNull @Positive @Max(50) private int yearsOfExperience;
    @NotNull private String specialization;
    @NotNull private String mainProgrammingLanguage;

    @Override
    public void printProfession() {
        System.out.printf("This person works as %s.\n", getClass().getSimpleName());
    }

}
