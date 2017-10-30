package week05;

public class FibonacciEven {

	public FibonacciEven() {
		System.out.println("Starting a Fibonacci Even Calculator....");
	}

	private int calculateSumEvenNumbersUpTo(int i) {
		// 0, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
		// n = 4*(n-1)+(n-2)
		int a = 0;
		int b = 2;
		int c = 4*b+a; 
		int accum = 2;
		while (c<i) {
			accum += c;
			a = b;
			b = c;
			c = 4*b+a; 
		}
		return (accum);
	}
	
	
	public static void main(String[] args) {
		FibonacciEven  fb = new FibonacciEven();
		
		System.out.println(fb.calculateSumEvenNumbersUpTo(544));

	}


}
