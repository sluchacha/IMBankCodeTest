package solution;

import java.util.List;

/**
 * Questions 2a and 2b of the code test<br>
 * <br>Write a function search that accepts 2 arguments
 * <br>2a - a collection of values
 * <br>2b - a value to find in the collection
 * 
 * @author Stephen Luchacha
 *
 */
public final class BinarySearch {
	
	/**
	 * private constructor
	 */
	private BinarySearch() {}
	
	/**
	 * Searches the sorted collection/list for the search object using the binary search algorithm.
	 * <p>
	 * The collection must be sorted in ascending order prior to making this call
	 * <br>Applicable for collections such as ArrayList, LinkedList
	 * </p>
	 * @param <T> the class of the objects in the list
	 * @param sortedList collection of items to be searched
	 * @param search the value to be searched
	 * @return index of the search if found in the sorted 
	 * 		   collection sorted in ascending order, otherwise it returns -1
	 */
	public static final <T> int binarySearch(List<? extends Comparable<? super T>> sortedList, T search) {
		return binarySearchRecursive(sortedList, search, 0, sortedList.size()-1);
	}
	
	/**
	 * 
	 * @param <T> the class of the objects in the list
	 * @param sortedList collection of items to be searched
	 * @param search the value to be searched
	 * @param start index of first item in the collection
	 * @param end index of last item in the collection
	 * @return index of the search if found in the collection
	 * 		   otherwise it returns -1
	 */
	private static <T> int binarySearchRecursive(List<? extends Comparable<? super T>> sortedList, T search, int start, int end) {
		if(start > end) return -1;
		
		//To prevent integer overflow
		int mid = start + ((end - start) / 2);
		Comparable <? super T> midVal = sortedList.get(mid);
		int cmp = midVal.compareTo(search);
		
		if(cmp == 0) { // Search is equal to mid value then return index
			return mid;
		}else if(cmp > 0) { // Search the half on the left
			return binarySearchRecursive(sortedList, search, start, mid - 1);
		}else { // Search the half on the right
			return binarySearchRecursive(sortedList, search, mid + 1, end);
		}
	  
	}
	
	/**
	 * Searches the sorted array of ints for the search value using the binary search algorithm
	 * <p>
	 * The array must be sorted in ascending order prior to making this call.
	 * <br>ONLY applicable for array of ints
	 * </p>
	 * @param sortedArray collection of items
	 * @param search the value to be searched
	 * @return Returns -1 if not found and the first index of the value if found in the array
	 */
	public static final int binarySearch(int[] sortedArray, int search) {
		return binarySearchRecursive(sortedArray, search, 0, sortedArray.length - 1);
	}
	
	/**
	 * A recursive implementation to binary search an array of ints
	 * @param sortedArray
	 * @param search the value to be searched
	 * @param start index of first item in array
	 * @param end index of last item in array
	 * @return Returns -1 if not found and the first index of the value if found in the array
	 */
	private static int binarySearchRecursive(int[] sortedArray, int search, int start, int end) {
		if(start > end) return -1;
		
		//To prevent integer overflow
		int mid = start + ((end - start) / 2); // = (left + right) / 2;
		
		if(sortedArray[mid] == search) { // Search is equal to mid value then return
			return mid;
		}else if(sortedArray[mid] > search) { // Search the half on the left
			return binarySearchRecursive(sortedArray, search, start, mid - 1);
		}else { // Search the half on the right
			return binarySearchRecursive(sortedArray, search, mid + 1, end);
		}
	  
	}
	
}
