package gingi.junit4;

public class Calculator {
	public double add(double number1, double number2){ 
		return number1 + number2;
	}
	
	
	public static void main(String[] args) {
		Calculator claculator = new Calculator();
		double result = claculator.add(10, 40);
		if (result != 60) {
			System.out.println("Bad result: " + result);
		}
	}
}
