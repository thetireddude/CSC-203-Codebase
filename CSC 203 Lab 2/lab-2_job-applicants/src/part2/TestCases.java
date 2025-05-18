  // Uncomment this file by selecting all the text (Cmd/Ctrl A) and
  // uncommenting all the selected text (Cmd/Ctrl /).
  package part2;

  import org.junit.jupiter.api.Test;
  import part1.CourseGrade;
  import part1.SimpleIf;

  import java.lang.reflect.Method;
  import java.lang.reflect.Modifier;
  import java.util.stream.Collectors;
  import java.util.Arrays;
  import java.util.List;

  import static org.junit.jupiter.api.Assertions.assertEquals;
  import static org.junit.jupiter.api.Assertions.assertTrue;

  public class TestCases
  {
     /*
      * This test is just to get you started.
      */
     @Test
     public void testGetName()
     {
        // This will not compile until you implement the Applicant class
        List<CourseGrade> grades = Arrays.asList(
           new CourseGrade("Intro to CS", 100),
           new CourseGrade("Data Structures", 95),
           new CourseGrade("Algorithms", 91),
           new CourseGrade("Computer Organization", 91),
           new CourseGrade("Operating Systems", 75),
           new CourseGrade("Non-CS", 83)
        );
        Applicant testApplicant = new Applicant("Aakash", grades);
        assertEquals("Aakash", testApplicant.getName());
     }
      /*
       * This test is to check the getGradeFor() method
       */
      @Test
      public void testGetGradeFor()
      {
          // This will not compile until you implement the Applicant class
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 99),
                  new CourseGrade("Data Structures", 82),
                  new CourseGrade("Algorithms", 91),
                  new CourseGrade("Computer Organization", 87),
                  new CourseGrade("Operating Systems", 75),
                  new CourseGrade("Non-CS", 83)
          );
          Applicant testApplicant = new Applicant("Tim", grades);
          assertEquals(testApplicant.getGrades().get(1), testApplicant.getGradeFor("Data Structures"));
      }
      /*
       * This test is to check if the custom filtering is working using the analyzeApplicant2() method
       */
      @Test
      public void testAnalyzeApplicant2()
      {
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 100),
                  new CourseGrade("Data Structures", 56),
                  new CourseGrade("Algorithms", 91),
                  new CourseGrade("Computer Organization", 89),
                  new CourseGrade("Operating Systems", 94),
                  new CourseGrade("Non-CS", 83)
          );
          Applicant testApplicant = new Applicant("Joyce", grades);

          testApplicant.setExperienceLevel(1);
          String[] testApplicantSoftSkills = {"Communication", "Teamwork", "Problem-Solving"};
          testApplicant.setSoftSkills(testApplicantSoftSkills);

          assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
      }

     /*
      * The tests below here are to verify the basic requirements regarding
      * the "design" of your class.  These are to remain unchanged.
      */
     @Test
     public void testImplSpecifics()
        throws NoSuchMethodException
     {
        final List<String> expectedMethodNames = Arrays.asList(
           "getName",
           "getGrades",
           "getGradeFor"
        );

        final List<Class> expectedMethodReturns = Arrays.asList(
           String.class,
           List.class,
           CourseGrade.class
        );

        final List<Class[]> expectedMethodParameters = Arrays.asList(
           new Class[0],
           new Class[0],
           new Class[] { String.class }
           );

        verifyImplSpecifics(Applicant.class, expectedMethodNames,
           expectedMethodReturns, expectedMethodParameters);
     }

     private static void verifyImplSpecifics(
        final Class<?> clazz,
        final List<String> expectedMethodNames,
        final List<Class> expectedMethodReturns,
        final List<Class[]> expectedMethodParameters)
        throws NoSuchMethodException
     {
        assertEquals(0, Applicant.class.getFields().length,
                "Unexpected number of public fields");

        final List<Method> publicMethods = Arrays.stream(
           clazz.getDeclaredMethods())
              .filter(m -> Modifier.isPublic(m.getModifiers()))
              .collect(Collectors.toList());

        assertTrue(expectedMethodNames.size() <= publicMethods.size(),
                "Unexpected number of public methods");

        assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
                "Invalid test configuration");
        assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
                "Invalid test configuration");

        for (int i = 0; i < expectedMethodNames.size(); i++)
        {
           Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
              expectedMethodParameters.get(i));
           assertEquals(expectedMethodReturns.get(i), method.getReturnType());
        }
     }
  }
