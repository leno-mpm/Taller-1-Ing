import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student and manages their grades.
 */
public class Student {

  private static final double MIN_GRADE = 0.0;
  private static final double MAX_GRADE = 100.0;
  private static final double PASS_GRADE = 60.0;
  private static final double HONOR_GRADE = 90.0;
  private static final double GRADE_B = 80.0;
  private static final double GRADE_C = 70.0;
  private final String id;
  private final String name;
  private final List<Double> grades;

  /**
   * Creates a student with a valid ID and name.
   *
   * @param id   student identifier
   * @param name student name
   */
  public Student(String id, String name) {
    if (id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException("Student ID cannot be empty.");
    }
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Student name cannot be empty.");
    }

    this.id = id.trim();
    this.name = name.trim();
    this.grades = new ArrayList<>();
  }

  /**
   * Adds a numeric grade between 0 and 100.
   *
   * @param grade grade to add
   */
  public void addGrade(Object grade) {
    if (!(grade instanceof Number)) {
      System.out.println("Error: Grade must be numeric.");
      return;
    }

    double value = ((Number) grade).doubleValue();
    if (!Double.isFinite(value) || value < MIN_GRADE || value > MAX_GRADE) {
      System.out.println("Error: Grade must be between 0 and 100.");
      return;
    }
    grades.add(value);
    System.out.println("Grade added: " + value);
  }

  /**
   * Calculates the average of all grades.
   *
   * @return average grade, or zero if there are no grades
   */
  public double average() {
    if (grades.isEmpty()) {
      return 0.0;
    }

    double total = 0.0;
    for (double grade : grades) {
      total += grade;
    }
    return total / grades.size();
  }

  /**
   * Converts the average into a letter grade.
   *
   * @return letter grade from A to F
   */

  public String letterGrade() {
    double result = average();

    if (result >= HONOR_GRADE) {
      return "A";
    }
    if (result >= GRADE_B) {
      return "B";
    }
    if (result >= GRADE_C) {
      return "C";
    }
    if (result >= PASS_GRADE) {
      return "D";
    }
    return "F";
  }

  /**
   * Determines whether the student has passed.
   *
   * @return Passed or Failed
   */
  public String passStatus() {
    return average() >= PASS_GRADE ? "Passed" : "Failed";
  }

  /**
   * Checks whether the student qualifies for the honor roll.
   *
   * @return true if the average is at least 90
   */
  public boolean checkHonorStatus() {
    return !grades.isEmpty() && average() >= HONOR_GRADE;
  }

  /**
   * Removes a grade by its index.
   *
   * @param index zero-based index of the grade
   */

  public void removeGradeByIndex(int index) {
    if (index < 0 || index >= grades.size()) {
      System.out.println("Error: Grade index is out of bounds.");
      return;
    }

    double removed = grades.remove(index);
    System.out.println("Grade removed: " + removed);
  }

  /**
   * Removes the first occurrence of a grade by value.
   *
   * @param value grade value to remove
   */
  public void removeGradeByValue(double value) {
    if (!grades.remove(Double.valueOf(value))) {
      System.out.println("Error: Grade value not found.");
      return;
    }

    System.out.println("Grade removed: " + value);
  }

  /**
  * Prints a formatted student summary.
  */
  public void reportCard() {
    System.out.println("------------------------------");
    System.out.println("STUDENT REPORT");
    System.out.println("------------------------------");
    System.out.println("Student ID: " + id);
    System.out.println("Student Name: " + name);
    System.out.println("Number of Grades: " + grades.size());
    if (grades.isEmpty()) {
      System.out.println("No grades registered.");
      System.out.println("------------------------------");
      return;
    }

    System.out.printf("Average Grade: %.2f%n", average());
    System.out.println("Letter Grade: " + letterGrade());
    System.out.println("Pass/Fail: " + passStatus());
    System.out.println("Honor Roll: " + checkHonorStatus());
    System.out.println("------------------------------");
  }
}
