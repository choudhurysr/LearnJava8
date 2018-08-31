package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		System.out.println("start");

		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Sumit", "9", 100));
		students.add(new Student("Patrick", "9", 90));
		students.add(new Student("Sam", "10", 80));
		students.add(new Student("Shreya", "5", 95));

		System.out.println(findStudentsByGrade(students, "9"));

		System.out.println(findStudentsByScoreGT(students, 90));

		Predicate<Student> gradePredicate = p -> p.getGrade().equals("9");
		System.out.println(findStudentsByPredicate(students, gradePredicate));

		Predicate<Student> scorePredicate = p -> p.getScore() > 90;
		System.out.println(findStudentsByPredicate(students, scorePredicate));

	}

	public static List<Student> findStudentsByGrade(List<Student> students,
			String grade) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getGrade().equals(grade))
				result.add(student);
		}
		return result;
	}

	public static List<Student> findStudentsByScoreGT(List<Student> students,
			Integer score) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getScore() > score)
				result.add(student);
		}
		return result;
	}

	public static List<Student> findStudentsByPredicate(List<Student> students,
			Predicate<Student> predicate) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			if (predicate.test(student))
				result.add(student);
		}
		return result;
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
