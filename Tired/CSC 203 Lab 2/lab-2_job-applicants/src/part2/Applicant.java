package part2;

// Name: Omar Mohamed, Teammate: Alejandro Corona Garibay

import part1.CourseGrade;
import java.util.List;
import java.util.Arrays;

public class Applicant {
    private String name;
    private List<CourseGrade> grades;
    private int experienceLevel;
    private String[] softSkills;

    public Applicant(String name, List<CourseGrade> grades){
        this.name = name;
        this.grades = grades;
        this.experienceLevel = 0;
        this.softSkills = new String[0];
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public void setSoftSkills(String[] softSkills) {
        this.softSkills = softSkills;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public String[] getSoftSkills() {
        return softSkills;
    }

    public String getName() {
        return name;
    }
    public List<CourseGrade> getGrades() {
        return grades;
    }

    public CourseGrade getGradeFor(String course){
        for(CourseGrade grade : grades){
            if(grade.getCourseName() == course){
                return grade;
            }
        }
        CourseGrade failResult = new CourseGrade("failed", 0);
        return failResult;
    }
}
