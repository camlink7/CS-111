package Lab3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {
	private final String ALICE = "Alice";
	private final String BOB = "Bob";
	private final String CAROL = "Carol";
	private final double GRADES[] = { 100.0, 89.0, 90.0, 75.0, 65.0, 50.0 };
	private final char LETTERS[] = { 'A', 'B', 'A', 'C', 'D', 'X' };
	private final double AVERAGE = (100.0 + 89.0 + 90.0 + 75.0 + 65.0 + 50.0) / 6.0;
	private final char LETTER = 'C';

	@Test
	void testSetName() {
		Student stu = new Student(ALICE, 0);
		stu.setName(BOB);
		assertEquals(BOB, stu.getName());
		stu.setName(CAROL);
		assertEquals(CAROL, stu.getName());
	}

	@Test
	void testGetName() {
		Student alice = new Student(ALICE, 0);
		assertEquals(ALICE, alice.getName());
		Student bob = new Student(BOB, 0);
		assertEquals(BOB, bob.getName());
		Student carol = new Student(CAROL, 0);
		assertEquals(CAROL, carol.getName());
	}

	@Test
	void testSetGrade() {
		Student stu = new Student(ALICE, GRADES.length);
		for (int i = 0; i < GRADES.length; i++) {
			stu.setGrade(i, GRADES[i]);
			assertEquals(GRADES[i], stu.getGrade(i));
		}
	}

	@Test
	void testGetGradeInt() {
		Student stu = new Student(ALICE, GRADES.length);
		for (double g : GRADES) {
			stu.setGrade(0, g);
			assertEquals(g, stu.getGrade(0));
		}
	}

	@Test
	void testGetLetterGradeInt() {
		Student stu = new Student(ALICE, GRADES.length);
		for (int i = 0; i < GRADES.length; i++) {
			stu.setGrade(i, GRADES[i]);
			assertEquals(LETTERS[i], stu.getLetterGrade(i));
		}
	}

	@Test
	void testGetGrade() {
		Student stu = new Student(ALICE, GRADES.length);
		for (int i = 0; i < GRADES.length; i++) {
			stu.setGrade(i, GRADES[i]);
		}
		assertEquals(AVERAGE, stu.getGrade());
	}

	@Test
	void testGetLetterGrade() {
		Student stu = new Student(ALICE, GRADES.length);
		for (int i = 0; i < GRADES.length; i++) {
			stu.setGrade(i, GRADES[i]);
		}
		assertEquals(LETTER, stu.getLetterGrade());
	}

}