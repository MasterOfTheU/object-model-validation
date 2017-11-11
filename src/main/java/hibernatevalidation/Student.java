package hibernatevalidation;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Profession {

    @NotNull private String universityName;
    @NotNull @Positive @Max(2000) private int scholarship;
    @NotNull @Positive @Max(6) private int courseYear;
    @NotNull private String specialization;


    @Override
    public void printProfession() {
        System.out.printf("This person is a %s.\n", getClass().getSimpleName());
    }

}
