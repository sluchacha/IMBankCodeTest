package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Run examples to display use of the functions
 * written/implemented for questions 1 and 2 of the code test
 * without use of convenience libraries e.g. Java Stream API 
 * 
 * @author Stephen Luchacha
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Main sample = new Main();
		
		sample.exampleMemoizeIsPrime(); 
		sample.exampleMemoizeIsPrimeRecursive();

		sample.exampleBinarySearchArrayOfInts();
		sample.exampleBinarySearchAsCollections();
	}
	
	/**
	 * Example using the memoized isPrime function 
	 */
	public void exampleMemoizeIsPrime() {
		// Value to check if prime
		int n = 839;// CHANGE VALUE AT YOUR CONVENIENCE
		
		// First Call
		long timeStarted = System.currentTimeMillis();
		boolean result1 = IsPrime.memoizedIsPrime.apply(n);		
		long t1 = System.currentTimeMillis() - timeStarted;
		
		// Second Call
		timeStarted = System.currentTimeMillis();
		boolean result2 = IsPrime.memoizedIsPrime.apply(n);
		long t2 = System.currentTimeMillis() - timeStarted;
		
		System.out.println("Is Prime Single Argument");
		System.out.println("------------------------");
		System.out.printf("First call to calculate isPrime(%d) is %d milliseconds. Result %s \n",n,t1,result1);
		System.out.printf("Time taken to calculate isPrime(%d) is %d milliseconds. Result %s \n\n",n,t2,result2);
	}
	
	/**
	 * Example using the memoized isPrime recursive function
	 */
	public void exampleMemoizeIsPrimeRecursive(){
		// Value to check if prime
		int n = 10007;// CHANGE VALUE AT YOUR CONVENIENCE
		
		// Current divisor
		int divisor = 2;
		
		// First Call
		long timeStarted = System.currentTimeMillis();
		boolean result1 = IsPrime.memoizedBIisPrime.apply(n,divisor);		
		long t1 = System.currentTimeMillis() - timeStarted;
		
		// Second Call
		timeStarted = System.currentTimeMillis();
		boolean result2 = IsPrime.memoizedBIisPrime.apply(n,divisor);
		long t2 = System.currentTimeMillis() - timeStarted;
		
		System.out.println("Is Prime Recursive Two Arguments");
		System.out.println("--------------------------------");
		System.out.printf("First call to calculate recursive isPrime(%d, %d) is %d milliseconds. Result %s \n",n,divisor,t1,result1);
		System.out.printf("Time taken to calculate recursive isPrime(%d, %d) is %d milliseconds. Result %s \n\n",n,divisor,t2,result2);
	}
	
	/**
	 * Example binary search for array of ints
	 */
	public void exampleBinarySearchArrayOfInts() {
		System.out.println("Binary Search an Array of ints");
		System.out.println("------------------------------");
		int pArray[] = new int[] {1,3,2,0};// CHANGE ELEMENTS AT YOUR CONVENIENCE
		int pSearch = 2;// CHANGE SEARCH VALUE AT YOUR CONVENIENCE
		
		// For display purposes only
		List<Integer> pList = new ArrayList<>(pArray.length);
		for(int i: pArray) pList.add(Integer.valueOf(i));
		System.out.print("Example 1:\n----------\nOriginal: ");
		System.out.println(pList);
		System.out.print("Sorted: ");
		pList.sort(null);
		System.out.println(pList);
		// End of display

		Arrays.sort(pArray);// Sort array before the binary search		
		int index = BinarySearch.binarySearch(pArray, pSearch);// perform the search
		System.out.printf("Found %d at index %d\n\n",pSearch,index);
	}
	
	/**
	 * Example binary search as collections
	 */
	public void exampleBinarySearchAsCollections() {	
		System.out.println("Binary Search as Collection(s)");
		System.out.println("------------------------------");
		// Example 1 - Integers using ArrayList collection
		Integer intArray[] = new Integer[] {9,1,8,3,7,5,6,2,4,0};// CHANGE ELEMENTS AT YOUR CONVENIENCE
		int intSearch = 4;// CHANGE SEARCH VALUE AT YOUR CONVENIENCE
		List<Integer> intList = new ArrayList<>();
		Collections.addAll(intList, intArray);// add all array elements to the collection
		
		// Collection of integers
		System.out.print("Example 1:\n----------\nOriginal: ");
		System.out.println(intList);
		System.out.print("Sorted: ");
		intList.sort(null);// Sort collection
		System.out.println(intList);
		int index = BinarySearch.binarySearch(intList, intSearch);// perform the search
		System.out.printf("Found %d at index %d\n\n",intSearch,index);
		
		// Example 2 - Characters using LinkedList collection
		Character chrArray[] = new Character[] {'f','d','c','a','e','b'};// CHANGE ELEMENTS AT YOUR CONVENIENCE
		Character chrSearch = 'd'; // CHANGE SEARCH VALUE AT YOUR CONVENIENCE
		List<Character> chrList = new LinkedList<>();
		Collections.addAll(chrList, chrArray);// add all array elements to the collection
		
		// Collection of chars
		System.out.print("Example 2:\n----------\nOriginal: ");
		System.out.println(chrList);
		System.out.print("Sorted: ");
		chrList.sort(null);// Sort collection
		System.out.println(chrList);
		index = BinarySearch.binarySearch(chrList, chrSearch);// perform the search
		System.out.printf("Found %s at index %d\n\n",chrSearch,index);
	}
	

}
