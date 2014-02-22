package algorithm.math;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MathUtilTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testIsPrime() {
		expectedException.expect(IllegalArgumentException.class);
		MathUtil.isPrime(-1);
		
		assertFalse(MathUtil.isPrime(0));
		assertFalse(MathUtil.isPrime(1));
		assertTrue(MathUtil.isPrime(2));
		assertTrue(MathUtil.isPrime(3));
		assertFalse(MathUtil.isPrime(4));
		assertTrue(MathUtil.isPrime(5));
		assertFalse(MathUtil.isPrime(6));
		assertTrue(MathUtil.isPrime(7));
		assertFalse(MathUtil.isPrime(8));
		assertFalse(MathUtil.isPrime(9));
		assertFalse(MathUtil.isPrime(10));
	}

}
