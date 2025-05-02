import java.util.Scanner;

/**
 * This class has 14 methods related by the fact that CSC 210 students are
 * learning the Java array object. You will have to write your own @Test methods
 * with as many assertions as needed to ensure the methods here are correct.
 * 
 * @author Rick Mercer and Sujit Daniel
 */
public class ArrayFun {

	///////////////////////////////////////////////////////////////////////////////
	// Return the number of times a pair occurs in array. A pair is any two String
	// values that are equal (case sensitive) in consecutive array elements.
	// The array may be empty or have only one element, in these cases return 0.
	//
	// numberOfPairs({"a", "b", "c" }) returns 0
	// numberOfPairs({"a", "A", "a"}) returns 0 Case sensitive
	// numberOfPairs({"aBc", "aBc", "Xyz", "Xyz" }) returns 2
	// numberOfPairs({ }) returns 0
	// numberOfPairs({"a"}) returns 0
	//
	public int numberOfPairs(String[] array) {
		int pairCount = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(array[i + 1])) {
				pairCount++;
			}
		}
		return pairCount;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given a filled array of char array elements, return the number of vowels
	// which could be the letters 'a' , 'e', 'i', 'o', or 'u' in either lower
	// or upper case: 'A', 'E', 'I', 'O', 'U'. If the array is empty as in
	// char[] chars = new char[0];, return 0.
	//
	// numberOfVowels({'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) returns 10
	// numberOfVowels({'y', 'Y' } ) returns 0
	// numberOfVowels({'a', 'X', 'a' } ) returns 2
	// numberOfVowels({ } ) returns 0
	//
	public int numberOfVowels(char[] array) {
		int numOfVowels = 0;
		String vowelsStr = "AaEeIiOoUu";
		for (char inputChar : array) {
			numOfVowels += vowelsStr.indexOf(inputChar) != -1 ? 1 : 0;
		}
		return numOfVowels;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given a filled array of double array elements, return true if the sum of all
	// array elements is greater than sum. Return false if the array is empty. Sum
	// may be negative.
	//
	// sumGreaterThan( {double[] 1.1, 2.2, 3.3 }, 4.0) returns true
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 6.6) returns false because the sum
	// 6.6 is equal to the 2nd argument, not greater than
	// sumGreaterThan( { }, -1.0) returns false
	//
	public boolean sumGreaterThan(double[] array, double sum) {
		// TODO: Complete this method
		if (array.length == 0) {
			return false;
		}
		double arraySum = 0.0;
		for (double element : array) {
			arraySum += element;

		}
		if (arraySum > sum) {
			return true;
		} else {
			return false;
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given a Scanner constructed with a String containing a stream of integers in
	// the range of 0..10 (like quiz scores), return an array of 11 integers where
	// the first value (at index 0) is the number of 0s in the Scanner, the second
	// value (at index 1) is the number of ones on the Scanner, and the 11th value
	// (at index 10) is the number of tens in the Scanner. The following assertions
	// must pass.
	//
	// Scanner scanner = new Scanner("5 0 1 2 1 5 2");
	// int[] result = myFun.frequency(scanner);
	// assertEquals(11, result.length);
	// assertEquals(1, result[0]); // There was 1 zero
	// assertEquals(2, result[1]);
	// assertEquals(2, result[2]);
	// assertEquals(0, result[3]);
	// assertEquals(0, result[4]);
	// assertEquals(2, result[5]); // There were 2 5s
	// for(int score = 6; score <= 10; score++) {
	// .. assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
	//
	// Precondition: scanner always has valid integers in the range of 0..10
	//
	public int[] frequency(Scanner scanner) {
		// TODO: Complete this method
		int[] result = new int[11];

		while (scanner.hasNextInt()) {
			int score = scanner.nextInt();

			if (score >= 0 && score <= 10) {
				result[score]++;
			}
		}

		return result;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return the number of elements in an array of Strings that equal valueToFind.
	// This is case sensitive.
	//
	// howMany( {"A", "a", "A", "a" }, "A" ) returns 2
	// howMany( {"And", "there", "goes", "another"}, "another" ) returns 1
	// howMany( {"And", "there", "goes", "another"}, "Not Here" ) returns 0
	// howMany( { }, "empty array" ) returns 0
	//
	public int howMany(String[] array, String valueToFind) {
		// TODO: Complete this method
		int count = 0;

		for (String element : array) {
			if (element == valueToFind) {
				count++;
			}
		}
		return count;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Modify the parameter array so it still contains the exact same numbers as the
	// given array, but rearranged so that all the even numbers come before all the
	// odd numbers. Other than that, the numbers can be in any order. You must
	// modify the array argument by changing array in method evensLeft. The array
	// may be empty or have only 1 element so no change should be made.
	//
	// Original Array. . . . . Modified Array using Rick's algorithm
	// {1, 0, 1, 0, 1, 1, 0} . { 0, 0, 0, 1, 1, 1, 1 }
	// {3, 3, 2} . . . . . . . { 2, 3, 3 }
	// {2, 2, 2} . . . . . . . { 2, 2, 2}
	// {1, -2, 3, -4, 6} . . . { -2, -4, 6 1 3}
	//
	public void evensLeft(int[] array) {
		// TODO: Complete this method
		int i = 0, j = array.length - 1;
		while (i < j) {
			if (array[i] % 2 == 0) {
				i++;
			} else if (array[j] % 2 != 0) {
				j--;
			} else {
				array[i] = array[i] + array[j];
				array[j] = array[i] - array[j];
				array[i] = array[i] - array[j];
				i++;
				j--;
			}
		}

	}

	///////////////////////////////////////////////////////////////////////////////
	// Return a new char[] that is a copy of array with all occurrences of oldChar
	// replaced by newChar. The original array argument must remain unchanged.
	// The returned array must have exactly the same capacity
	// as the array reference passed to the parameter referenced as array.
	//
	// replaced ({'A', 'B', 'C', 'D', 'B'}, 'B', '+') returns a
	// new array {'A', '+', 'C', 'D', '+'}
	//
	// replaced( { 'A', 'B', 'C', 'D', 'B'}, 'C', 'L' ) returns a
	// new array { 'A', 'B', 'L', 'D', 'B' }
	//
	// replaced( { 'n', 'n', 'n', 'D', 'n'}, 'n', 'T' ) returns a
	// new array { 'T', 'T', 'T', 'D', 'T' }
	//
	// replaced( { }, 'n', 'T' ) returns a
	// new array { }
	//
	public char[] replaced(char[] array, char oldChar, char newChar) {
		char[] newArray = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == oldChar) {
				newArray[i] = newChar;
			} else {
				newArray[i] = array[i];
			}
		}
		return newArray;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Modify array so it is "left shifted" n times -- so
	// shiftNTimes({6, 2, 5, 3}, 1) changes the array argument to {2, 5, 3, 6} and
	// shiftNTimes({6, 2, 5, 3}, 2) changes the array argument to {5, 3, 6, 2}.
	// You must modify the array argument by changing the parameter array inside
	// method shiftNTimes. Remember, a change to the parameter inside the method
	// shiftNTimes changes the argument inside the @Test method.
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 3 ) modifies
	// the array to { 4, 5, 6, 7, 1, 2, 3 }
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 0 ) does not modify the array
	//
	// shiftNTimes( { 1, 2, 3 }, 5) modifies array to { 3, 1, 2 }
	//
	// shiftNTimes( { 3 }, 5) modifies array to { 3 }
	//
	public void shiftNTimes(int[] array, int numShifts) {
		// TODO: Complete this method
		int length = array.length;

		numShifts %= length;

		if (numShifts < 0) {
			numShifts = length + numShifts;
		}

		for (int shift = 0; shift < numShifts; shift++) {
			int temp = array[0];

			for (int i = 0; i < length - 1; i++) {
				array[i] = array[i + 1];
			}

			array[length - 1] = temp;
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return the range of the numbers in an array[].
	// The range is the maximum value - minimum value
	//
	// range ({1, 2, 3, 4}) returns 4 - 1 or 3
	// range ({1, 2, -3, 4}) returns 4 - -3 or 7
	// range ({ 99 }) returns 0
	//
	// Precondition: x.length >= 1
	//
	public int range(int[] x) {
		// TODO: Complete this method
		int min = x[0];
		int max = x[0];

		for (int i = 1; i < x.length; i++) {
			if (x[i] < min) {
				min = x[i];

			} else if (x[i] > max) {
				max = x[i];
			}
		}
		return max - min;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return true is search is found the array strs
	// or false if search is not found in the array.
	// This method is case-sensitive, the string must match exactly
	//
	// found( "A", {"A","B","C"} ) returns true
	// found( "a", {"A","B","C"} ) returns false
	// found( "x", {"a","b","c", "d"} ) returns false
	// found( "x", { } ) returns false
	//
	public boolean found(String search, String[] strs) {
		// TODO: Complete this method
		for (String str : strs) {
			if (str.equals(search)) {
				return true;
			}
		}
		return false;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Consider the series of numbers beginning at start and running up to but not
	// including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4.
	// Return a new String[] array containing the string form of these numbers,
	// except for multiples of 3, use "Fizz" instead of the number, for multiples
	// of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java,
	// String.valueOf(xxx) will make the String form of an int or other type.
	//
	// fizzBuzz(1, 6) returns ["1", "2", "Fizz", "4", "Buzz"]
	// fizzBuzz(1, 8) returns ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
	// fizzBuzz(14, 20) returns ["14", "FizzBuzz", "16", "17", "Fizz", "19"]
	//
	public String[] fizzBuzz(int start, int end) {
		String[] fizzBuzzArray = new String[end - start];
		for (int i = 0; i < end - start; i++) {
			if ((i + start) % 15 == 0) {
				fizzBuzzArray[i] = "FizzBuzz";
			} else if ((i + start) % 5 == 0) {
				fizzBuzzArray[i] = "Buzz";
			} else if ((i + start) % 3 == 0) {
				fizzBuzzArray[i] = "FizzBuzz";
			} else {
				fizzBuzzArray[i] = String.valueOf(i + start);
			}
		}
		return fizzBuzzArray;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Consider the leftmost and rightmost appearances of some value in an array.
	// We'll say that the "width" is the number of elements between the two
	// inclusive. A single value has a width of 1. Return the largest width found
	// in the given array.
	//
	// largestWidth({ 1, 2, 1, 1, 3 }) returns 4 (index 0 through index 3)
	// largestWidth({ 1, 4, 2, 1, 4, 1, 4 }) returns 6 (index 0 through index 5)
	// largestWidth({ 5, 5, 5, 5 }) returns 4 (index 0 through index 3)
	// largestWidth({ 99 }) returns 1 (index 0 through index 0)
	// largestWidth({ }) returns 0
	//
	public int largestWidth(int[] nums) {
		// TODO: Complete this method
		int maxWidth = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= i; j--) {
				if (nums[i] == nums[j]) {
					maxWidth = Math.max(maxWidth, j - i + 1);
					break;
				}
			}
		}
		return maxWidth;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given an array of ints, return true if the array contains either three eve
	// or three odd values all next to each other.
	//
	// threes({2, 1, 3, 5}) returns true
	// threes({2, 1, 2, 5}) returns false
	// threes({2, 4, 2, 5}) returns true
	//
	public boolean threes(int[] nums) {
		// TODO: Complete this method
		int i = 0;
		while (i < nums.length - 2) {
			if (nums[i] % 2 == nums[i + 1] % 2 && nums[i] % 2 == nums[i + 2] % 2) {
				return true;
			}
			i++;
		}
		return false;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given a non-empty array, return true if there is a place to split the array
	// such that the sum of the numbers on one side is equal to the sum of the
	// numbers on the other side.
	//
	// balanceSum([1, 1, 1, 2, 1]) returns true
	// balanceSum([2, 1, 1, 2, 1]) returns false
	// balanceSum([10, 10]) returns true
	//
	// Here are two ready to go assertions:
	//
	// assertTrue(myFun.balanceSum(new int[] { 6, 1, 2, 1, 4 }));
	// assertFalse(myFun.balanceSum(new int[] {2, 3, 4, 1, 2} ));
	//
	// Precondition: nums.length > 0
	//
	public boolean balanceSum(int[] nums) {
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}
		if (totalSum % 2 == 0) {
			int halfSum = totalSum / 2;
			for (int j = 0; j < nums.length && halfSum >= 0; j++) {
				halfSum -= nums[j];
				if (halfSum == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public class EquallyDifferent {
		public static boolean equallyDifferent(int a, int b, int c) {
	        int diffAB = Math.abs(a - b);
	        int diffBC = Math.abs(b - c);
	        int diffCA = Math.abs(c - a);
	        
	        return (diffAB == diffBC && diffCA != 0) || (diffBC == diffCA && diffAB != 0) || (diffCA == diffAB && diffBC != 0) || (diffCA == diffAB && diffAB == 0);
	    }
	}
	
	public static int totalEes(Scanner scanner) {
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == 'e' || ch == 'E') {
                    count++;
                }
            }
        }

        return count;
    }
}