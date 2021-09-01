package in.ashokit.beans;

public class MyApp {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Integer result = calc.add(10, 30);
		System.out.println(result);
	}
}
