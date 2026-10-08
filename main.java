// Demonstrates the student grade management system.
public class Main {
    // Runs the functional requirement demonstrations.
    // @param args command-line arguments
    public static void main(String[] args) {
        System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");

        // Test 1: Student with honor roll.
        Student studentOne = new Student("001", "Maria Lopez");
        studentOne.addGrade(95.0);
        studentOne.addGrade(92.5);
        studentOne.addGrade(98.0);
        studentOne.reportCard();

        // Test 2: Student who passes.
        Student studentTwo = new Student("002", "Juan Perez");
        studentTwo.addGrade(75.0);
        studentTwo.addGrade(80.0);
        studentTwo.reportCard();

        // Test 3: Student who fails.
        Student studentThree = new Student("003", "Ana Torres");
        studentThree.addGrade(40.0);
        studentThree.addGrade(55.0);
        studentThree.reportCard();

        // Test 4: Invalid grade inputs.
        System.out.println("INVALID GRADE TESTS");
        studentOne.addGrade("Ninety");
        studentOne.addGrade(-10);
        studentOne.addGrade(150);
        studentOne.addGrade(Double.NaN);

        // Test 5: Remove grades by index and value.
        System.out.println("REMOVE GRADE TESTS");
        studentTwo.removeGradeByIndex(0);
        studentTwo.removeGradeByValue(80.0);
        studentTwo.removeGradeByIndex(9);
        studentTwo.removeGradeByValue(99.0);

        // Test 6: Invalid student data.
        System.out.println("INVALID STUDENT TESTS");
        try {
            Student invalidStudent = new Student("", "Pedro");
            invalidStudent.reportCard();
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        try {
            Student invalidStudent = new Student("004", null);
            invalidStudent.reportCard();
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        // Test 7: Report after removing grades.
        studentTwo.reportCard();
    }
}