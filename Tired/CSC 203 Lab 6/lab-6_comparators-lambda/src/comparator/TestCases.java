package comparator;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   private static final Applicant[] applicants = new Applicant[] {
           new Applicant("Aakash", Arrays.asList(
                   new CourseGrade("Intro to CS", 89),
                   new CourseGrade("Data Structures", 86),
                   new CourseGrade("Operating Systems", 89),
                   new CourseGrade("Non-CS", 92)
           ), 5),
           new Applicant("Sarah", Arrays.asList(
                   new CourseGrade("Intro to CS", 96),
                   new CourseGrade("Data Structures", 94),
                   new CourseGrade("Operating Systems", 86),
                   new CourseGrade("Non-CS", 90)
           ), 5),
           new Applicant("Moe", Arrays.asList(
                   new CourseGrade("Intro to CS", 86),
                   new CourseGrade("Data Structures", 92),
                   new CourseGrade("Operating Systems", 93),
                   new CourseGrade("Non-CS", 89)
           ), 10),
           new Applicant("Sue", Arrays.asList(
                   new CourseGrade("Intro to CS", 82),
                   new CourseGrade("Data Structures", 97),
                   new CourseGrade("Operating Systems", 83),
                   new CourseGrade("Non-CS", 89)
           ), 6),
           new Applicant("Moe", Arrays.asList(
                   new CourseGrade("Intro to CS", 94),
                   new CourseGrade("Data Structures", 87),
                   new CourseGrade("Operating Systems", 73),
                   new CourseGrade("Non-CS", 84)
           ), 5)
   };

    Comparator<Applicant> averageGradeCmp = (Applicant app1, Applicant app2) -> {
        if (app1.getAverageGrade() > app2.getAverageGrade()) {
            return 1;
        } else if (app1.getAverageGrade() < app2.getAverageGrade()) {
            return -1;
        } else {
            return 0;
        }
    };

   @Test
   public void testNameComparator() {
       Comparator<Applicant> NameCmp = new NameComparator();
       int result1 = NameCmp.compare(applicants[0], applicants[1]);
       int result2 = NameCmp.compare(applicants[2], applicants[2]);
       int result3 = NameCmp.compare(applicants[3], applicants[2]);

       assertTrue(result1 < 0);
       assertEquals(0, result2);
       assertTrue(result3 >= 1);
   }

   @org.junit.Test
   @Test
   public void testLambdaAverageComparator()
   {
       int result1 = averageGradeCmp.compare(applicants[4], applicants[2]);
       int result2 = averageGradeCmp.compare(applicants[0], applicants[3]);

       assertTrue(result1 < 0);
       assertTrue(result2 > 0);
   }

   @Test
   public void testYearsOfExperienceExtractorComparator()
   {
       Comparator<Applicant> YOE_Cmp = Comparator.comparing(Applicant::getYearsOfExperience).reversed();

       int result1 = YOE_Cmp.compare(applicants[2], applicants[4]);
       int result2 = YOE_Cmp.compare(applicants[0], applicants[3]);

       assertTrue(result1 < 0);
       assertTrue(result2 > 0);
   }

   @Test
   public void testComposedComparator()
   {
       ComposedComparator composedCmp = new ComposedComparator(Comparator.comparing(Applicant::getYearsOfExperience).reversed(), averageGradeCmp);
       int result1 = composedCmp.compare(applicants[0], applicants[1]);
       int result2 = composedCmp.compare(applicants[1], applicants[4]);

       assertTrue(result1 < 0);
       assertTrue(result2 > 0);
   }

   @Test
   public void testThenComparing()
   {
       Comparator<Applicant> thenComparing = Comparator.comparing(Applicant::getYearsOfExperience).thenComparing(Applicant::getAverageGrade);
//       Comparator<Applicant> thenComparing = (Applicant a1, Applicant a2) -> {
//           int result = a1.getYearsOfExperience() - a2.getYearsOfExperience();
//           if (result == 0){
//               result = a1.getAverageGrade() - a2.getAverageGrade();
//           }
//           return result;
//       };

       int result1 = thenComparing.compare(applicants[0], applicants[1]);
       int result2 = thenComparing.compare(applicants[1], applicants[4]);

       assertTrue(result1 < 0);
       assertTrue(result2 > 0);
   }

   @Test
   public void runSort()
   {
      List<Applicant> applicantList = new ArrayList<>(Arrays.asList(applicants));
      List<Applicant> expectedList = Arrays.asList(
              new Applicant("Aakash", Arrays.asList(
                      new CourseGrade("Intro to CS", 89),
                      new CourseGrade("Data Structures", 86),
                      new CourseGrade("Operating Systems", 89),
                      new CourseGrade("Non-CS", 92)
              ), 5),
              new Applicant("Moe", Arrays.asList(
                      new CourseGrade("Intro to CS", 94),
                      new CourseGrade("Data Structures", 87),
                      new CourseGrade("Operating Systems", 73),
                      new CourseGrade("Non-CS", 84)
              ), 5),
              new Applicant("Moe", Arrays.asList(
                      new CourseGrade("Intro to CS", 86),
                      new CourseGrade("Data Structures", 92),
                      new CourseGrade("Operating Systems", 93),
                      new CourseGrade("Non-CS", 89)
              ), 10),
              new Applicant("Sarah", Arrays.asList(
                      new CourseGrade("Intro to CS", 96),
                      new CourseGrade("Data Structures", 94),
                      new CourseGrade("Operating Systems", 86),
                      new CourseGrade("Non-CS", 90)
              ), 5),
              new Applicant("Sue", Arrays.asList(
                      new CourseGrade("Intro to CS", 82),
                      new CourseGrade("Data Structures", 97),
                      new CourseGrade("Operating Systems", 83),
                      new CourseGrade("Non-CS", 89)
              ), 6)
      );

      applicantList.sort(
              Comparator.comparing(Applicant::getName).thenComparing(Applicant::getYearsOfExperience).thenComparing(Applicant::getAverageGrade)
      );

      assertEquals(expectedList, applicantList);
   }
}
