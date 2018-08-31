package learn;

public class FunctionalInterfaceTest {

	@FunctionalInterface
	public interface CalculatorFunctionalInterface {
		int calculate(int a, int b);

		default int sum(int a, int b) {
			return a + b;
		}

		default int product(int a, int b) {
			return a * b;
		}
	}

	public static void main(String[] args) {
		// pre-lambda implementation of CalculatorFunctionalInterface
		CalculatorFunctionalInterface calculator = new CalculatorFunctionalInterface() {
			@Override
			public int calculate(int a, int b) {
				return sum(a, b);
			}
		};
		System.out.println(calculator.calculate(5, 6));

		// Lambda expression can be implicitly assigned to a Functional
		// interface
		CalculatorFunctionalInterface sumCalculator = (a, b) -> (a + b);
		System.out.println(sumCalculator.calculate(5, 6));

		CalculatorFunctionalInterface productCalculator = (a, b) -> (a * b);
		System.out.println(productCalculator.calculate(5, 6));
	}
}