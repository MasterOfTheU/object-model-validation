package hibernatevalidation;

import java.util.ArrayList;
import java.util.HashMap;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
