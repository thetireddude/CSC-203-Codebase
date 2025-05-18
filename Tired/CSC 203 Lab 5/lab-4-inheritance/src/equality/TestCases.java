package equality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

public class TestCases {

   // Test Cases for the CourseSection class

   @Test
   public void testExercise1() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertTrue(one.equals(two));
      assertTrue(two.equals(one));
   }

   @Test
   public void testExercise2() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
              LocalTime.of(1, 10), LocalTime.of(2, 0));

      assertFalse(one.equals(two));
      assertFalse(two.equals(one));
   }

   @Test
   public void testExercise3() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertEquals(one.hashCode(), two.hashCode());
   }

   @Test
   public void testExercise4() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
              LocalTime.of(9, 10), LocalTime.of(10, 0));

      assertNotEquals(one.hashCode(), two.hashCode());
   }

   // TODO: Write test cases for equals and hashCode in Student.
   //    What would convince you that those methods are working as expected?

   // test cases for the Student class

   @Test
   public void testStudentEquals1() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CPE", "225", 23,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      List<CourseSection> courses = List.of(one, two);

      final Student student1 = new Student("John", 23, courses);
      final Student student2 = new Student("John", 23, courses);


      assertTrue(Student.equals(student1, student2));
   }

   @Test
   public void testStudentEquals2() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CPE", "225", 23,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      List<CourseSection> courses = List.of(one, two);

      final Student student1 = new Student("John", 23, courses);
      final Student student2 = new Student("Blyke", 23, courses);


      assertFalse(Student.equals(student1, student2));
   }

   @Test
   public void testStudentHash1() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CPE", "225", 23,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      List<CourseSection> courses = List.of(one, two);

      final Student student1 = new Student("John", 24, courses);
      final Student student2 = new Student("John", 23, courses);


      assertNotEquals(Student.hashCode(student1), Student.hashCode(student2));
   }

   @Test
   public void testStudentHash2() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CPE", "225", 23,
              LocalTime.of(9, 40), LocalTime.of(11, 0));

      List<CourseSection> courses = List.of(one, two);

      final Student student1 = new Student("John", 24, courses);
      final Student student2 = new Student("John", 24, courses);


      assertEquals(Student.hashCode(student1), Student.hashCode(student2));
   }
}
