import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleInterestTestCase {
	
	SimpleInterest SimpleInterest = new SimpleInterest();
	int si = SimpleInterest.simpleInterestCalculate(10);
	int testSI = 10000;

	@Test
	public void testSimpleInterest() {
		System.out.println("@Simple Interest: " + si + " = " + testSI);
		assertEquals(si, testSI);
	}

}
