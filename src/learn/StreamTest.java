package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StreamTest {
	
	public static void main(String[] args) {
		System.out.println("\n start\n");
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Sumit", "9", 100));
		students.add(new Student("Patrick", "9", 90));
		students.add(new Student("Sam", "10", 80));
		students.add(new Student("Shreya", "5", 95));
		students.add(new Student("Nick", "5", 90));
		students.add(new Student("Ethan", "9", 75));
		students.add(new Student("Mike", "10", 85));
		
		//testForEach(students);
		//testFilter(students);
		//testSorted(students);
		//testMap(students);
		//testCount(students);
		//testMatch(students);
		testSequentialParallelStream();
	}
	
	public static void testForEach(List<Student> students) {
		//forEach, terminal operation
		//forEach accepts Consumer
		System.out.println("\n forEach *** test ***");
		students.stream().forEach(System.out::println); 
	}
	
	public static void testFilter(List<Student> students) {
		System.out.println("\n filter *** test ***");
		//Filter, intermediate operation 
		//accepts a predicate to filter all elements of the stream
		students.stream().filter((s) -> s.getName().startsWith("S"))
			.forEach(System.out::println);
	}
	
	public static void testSorted(List<Student> students) {
		//Sorted, intermediate operation
		//sorts in natural order or accepts Comparator.
		System.out.println("\n sorted *** test ***");
		students.stream().sorted((s1,s2) -> s1.getName().compareTo(s2.getName())) 
			.forEach(System.out::println); //forEach accepts Consumer
	}
	
	public static void testMap(List<Student> students) {
		//Map, intermediate operation
		//converts each element into another object using a function.
		System.out.println("\n map *** test ***");
		students.stream().map((s) -> s.getName())  
			.forEach(System.out::println);
	}
	
	public static void testCount(List<Student> students) {
		//count, terminal operation
		//number of elements in the stream as a long.
		System.out.println("\n count *** test ***");
		System.out.println(students.stream().count());
	}
	
	public static void testMatch(List<Student> students) {
		//match, terminal operation
		//number of elements in the stream as a long.
		System.out.println("\n anyMatch *** test ***");
		System.out.println(students.stream().anyMatch((s) -> s.getName().startsWith("S")));
		System.out.println("\n allMatch *** test ***");
		System.out.println(students.stream().allMatch((s) -> s.getName().startsWith("S")));
		System.out.println("\n noneMatch *** test ***");
		System.out.println(students.stream().noneMatch((s) -> s.getName().startsWith("S")));
	}

	public static void testSequentialParallelStream() {
		int count = 1000000;
		List<String> uidList = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
		    UUID uuid = UUID.randomUUID();
		    uidList.add(uuid.toString());
		}
		
		//sequential stream
		System.out.println("\n sequential stream *** test ***");
		long startTime = System.currentTimeMillis();
		System.out.println(uidList.stream().sorted().count());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("sequential stream - time taken: " + totalTime + " ms");
				
		//parallel stream
		System.out.println("\n parallel stream *** test ***");
		startTime = System.currentTimeMillis();
		System.out.println(uidList.parallelStream().sorted().count());
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("parallel stream - time taken: " + totalTime + " ms");
	}
	
	static class Student {
		private String name;
		private String grade;
		private Integer score;

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
