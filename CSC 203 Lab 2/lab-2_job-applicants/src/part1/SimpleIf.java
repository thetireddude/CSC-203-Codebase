package part1;

// Name: Omar Mohamed, Teammate: Alejandro Corona Garibay

import part2.Applicant;

public class SimpleIf {

  // I am making some changes in class.

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    if(avg >= threshold)
    {
      return true;
    }
    return false; // A bit pessimistic!
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
    if(avg1 > avg2)
    {
      return avg1;
    }
    else if(avg2 > avg1)
    {
      return avg2;
    }

    return 0; // Clearly not correct, but testable.
  }

  /**
   * Takes in an applicant object and calculates a value based on the applicant's experience level
   * and on the number of their soft skills
   * it then checks if this value is higher than 20
   *
   * @param applicant The Applicant object
   * @return true if the resulting value is greater than 20, and false otherwise
   */

  public static boolean analyzeApplicant2(Applicant applicant)
  {
      if(((applicant.getExperienceLevel() * 10 + applicant.getSoftSkills().length * 5) > 20)){
        return true;
      }
      return false;
  }

}
