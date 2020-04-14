package solution;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Questions 1a and 1c of the code test<br>
 * <br>1a - Write a function isPrime that returns true if a number is prime
 * <br>1c - Use the function in 1b to memoize the isPrime function you wrote
 * <p>
 * A prime number is a number which is only divisible
 * by only two numbers: 1 and itself
 * </p>
 * 
 * @author Stephen Luchacha
 * 
 */
public final class IsPrime {
	
	// Memoize the isPrime function with one argument
	public static final Function<Integer, Boolean> memoizedIsPrime = Memoizer.memoize(IsPrime::isPrime);
	
	// Memoize the isPrime function with two arguments
	public static final BiFunction<Integer, Integer, Boolean> memoizedBIisPrime = Memoizer.memoizeBi(IsPrime::isPrime);
	
	/**
	 * private constructor
	 */
	private IsPrime() {}
	
	/**
	 * isPrime written in an iterative manner 
	 * @param n Integer number to check whether it is prime
	 * @return true if n is prime else returns false
	 */
	public static final boolean isPrime(int n) {
		/* 
		//Simulate a delay due to fast executions
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {}
		// End Simulate
		 */
		boolean flag = true;

		if(n<=1) flag = false;
		else 
			for(int i = 2; i <= n/2; i++ ) {
				if(n%i == 0) {
					flag = false;
				}
			}
		
		return flag;
	}	
	
	/**
	 * isPrime written in a recursive manner
	 * @param n Integer number to check whether it is prime
	 * @param i is current divisor to check
	 * @return true if n is prime else returns false
	 */
	public static final boolean isPrime(int n, int i) {
		// First Cases
		if(n <= 2)
			return (n == 2) ? true : false;
		if(n%i == 0)
			return false;
		if(i * i > n)
			return true;
		
		// Check for the next divisor
		return isPrime(n, i+1);
	}
}
