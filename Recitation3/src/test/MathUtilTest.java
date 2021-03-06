package test;
import exercise.MathUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class MathUtilTest {
	private double precision;
	@Before
	public void setUp(){
		precision = 0.0000001;
	}

	@Test
	public void linearInterpolateTest() {
		double [] p1 = {-1,-1};
		double [] p2 = {3, 3};
		double x = 1.7;
		
		double expected = 1.7;
		
		assertEquals(expected, MathUtil.linearInterpolate(p1, p2, x), precision);
	}

	@Test
	public void getMidpointTest(){
		double[] p1 = {-1,-1};
		double[] p2 = {3,3};
		double[] expected = {1,1};
		
		assertArrayEquals(expected, MathUtil.getMidpoint(p1, p2),precision);
	}
	
	@Test
	public void computeMeanTest(){
		double[] nums = {1,2,3,4,5};
		double expected = 3.0;
		
		assertEquals(expected, MathUtil.computeMean(nums),precision);
	}
}
