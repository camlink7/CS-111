/*
 * Name: Camden Link
 * Assignment: Lab 3
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-01-23
 * Purpose: This file contains the implementation of the Student class required for Lab 3
 */


/*
 * Class Name: Student
 * Purpose: Allows for representation of a Student storing a student's name and grades for their assignments.
 * Includes getters, setters, and grade calculation operations.
 * 
 * For the purposes of GRADES, the following grading scale is used...
 * A - >=90
 * B - >=80 < 90
 * C - >= 70 < 80
 * D - >= 60 < 70
 * X - <60
 * 
 * Exceptions: N/A
 */
public class Student {
	private String name;
	private double[] assignments;
	
	/*
	 * Method Name: Student
	 * Purpose: Constructs a new Student object given a name and number of assignments
	 * Parameters:
	 * - name: The name of the student
	 * - assignments: The number of assignments the student has
	 * Preconditions: N/A
	 * Postconditions: N/A
	 * Exceptions: N/A
	 */
	public Student(String name, int assignments) {
		this.name = name;
		this.assignments = new double[assignments];
		
		//Initialize all assignment grades to be 0.0 by default
		for (int i = 0; i < this.assignments.length; i++) {
			this.assignments[i] = 0.0;
		}
	}

	/*
	 * Method Name: setName
	 * Purpose: Sets the name of the student to a given String
	 * Parameters:
	 * - name: The new name of the student
	 * Preconditions: N/A
	 * Postconditions: Sets the object instance's name to the newly given String name
	 * Exceptions: N/A
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Method Name: getName
	 * Purpose: Gets the current name of the Student object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the current name of the Student object
	 * Exceptions: N/A
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Method Name: setGrade
	 * Purpose: Sets the grade of a specified assignment number
	 * Parameters:
	 * - assignment: The index of the assignment number starting from 0
	 * - grade: The value that the specified assignment number should have
	 * Preconditions: assignment >= 0 && assignment < number of assignments
	 * Postconditions: The grade will be stored and matched to the given assignment number
	 * Exceptions: N/A
	 */
	public void setGrade(int assignment, double grade) {
		this.assignments[assignment] = grade;
	}

	/*
	 * Method Name: getGrade
	 * Purpose: Gets the grade of a specified assignment number
	 * Parameters:
	 * - assignment: The index of a specified assignment
	 * Preconditions: assignment >= 0 && assignment < number of assignments
	 * Postconditions: Returns the grade value of the specified assignment index
	 * Exceptions: N/A
	 */
	public double getGrade(int assignment) {
		return this.assignments[assignment];
	}

	/*
	 * Method Name: getLetterGrade
	 * Purpose: Gets the letter grade of a specified assignment index on a standard grading scale
	 * Parameters:
	 * - assignment: The index of the specified assignment to get the grade of
	 * Preconditions: assignment >= 0 && assignment < number of assignments
	 * Postconditions: Returns a single letter representing the specified assignment's grade
	 * Exceptions: N/A
	 */
	public char getLetterGrade(int assignment) {
		double targetGrade = this.assignments[assignment];
		return doubleToLetterGrade(targetGrade);
	}

	/*
	 * Method Name: getGrade
	 * Purpose: Gets the average of all assignment's grades, an overall grade value
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the calculated average of all assignment's grades
	 * Exceptions: N/A
	 */
	public double getGrade() {
		double gradesSum = 0.0;
		for (int i = 0; i < this.assignments.length; i++) {
			gradesSum += this.assignments[i];
		}
		return gradesSum / this.assignments.length;
	}

	/*
	 * Method Name: getLetterGrade
	 * Purpose: Gets the letter grade representing the calculated average of all assignments
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a single letter representing average grade of all assignments
	 * Exceptions: N/A
	 */
	public char getLetterGrade() {
		return doubleToLetterGrade(this.getGrade());
	}
	
	
	//HELPER METHODS
	
	/*
	 * Method Name: doubleToLetterGrade
	 * Purpose: Converts a double grade value into the relevant letter grade based on the standard grading scale
	 * Parameters:
	 * - grade: The grade value to be converted into a letter grade
	 * Preconditions: N/A
	 * Postconditions: Returns a single grade letter corresponding to the given grade value
	 * Exceptions: N/A
	 */
	private char doubleToLetterGrade(double grade) {
		if (grade >= 90) { return 'A'; }
		else if (grade >= 80 && grade < 90) { return 'B'; }
		else if (grade >= 70 && grade < 80) { return 'C'; }
		else if (grade >= 60 && grade < 70) { return 'D'; }
		else { return 'X'; }
	}
}