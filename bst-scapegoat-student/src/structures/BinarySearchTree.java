package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root;
	
	

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	public boolean contains(T t) {
		// TODO
		if(t==null)
			throw new NullPointerException();
		return recContains(t, root);
		/*BSTNode<T> curr=root;
		boolean found=false;
		while(root!=null){
			int res=t.compareTo(curr.getData());
			if(res==0)
			{
				found=true;
				break;
			}
			else if(res>0)
				curr=curr.getRight();
			else if(res<0)
				curr=curr.getLeft();
		}
		//int res=t.compareTo(arg0)
		return found;
	*/
		}
	
	protected boolean recContains(T element, BSTNode<T> tree){
		if(element==null)
			throw new NullPointerException();
		if(tree==null)
			return false;
		else if(element.compareTo(tree.getData())<0)
			return recContains(element, tree.getLeft());
		else if(element.compareTo(tree.getData())>0)
			return recContains(element, tree.getRight());
		else
			return true;
	}

	public boolean remove(T t) {
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	protected BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	protected T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	protected BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}

	public T get(T t) {
		// TODO
		if(t==null)
			throw new NullPointerException();
		T elem=null;
		BSTNode<T> curr=root;
		while(curr!=null){
			int res=t.compareTo(curr.getData());
			if(res==0)
			{
				elem=curr.getData();
				break;
			}
			else if(res>0)
				curr=curr.getRight();
			else if(res<0)
				curr=curr.getLeft();
			
		}
		return elem;
	}

	public void add(T t) {
		root= addToSubtree(t, root);
	}

	protected BSTNode<T> addToSubtree(T t, BSTNode<T> node) {
		if(t==null)
			throw new NullPointerException();
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		if (t.compareTo(node.getData()) <= 0) {
			node.setLeft(addToSubtree(t, node.getLeft()));
		} else {
			node.setRight(addToSubtree(t, node.getRight()));
		}
		return node;
	}

	@Override
	public T getMinimum() {
		// TODO
		BSTNode<T> curr=root;
		if(this.isEmpty())
			return null;
		if(curr.getLeft()==null)
			return curr.getData();
	    while(curr.getLeft()!=null){
	    	curr=curr.getLeft();
	    }
	    return curr.getData();
	}

	@Override
	public T getMaximum() {
		// TODO
		if(this.isEmpty())
			return null;
		BSTNode<T> curr=root;
		if(curr.getRight()==null)
			return curr.getData();
	    while(curr.getRight()!=null){
	    	curr=curr.getRight();
	    }
	    return curr.getData();
	}
		//return null;


	@Override
	public int height() {
		// TODO
		return heightHelper(root);
	}
	private int heightHelper(BSTNode<T> tree){
	if(tree==null){
		return -1;
	}
	else
	{
		return 1+Math.max(heightHelper(tree.getLeft()),heightHelper(tree.getRight()));//, b)heightHelper(tree.getLeft())+heightHelper(tree.getRight();//, heightHelper(tree.getRight()));
	}
	}
	@Override
	public Iterator<T> preorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue,root);
		return queue.iterator();
		//return null;
	}
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			
			preorderTraverse(queue, node.getRight());
		}
	}

	

	@Override
	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}
	
	protected void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			 inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue=new LinkedList<T>();
		postorderTraverse(queue,root);
		return queue.iterator();
		//return null;
	}
	private void postorderTraverse(Queue<T> queue,BSTNode<T> node){
		if(node!=null){
			postorderTraverse(queue,node.getLeft());
			postorderTraverse(queue,node.getRight());
			queue.add(node.getData());
		}
	}
	
	protected void equalsHelper(Queue<BSTNode<T>> queue,BSTNode<T> root){
		Queue<BSTNode<T>> theQueue=new LinkedList<BSTNode<T>>();
		if(root!=null){
		theQueue.add(root);
		while(!theQueue.isEmpty()){
			BSTNode<T> node=theQueue.remove();
			queue.add(node);
			if(node.getLeft()!=null){
				theQueue.add(node.getLeft());
			}
			if(node.getRight()!=null){
				theQueue.add(node.getRight());
			}
		}
		}
	}

	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		boolean isEqual=true;
		if(other==null)
			throw new NullPointerException();
		Queue<BSTNode<T>> thisQueue=new LinkedList<BSTNode<T>>();
		Queue<BSTNode<T>> otherQueue=new LinkedList<BSTNode<T>>();
		equalsHelper(thisQueue,this.root);
		equalsHelper(otherQueue,other.getRoot());
		if(thisQueue.size()!=otherQueue.size()){
			isEqual=false;
		}
		else{
		while(!thisQueue.isEmpty()){
			if(!thisQueue.remove().getData().equals(otherQueue.remove().getData()))
					isEqual=false;
		}
		return isEqual;
		}
		
		
		/*T[] thisarray=(T[]) new Comparable[this.size()];
		T[] otherarray=(T[]) new Comparable[other.size()];
		Iterator<T> iterator1=this.inorderIterator();
		Iterator<T> iterator2=other.inorderIterator();
		int i=0;
		int j=0;
		while(iterator1.hasNext()){
			thisarray[i]=iterator1.next();
			i++;
		}
		while(iterator2.hasNext()){
			otherarray[j]=iterator2.next();
			j++;
		}
		if(i!=j){
			isEqual=false;
		}
		else{
		for(int a=0;a<thisarray.length;a++){
			if(!thisarray[a].equals(otherarray[a])){
				isEqual=false;
				break;
			}
		}
		}*/
		return isEqual;
	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		boolean isEqual=true;
		if(other==null)
			throw new NullPointerException();
		T[] thisarray=(T[]) new Comparable[this.size()];
		T[] otherarray=(T[]) new Comparable[other.size()];
		Iterator<T> iterator1=this.inorderIterator();
		Iterator<T> iterator2=other.inorderIterator();
		int i=0;
		int j=0;
		while(iterator1.hasNext()){
			thisarray[i]=iterator1.next();
			i++;
		}
		while(iterator2.hasNext()){
			otherarray[j]=iterator2.next();
			j++;
		}
		if(i!=j){
			isEqual=false;
		}
		else{
	//nt ct=0;
		for(int a=0;a<thisarray.length;a++){
			if(thisarray[a].compareTo(otherarray[a])!=0){
				isEqual=false;
			break;
			}
		}
			//for(int b=0;b<otherarray.length;b++){
				//if(thisarray[a].equals(otherarray[b]))
					//ct++;
			}
			//}
		//if(ct==otherarray.length)
			//isEqual=true;

		return isEqual;
		
	//	return false;
	}

	@Override
	public boolean isBalanced() {
		// TODO
		boolean bal=false;
		if(this.isEmpty())
			return true;
		int h=this.height();
		double a=Math.pow(2.0,(double)(h));
		double b=Math.pow(2.0, (double)(h)+1);
		if(this.size()>=a&&this.size()<b)
			bal=true;
		return bal;
	}

	@Override
	public void balance() {
		// TODO	        
		if(!this.isBalanced()){
			//BinarySearchTree<T> bal=new BinarySearchTree<T>();
			T[] barray=(T[]) new Comparable[this.size()];
			Iterator<T> iterator=this.inorderIterator();
			int i=0;
			while(iterator.hasNext()){
				barray[i]=iterator.next();
				i++;
			}
			for(int j=0;j<barray.length;j++){
				this.remove(barray[j]);
			}
			balanceHelper(barray, this, 0, barray.length-1);
			//this=bal;
		}
		
	}

	protected void balanceHelper(T[] anarray, BinarySearchTree<T> tree, int lower, int upper){
		if(lower==upper){
			tree.add(anarray[lower]);
		}	
		else if(lower+1==upper){
				tree.add(anarray[lower]);
				tree.add(anarray[upper]);
			
		}
		else{
			int mid=(lower+upper)/2;
			tree.add(anarray[mid]);
			balanceHelper(anarray, tree,lower,mid-1);
			balanceHelper(anarray, tree, mid+1, upper);
		}
	}
	@Override
	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// DO NOT MODIFY
		// see project description for explanation

		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}
}