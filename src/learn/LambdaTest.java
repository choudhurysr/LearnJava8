package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		System.out.println("start");

		// test1();

		test2();
	}

	public static void test1() {
		List<String> names = Arrays.asList("b", "z", "t", "x", "c");
		// pre-lambda sorting
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println(names);

		names = Arrays.asList("b", "z", "t", "x", "c");

		// sort using lambda expressions instead of anonymous inner classes
		Collections.sort(names, (String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		// braces {} and the return keyword can be skipped for one line method
		// bodies
		// parameter types can be skipped as compiler knows it
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
		System.out.println(names);
	}

	public static void test2() {
		// pre-lambda
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello - using anonymous inner class");
			}
		}).start();

		// Runnable interface implemented using Lamda expression
		new Thread(() -> System.out.println("Hello - using lambda expression"))
				.start();
	}
}
