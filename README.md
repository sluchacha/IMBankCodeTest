# IMBankCodeTest
A repo on implementing the following code test questions without using any convenience libraries e.g. Java Stream API

### 1. Complete the following tasks
1. Write a function ***isPrime*** that returns true if a number is prime.
2. Write a function called ***memoize*** that takes any other function as input and returns a memoized version of that function.
3. Use the function in **2** above to memoize the ***isPrime*** function you wrote.


### 2. Write a function search that accepts 2 arguments:
1. A collection of values.
2. A value to find in the collection.

### **Note:**
  - The function search should implement a **binary search** on the **collection**.
  - If the value **isn’t found** in the **collection**, then the search function should **return -1**. 
  - If the value **is found** in the **collection**, then the function should **return the first index** of the value in the array.
  - For example, asked to find the value **2** in the **list [1,3,2,0]**, your function should return **2**.

## Summary on implementation
- The implementation makes use of **OOP(Object Oriented Programming)**.
- Convenience libraries have not been used less the implementations would be simple and straight forward.
  - e.g. for binary search of a collection we would have simply used the `Collection.binarySearch` function but this was not used.
- A **javadoc** has been generated and included for your reference.

| Question | Class | Function implementation with comments |
| --- | --- | --- |
| 1a | `IsPrime` | `isPrime(int n)` and `isPrime(int n, int i)`. Overloaded function, the former is iterative and latter recursive. |
| 1b | `Memoizer` | `memoize`. This in itself memoizes any single argument function. It has also been used to come up with a memoize bifunction `memoizeBi` to memoize functions with two arguments. |
| 1c | `IsPrime` | `memoizedIsPrime` and `memoizedBIisPrime`. Inline functions to memoize the `isPrime(int n)` and `isPrime(int n, int i)`. |
| 2a, 2b | `BinarySearch` | `binarySearch`. Overloaded function, two implementations. One for collections such as ArrayList/LinkedList (Collections that have indexing/random access), and another for primitive array of ints. |
| Run | `Main` | `Main`. For executing the above functions with sample data. | 

## Sample Output
![Sample Output](https://github.com/sluchacha/IMBankCodeTest/blob/master/IMBankCodeTest/Sample%20Output.PNG)
