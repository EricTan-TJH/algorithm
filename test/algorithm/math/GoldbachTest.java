package algorithm.math;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GoldbachTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testProve() {

		assertTrue(new Goldbach().prove(1000));
		assertTrue(new Goldbach().prove(8));

		expectedException.expect(IllegalArgumentException.class);
		assertTrue(new Goldbach().prove(-1));

		expectedException.expect(IllegalArgumentException.class);
		assertTrue(new Goldbach().prove(1));
	}

}
