package hibernatevalidation;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Writer implements Profession {

    @NotNull @Positive @Max(100000000) private int salary;
    @NotNull @Positive @Max(50) private int yearsOfExperience;
    @NotNull private String genre;
    @NotNull private String inspiredBy;

    @Override
    public void printProfession() {
        System.out.printf("This person works as %s.\n", getClass().getSimpleName());
    }

}
