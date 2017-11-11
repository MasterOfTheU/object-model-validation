package hibernatevalidation;

/*import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;*/

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class Student implements Profession {

    @NotNull private String universityName;
    @NotNull @Positive @Max(2000) private int scholarship;
    @NotNull @Positive @Max(6) private int courseYear;
    @NotNull private String specialization;

    public Student() {
    }

    public Student(String universityName, int scholarship, int courseYear, String specialization) {
        this.universityName = universityName;
        this.scholarship = scholarship;
        this.courseYear = courseYear;
        this.specialization = specialization;
    }

    public String getUniversityName() {
        return this.universityName;
    }

    public int getScholarship() {
        return this.scholarship;
    }

    public int getCourseYear() {
        return this.courseYear;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void printProfession() {
        System.out.printf("This person is a %s.\n", getClass().getSimpleName());
    }
}
