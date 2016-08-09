package structures;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class ScapegoatTreeTest {

	private BSTInterface<Integer> tree;

	@Rule
    public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		tree = new ScapegoatTree<Integer>();
	}
	
	@Test
	public void testAdd() {
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		assertEquals(3, tree.height());
		tree.add(4);
		assertEquals(3, tree.height());
		ScapegoatTree<Integer> tree1=new ScapegoatTree<Integer>();
		tree1.add(0);
		tree1.add(-2);
		tree1.add(2);
		tree1.add(-3);
		tree1.add(-1);
		tree1.add(1);
		tree1.add(3);
		tree1.add(-4);
		tree1.add(-5);
		tree1.add(-6);
		assertEquals(5,tree1.height());
		tree1.add(-7);
		assertEquals(5,tree1.height());
		
	}
	
	@Test 
	public void testRemove() {
		for (int i: new int[] {3, 1, 5, 0, 4, 2, 6} ) {
			tree.add(i);
		}

		for (int i: new int[] {1, 2, 0, 4}) {
			tree.remove(i);
		}
		
		BSTInterface<Integer> smallTree = new BinarySearchTree<Integer>();
		smallTree.add(5);
		smallTree.add(3);
		smallTree.add(6);
		//assertFalse(smallTree.isBalanced());
		
		assertTrue(tree.equals(smallTree));
		ScapegoatTree<Integer> tree1=new ScapegoatTree<Integer>();
		tree1.add(1);
		tree1.add(2);
		//tree1.remove(1);
		tree1.add(3);
		tree1.add(4);
		tree1.add(5);
		tree1.add(6);
		tree1.add(7);
		tree1.add(8);
		tree1.add(9);
		tree1.add(10);
		tree1.add(11);
		tree1.remove(11);
		tree1.remove(10);
		tree1.remove(9);
		tree1.remove(8);
		tree1.remove(7);
		tree1.remove(6);
		assertEquals(2,tree1.height());;
		ScapegoatTree<Integer> tree2=new ScapegoatTree<Integer>();
		tree2.add(1);
		assertTrue(tree2.remove(1));
	
	//tree1.remove(2);
	//assertTrue(tree1.isEmpty());
	
	}
}
