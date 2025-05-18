package equality;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class test {

    public static void main(String[] args){
        final CourseSection one = new CourseSection("CSC", "203", 35,
                LocalTime.of(9, 40), LocalTime.of(11, 0));
        final CourseSection two = new CourseSection("CSC", "203", 35,
                LocalTime.of(9, 40), LocalTime.of(11, 0));

        List<CourseSection> courses = List.of(one, two);

        final Student student1 = new Student("John", 22, courses);
        final Student student2 = new Student("John", 23, courses);

        System.out.println(Student.equals(student1, student2));

    }
}
