package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class BinarySearchTreeTest {

	private BSTInterface<Integer> emptyTree;
	private BSTInterface<String> oneNodeTree;
	private static final String FOO = "foo";

	@Rule
    public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		emptyTree = new BinarySearchTree<Integer>();
		oneNodeTree = new BinarySearchTree<String>();
		oneNodeTree.add(FOO);
	}
	
	@Test
	public void testEmpty() {
		assertTrue(emptyTree.isEmpty());
	}

	@Test
	public void testNotEmpty() {
		assertFalse(oneNodeTree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyTree.size());
		assertEquals(1, oneNodeTree.size());
	}
	
	@Test
	public void testContains() {
		assertTrue(oneNodeTree.contains(FOO));
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		tree.add(0);
		tree.add(-1);
		tree.add(-2);
		tree.add(1);
		tree.add(2);
		tree.add(10);
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(-1));
		assertTrue(tree.contains(-2));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));
		assertFalse(tree.contains(11));
		assertFalse(tree.contains(10000));
		//assertFalse(tree.contains(null));
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		assertFalse(tree1.contains(0));
		
	}
	@Test(timeout = 5000, expected = NullPointerException.class)
	public void testcontainsException(){
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.remove(4);
		tree.contains(null);
	}
	@Test
	public void testRemove() {
		assertFalse(emptyTree.remove(0));

	}
	
	@Test
	public void testGet() {
		assertEquals(FOO, oneNodeTree.get(FOO));
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		tree.add(0);
		tree.add(-1);
		tree.add(-2);
		tree.add(1);
		tree.add(2);
		tree.add(10);
		assertEquals(0,tree.get(0).intValue());
		assertEquals(-1,tree.get(-1).intValue());
		assertEquals(-2,tree.get(-2).intValue());
		assertEquals(1,tree.get(1).intValue());
		assertEquals(10,tree.get(10).intValue());
		assertEquals(null,tree.get(84));
		assertEquals(null,tree.get(85));
		
	}
	
	@Test
	public void testAdd() {
		emptyTree.add(1);
		assertFalse(emptyTree.isEmpty());
		assertEquals(1, emptyTree.size());
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		//tree1.add(null);
	}
	
	@Test
	public void testGetMinimum() {
		assertEquals(null, emptyTree.getMinimum());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(FOO, oneNodeTree.getMaximum());
		//oneNodeTree.add(FOO); 
		
	}

	@Test
	public void testHeight() {
		assertEquals(-1, emptyTree.height());
		assertEquals(0, oneNodeTree.height());
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		tree.add(0);
		tree.add(-1);
		tree.add(-2);
		tree.add(1);
		tree.add(2);
		tree.add(10);	
		tree.add(12);
		tree.add(11);
		tree.add(13);
		tree.add(-5);
		tree.add(-3);
		
		tree.add(-4);
		assertEquals(5,tree.height());
		assertEquals(13,tree.getMaximum().intValue());
		assertEquals(-5,tree.getMinimum().intValue());
	}
	
	@Test
	public void testPreorderIterator() {
		Iterator<String> i = oneNodeTree.preorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}

	@Test
	public void testInorderIterator() {
		Iterator<String> i = oneNodeTree.inorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> i = emptyTree.postorderIterator();
		assertFalse(i.hasNext());
	}
	
	@Test
	public void testEquals() {
		BSTInterface<String> tree = new BinarySearchTree<String>();
		assertFalse(oneNodeTree.equals(tree));
		tree.add(new String("foo"));
		assertTrue(oneNodeTree.equals(tree));
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
			
		tree1.add(0);
		tree1.add(-1);
		tree1.add(-2);
		tree1.add(1);
		tree1.add(2);
		tree1.add(10);	
		tree1.add(12);
		tree1.add(11);
		tree1.add(13);
		tree1.add(-5);
		tree1.add(-3);

		BinarySearchTree<Integer> tree2=new BinarySearchTree<Integer>();
		tree2.add(0);
		tree2.add(-1);
		tree2.add(-2);
		tree2.add(1);
		tree2.add(2);
		tree2.add(10);	
		tree2.add(12);
		tree2.add(11);
		tree2.add(13);
		tree2.add(-5);
		tree2.add(-3);
		assertTrue(tree1.equals(tree2));
		
		
		
		
	}
	
	@Test
	public void testSameValues() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.add(1);
		emptyTree.add(2);
		
		tree.add(2);
		tree.add(1);
		
		assertTrue(emptyTree.sameValues(tree));
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		
		tree1.add(0);
		tree1.add(-1);
		tree1.add(-2);
		tree1.add(1);
		tree1.add(2);
		tree1.add(10);	
		tree1.add(12);
		tree1.add(11);
		tree1.add(13);
		tree1.add(-5);
		tree1.add(-3);

		BinarySearchTree<Integer> tree2=new BinarySearchTree<Integer>();
		
		tree2.add(0);
		tree2.add(-1);
		tree2.add(-2);
		tree2.add(10000);
		tree2.add(2000);
		tree2.add(10);	
		tree2.add(12);
		tree2.add(11);
		tree2.add(13);
		tree2.add(-5);
		tree2.add(-3);
assertFalse(tree2.sameValues(tree1));
	}
	
	@Test 
	public void testIsBalanced() {
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(1);
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(2);
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(3);
		emptyTree.add(4);
		emptyTree.add(5);
		assertFalse(emptyTree.isBalanced());
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		
		tree1.add(0);
		tree1.add(-1);
		//tree1.add(-2);
		tree1.add(1);
		tree1.add(2);
		tree1.add(-2);
		tree1.add(3);
		assertFalse(tree1.isBalanced());


	}
	
	@Test 
	public void testBalance() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		assertTrue(emptyTree.isBalanced());
BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		
		tree1.add(0);
		tree1.add(-1);
		//tree1.add(-2);
		tree1.add(1);
		tree1.add(2);
		tree1.add(-2);
		tree1.add(3);
		assertFalse(tree1.isBalanced());
		tree1.balance();
		assertTrue(tree1.isBalanced());
	}
}
