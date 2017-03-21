package testcase;

import static org.junit.Assert.*;
import org.junit.Test;
import huawei.JavaTest;

public class JavaTestTest extends JavaTest {
	final static double Delta = 1e-6;  
	
	@Test
	public void test_Case1() throws JavaTestException {
		assertEquals(calculate("1.0 2.0 +"), 3.0, Delta);
	}

	@Test
	public void test_Case2() throws JavaTestException {
		assertEquals(calculate("1 2 + 3 *"), 9.0, Delta);
	}

	@Test(expected=RPNSyntaxErrorException.class)
	public void test_Case3() throws JavaTestException {
		calculate("1.0 +");
	}
	
	//test cases by Yufen Wang
	@Test(expected=DevideByZeroException.class)
	public void test_Case4() throws JavaTestException {
		calculate("1 2 2 - /");
	}
}