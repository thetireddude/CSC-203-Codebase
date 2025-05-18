package equality;

import java.util.List;
import java.util.Objects;

public class Student
{
   private String name;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String name, final int age,
      final List<CourseSection> currentCourses)
   {
      this.name = name;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   // TODO: equals and hashCode methods for Student
   public static boolean equals(Student student1, Student student2) {
      boolean value = false;
      if (student1 != null && student2 != null) {
         if (student1.getClass() == student2.getClass()) {
            if (student1.name == student2.name && student1.age == student2.age) {
               for (CourseSection section1 : student1.currentCourses) {
                  for (CourseSection section2 : student2.currentCourses) {
                     if (section1.equals(section2)) {
                        value = true;
                        break;
                     }
                  }
                  if (!value) {
                     return false;
                  }
               }
               return true;
            }
         }
      }
      return false;
   }

   public static int hashCode(Student student){
      if (student == null){
         return 0;
      }
      return student.name.hashCode() + student.age * 17;
   }
}
