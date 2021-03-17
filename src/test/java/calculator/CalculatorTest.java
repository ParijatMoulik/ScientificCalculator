package calculator;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {

		private App calculator;

	    @Before
	    public void setUp() {
	        calculator = new App();
	    }

		@Test
	    public void testSquareRoot() {
	        double a = 9.0;

	        double expectedResult = 3.0;
	        double result = calculator.SquareRoot(a);
	        Assert.assertEquals(expectedResult, result, 0);
	    }

		@Test
		public void testFactorial() {
			double a = 3;
	        double expectedResult = 6;
	        double result = calculator.Factorial(a);
	        Assert.assertEquals(expectedResult, result, 0);
		}

		@Test
		public void testLogarithm() {
			double a = 1;
	        double expectedResult = 0;
	        double result = calculator.Logarithm(a);
	        Assert.assertEquals(expectedResult, result, 0);
		}

		@Test
		public void testPower() {
			double a = 2;
	        double b = 2;
	        double expectedResult = 4.0;
	        double result = calculator.Power(a, b);
	        Assert.assertEquals(expectedResult, result, 0.0001);
		}

//		@Test(expected = IllegalArgumentException.class)
//	    public void testDivideByZero() {
//	        int a = 25;
//	        int b = 0;
//	        calculator.Power(a, b);
//	    }
}
