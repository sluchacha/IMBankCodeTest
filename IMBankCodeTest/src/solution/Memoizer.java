package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Questions 1b of the code test<br>
 * <br>1b - Write a function called memoize that takes any other 
 * function as input and returns a memoized version of that function
 * <p>
 * Generic Class to facilitate external memoization of functions.
 * This involves caching previously computed results in a data structure
 * and return the chached result when the same computation is needed again
 * </p>
 * 
 * @author Stephen Luchacha
 *
 * @param <T> Input type
 * @param <R> Output/Result type
 */
public final class Memoizer<T,R> {
	// Holds previous results
	private final Map<T,R> cache = new HashMap<>();
	
	/**
	 * private constructor
	 */
	private Memoizer() {}
	
	/**
	 * Call to memoize a function that has a single argument.
	 * 			This can be used by any other function
	 * @param <T> Input argument type
	 * @param <R> Output/Results type
	 * @param fn function with a single argument
	 * @return a memoized function
	 */
	public static final <T,R> Function <T,R> memoize(final Function<T,R> fn){
		return new Memoizer<T,R>().doMemoize(fn);
	}
	
	/**
	 * Call to memoize a function that has two arguments
	 * <br>Included this to show that the memoize function can be used by
	 * another function particularly one with different no of arguments
	 * @param <T1> Input argument 1 type
	 * @param <T2> Input argument 2 type
	 * @param <R> Output/Results type
	 * @param biFn function with two arguments
	 * @return a memoized function
	 */
	public static final <T1, T2, R> BiFunction<T1, T2, R> memoizeBi(final BiFunction<T1, T2, R> biFn) {
	    final BiFunction<T1, T2, Supplier<R>> biFnSupplier = (x, y) -> () -> biFn.apply(x, y);
	    final Function<T1, Function<T2, R>> transformed 
	    		= Memoizer.memoize(
	    				x -> Memoizer.memoize(
	    						y -> biFnSupplier.apply(x, y).get()));
	    return (x, y) -> transformed.apply(x).apply(y);
	}
	
	/**
	 * Checks for previous results, if non exists it computes and stores a new one
	 * <br>Thread safe and recursion safe implementation to memoize
	 * @param fn function that has one argument
	 * @return a memoized function
	 */
	private Function <T,R> doMemoize(final Function<T,R> fn){
		// Wrap with re-entrant lock to make the function
		// thread and recursion safe
		ReentrantLock lock = new ReentrantLock();
		return input->{
			lock.lock();
			try {				
				/*
				 * UP-TO-DATE WAY
				 */
				// return cache.computeIfAbsent(input, fn);
				/*
				 * END UP-TO-DATE WAY
				 */
				
				/*
				 * ALTERNATIVELY - OLD WAY
				 */
				if(!cache.containsKey(input)) {
					cache.put(input, fn.apply(input));
				}
				return cache.get(input);
				/*
				 * END - OLD WAY
				 */
				
			}finally {
				lock.unlock();
			}
		};
	}

}

