package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		System.out.println("start");

		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Sumit", "9", 100));
		students.add(new Student("Patrick", "9", 90));
		students.add(new Student("Sam", "10", 80));
		students.add(new Student("Shreya", "5", 95));

		printStudentsGradeName(students);

		printStudentsNameGrade(students);

		Consumer<Student> gradeNameConsumer = (p) -> System.out.println(p
				.getGrade() + " " + p.getName());
		printStudentsUsingConsumer(students, gradeNameConsumer);

		Consumer<Student> nameGradeConsumer = (p) -> System.out.println(p
				.getName() + " " + p.getGrade());
		printStudentsUsingConsumer(students, nameGradeConsumer);
	}

	public static void printStudentsGradeName(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.getGrade() + " " + student.getName());
		}
	}

	public static void printStudentsNameGrade(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.getName() + " " + student.getGrade());
		}
	}

	public static void printStudentsUsingConsumer(List<Student> students,
			Consumer<Student> consumer) {
		for (Student student : students) {
			consumer.accept(student);
		}
	}

	static class Student {
		String name;
		String grade;
		Integer score;

		Student(String name, String grade, Integer score) {
			this.name = name;
			this.grade = grade;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		public String toString() {
			return name + " " + grade + " " + score;
		}
	}
}
