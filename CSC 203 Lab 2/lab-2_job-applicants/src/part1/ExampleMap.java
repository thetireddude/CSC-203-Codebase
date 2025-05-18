package part1;

// Name: Omar Mohamed, Teammate: Alejandro Corona Garibay

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> highScoringStudents = new LinkedList<>();

    /*
     * Build a list of the names of applicants who have scores strictly greater than
     * the given threshold.
     */
    for (Map.Entry<String, List<CourseGrade>> current : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = current.getValue();
      boolean value = false;
      for(CourseGrade score : scores) {
        if (score.getScore() <= scoreThreshold) {
          value = false;
          break;
        }
        value = true;
      }
      if(value) {
        highScoringStudents.add(current.getKey());
      }

    }

    return highScoringStudents;
  }
}
