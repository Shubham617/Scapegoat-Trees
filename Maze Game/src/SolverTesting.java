import static org.junit.Assert.*;

import org.junit.Test;

public class SolverTesting {

	@Test
	public void test() {
		Display d=new Display();
		int[][] arr=d.genMaze(3, 3);
		Solver s=new Solver();
		assertEquals(6,s.CalMin(arr));
		
		
		//fail("Not yet implemented");
	}

}
