package learn;

public class DefaultMethodTest {
	public interface CalculatorInterface {
		int calculate(int a, int b);

		default int sum(int a, int b) {
			System.out.println("Start sum");
			return a + b;
		}
	}

	public static void main(String[] args) {
		// anonymous inner class implementing abstract method calculate
		CalculatorInterface calculator = new CalculatorInterface() {
			@Override
			public int calculate(int a, int b) {
				System.out.println("Start calculate");
				return sum(a, b);
			}
		};

		// invoke implemented abstract method calculate
		System.out.println(calculator.calculate(5, 6));

		// invoke default method already implemented in interface
		System.out.println(calculator.sum(5, 6));
	}
}