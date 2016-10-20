import static org.junit.Assert.*;

import org.junit.Test;

public class CompoundInterestTestCase {
	
	CompoundInterest CompoundInterest = new CompoundInterest();
	int ci = (int) CompoundInterest.compoundInterestCalculate(10);
	int testCI = 1000;

	@Test
	public void testCompoundInterest() {
		System.out.println("@Simple Interest: " + ci + " = " + testCI);
		assertEquals(ci, testCI);
	}

}
