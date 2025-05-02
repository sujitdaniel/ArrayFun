
/** 
 * This class has @Test methods for testing all required methods in ArrayFun.java.
 * There are very limited, but each of the 14 Java methods have an @Test
 * started, which is more help than the previous assignment
 * 
 * @author Rick Mercer and Sujit Daniel
 * 
 */
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class ArrayFunTest {

	// If you include this instance variable, you can use myFun in all @Tests:
	private ArrayFun myFun = new ArrayFun();

	@Test
	public void testNumberOfPairs1() {
		String[] array = { "a", "b", "b", "a" };
		assertEquals(1, myFun.numberOfPairs(array));
		// Or pass a new array as the argument itself
		assertEquals(2, myFun.numberOfPairs(new String[] { "a", "a", "a" }));
		assertEquals(0, myFun.numberOfPairs(new String[] {}));
		assertEquals(0, myFun.numberOfPairs(new String[] { "a" }));
	}

	@Test
	public void testNumberOfPairs() {
		assertEquals(0, myFun.numberOfPairs(new String[] { "a", "A", "a" }));
		assertEquals(2, myFun.numberOfPairs(new String[] { "aBc", "aBc", "Xyz", "Xyz" }));
		assertEquals(0, myFun.numberOfPairs(new String[] {}));
		assertEquals(0, myFun.numberOfPairs(new String[] { "a" }));
	}

	@Test
	public void testNumberOfVowels() {
		assertEquals(3, myFun.numberOfVowels(new char[] { 'a', 'e', 'i' }));
		assertEquals(0, myFun.numberOfVowels(new char[] {}));
		assertEquals(0, myFun.numberOfVowels(new char[] { 'y', 'Y' }));
		assertEquals(2, myFun.numberOfVowels(new char[] { 'a', 'X', 'a' }));
	}

	@Test
	public void testSumGreaterThan() {
		double[] x = { 1, 2, 3 };
		// sum of elements in x is 6
		assertFalse(myFun.sumGreaterThan(x, 6));
		assertTrue(myFun.sumGreaterThan(x, 5.5));
		assertFalse(myFun.sumGreaterThan(new double[] {}, -1.0));
		assertTrue(myFun.sumGreaterThan(new double[] { -1.0 }, -2.0));
	}

	@Test
	public void testFrequency1() {
		Scanner scanner = new Scanner("5 0 1 2 1 5 2");
		int[] result = myFun.frequency(scanner);
		assertEquals(11, result.length);
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(2, result[2]);
		assertEquals(0, result[3]);

	}

	@Test
	public void testHowMany() {
		String[] two = { "5", "5" };
		assertEquals(2, myFun.howMany(two, "5"));
		assertEquals(0, myFun.howMany(new String[] {}, "empty array"));
		assertEquals(1, myFun.howMany(new String[] { "And", "there", "goes", "another" }, "another"));
		assertEquals(0, myFun.howMany(new String[] { "And", "there", "goes", "another" }, "Not Here"));
	}

	@Test
	public void testEvensLeft() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		myFun.evensLeft(a);
		// left side of the array at indexes 0..2 is even
		for (int i = 0; i <= 3; i++)
			assertEquals(0, a[i] % 2);
		// right side of the array at indexes 3..6 is odd
		for (int i = 4; i <= 6; i++)
			assertEquals(1, a[i] % 2);
	}
	
	@Test
    public void testEvensLeftWithAllOddNumbers() {
        int[] a = {1, 3, 5, 7};
        myFun.evensLeft(a);

        // The array already contains all odd numbers, so no changes should be made
        assertArrayEquals(new int[]{1, 3, 5, 7}, a);
    }

	@Test
	public void testReplace1() {
		char[] a = { 'A', 'B', 'C', 'D', 'B' };
		char[] a1 = myFun.replaced(a, 'B', 'Z');
		assertEquals('A', a1[0]);
		assertEquals('Z', a1[1]);
		assertEquals('C', a1[2]);
		assertEquals('D', a1[3]);
		assertEquals('Z', a1[4]);
	}

	@Test
	public void testShiftNTimes2() {
		int[] x = { 1, 2, 3, 4 };
		myFun.shiftNTimes(x, 2);
		assertEquals(3, x[0]);
		assertEquals(4, x[1]);
		assertEquals(1, x[2]);
		assertEquals(2, x[3]);
	}

	@Test
	public void testFound1() {
		String[] a = { "A", "B", "C" };
		assertTrue(myFun.found("A", a));
		assertFalse(myFun.found("a", a));
		assertFalse(myFun.found("x", a));
		assertFalse(myFun.found("x", new String[] {}));
	}

	@Test
	public void testRange() {
		int[] x = { -1, 1, -2, 2, -3, 4, -4, 4 };
		assertEquals(8, myFun.range(x));
		assertEquals(0, myFun.range(new int[] { 99 }));
		assertEquals(0, myFun.range(new int[] { -5, -5, -5, -5 }));
	}

	@Test
	public void fizzBuzz0() {
		String[] strs = myFun.fizzBuzz(14, 21);
		assertEquals(7, strs.length);
		assertEquals("14", strs[0]);
		assertEquals("FizzBuzz", strs[1]);
		assertEquals("16", strs[2]);
		assertEquals("17", strs[3]);
	}

	@Test
	public void testLargestWidth3() {
		int[] a = { 1, 2, 1, 1, 3 };
		int a1 = myFun.largestWidth(a);
		assertEquals(4, a1);
		int[] b = { 1, 4, 2, 1, 4, 1, 4 };
		int b1 = myFun.largestWidth(b);
		assertEquals(6, b1);
		int[] c = { 5, 5, 5, 5 };
		int c1 = myFun.largestWidth(c);
		assertEquals(4, c1);
		int[] d = { 99 };
		int d1 = myFun.largestWidth(d);
		assertEquals(1, d1);
	}

	@Test
	public void testThrees() {
		assertFalse(myFun.threes(new int[] { 1, 2, 1, 2, 1 }));
		assertTrue(myFun.threes(new int[] { 1, 3, 5 }));
		assertTrue(myFun.threes(new int[] { 2, 4, 6 }));
		assertTrue(myFun.threes(new int[] { 1, 1, 1, 2, 3 }));
	}

	@Test
	public void testBalanceSum() {
		assertTrue(myFun.balanceSum(new int[] { 1, 1, 1, 2, 1 }));
		assertFalse(myFun.balanceSum(new int[] { 2, 3, 4, 1, 2 }));
		assertTrue(myFun.balanceSum(new int[] { 10, 10 }));
	}
	
	@Test

    public void testEquallyDifferent() {

        assertTrue(equallyDifferent(2, 4, 6));

        assertTrue(equallyDifferent(4, 6, 2));

        assertFalse(equallyDifferent(4, 6, 3));

        assertTrue(equallyDifferent(2, 4, 6));

        assertTrue(equallyDifferent(4, 6, 2));

        assertTrue(equallyDifferent(6, 4, 2));

        assertTrue(equallyDifferent(3, 3, 3));

        assertTrue(equallyDifferent(-1, 0, 1));

        assertFalse(equallyDifferent(4, 6, 3));

        assertFalse(equallyDifferent(0, 5, 9));

        assertFalse(equallyDifferent(-5, 0, 4));

        assertFalse(equallyDifferent(2, 3, 3));

    }

	private boolean equallyDifferent(int i, int j, int k) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Test
    public void testEesPerWord() {

        assertEquals(0, totalEes(new Scanner("")));

        assertEquals(5, totalEes(new Scanner("Everyone is awesome")));

        assertEquals(0, totalEes(new Scanner("No way, 0")));

        assertEquals(8, totalEes(new Scanner("eEeE Everywhere found")));

    }

	private Object totalEes(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

}