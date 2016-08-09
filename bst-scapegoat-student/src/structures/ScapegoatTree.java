package structures;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	//private BSTNode<T> root;
	private int upperBound=0;
	//public ScapegoatTree(){
		//root=null;
		//upperBound=0;
	//}
	
	/**
	 * Adds an element to the tree.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule. 
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after adding, or you will receive no credit. 
	 * See the project writeup for details.
	 * 
	 * @param element
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(T element) {
		// TODO		
		if(element==null)
			throw new NullPointerException();
		upperBound++;
		root=this.addToSubtree(element,root);
		int h=this.height();
		double q=(Math.log10((double)(upperBound)))/(Math.log10(1.50));
		//System.out.println(q);
		if((double)h>q){
			System.out.println("ENCOUNTER");
			List<T> list=new List<T>();
			BSTNode<T> curr=root;
			while(curr!=null){
				list.add(curr.getData());
				int res=element.compareTo(curr.getData());
				if(res==0){
					break;
				}
				else if(res<0){
					curr=curr.getLeft();
				}
				else if(res>0){
					curr=curr.getRight();
				}
			}
			//LLNode<T> snode=list.head;
			//while(snode.getLink()!=null){
				//System.out.println(retRef(snode.getInfo()).getData());
				//System.out.println(subtreeSize(retRef(snode.getInfo())));
				//System.out.println((double)(this.subtreeSize(retRef(snode.getInfo())))/(double)(this.subtreeSize(retRef(snode.getLink().getInfo()))));
				//snode=snode.getLink();
			//}
		LLNode<T> node=list.head;
		BSTNode<T> w=null;
		BSTNode<T> prev=null;
		while(node!=null && node.getLink()!=null){
			if((double)(this.subtreeSize(retRef(node.getInfo())))/(double)(this.subtreeSize(retRef(node.getLink().getInfo())))>(0.667)){
				if(node.getLink().getLink()!=null){
				prev=retRef(node.getLink().getLink().getInfo());
				}
				w=retRef(node.getLink().getInfo());
				break;
			}
			else{
				//prev=node;
				node=node.getLink();
			}//break;
		}
		System.out.println(w.getData()+"*");
		//System.out.println(prev.getInfo()+"**");
			Queue<T> queue=new LinkedList<T>();
			inorderTraverse(queue,w);
			BinarySearchTree<T> tree=new BinarySearchTree<T>();
			while(!queue.isEmpty()){
				tree.add(queue.remove());
			}
			
			tree.balance();
			if(prev!=null){
				//BSTNode<T> parent=retRef(prev.getInfo());
				BSTNode<T> theRoot=tree.getRoot();
				int a=theRoot.getData().compareTo(prev.getData());
				if(a<=0){
					prev.setLeft(theRoot);	
				}
				if(a>0)
					prev.setRight(theRoot);
			}
			else if(prev==null){
				this.root=tree.getRoot();//getRoot();
			}
		}
		
		}
	
	
	public BSTNode<T> retRef(T t) {
		// TODO
	if(t==null)
		return null;
		BSTNode<T> curr=root;
		while(root!=null){
			int res=t.compareTo(curr.getData());
			if(res==0)
			{
				return curr;
			}
			else if(res>0)
				curr=curr.getRight();
			else if(res<0)
				curr=curr.getLeft();
		}
		//int res=t.compareTo(arg0)
		return null;
	}
	
	/**
	 * Attempts to remove one copy of an element from the tree, returning true
	 * if and only if such a copy was found and removed.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule.
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after removing, or you will receive no credit. 
	 * See the project writeup for details.

	 * @param element
	 * @return true if and only if an element removed
	 * @throws NullPointerException if element is null
	 */
	@Override
	public boolean remove(T element) {
		// TODO
		if(element==null)
			throw new NullPointerException();
		boolean done=contains(element);
		if(done){
			root=this.removeFromSubtree(root, element);
			//upperBound--;
		
		if((double)upperBound>2.0*(double)(this.size())){
			System.out.println("********");
			/*T[] barray=(T[]) new Comparable[this.size()];
			Iterator<T> iter=this.inorderIterator();
			int i=0;
			while(iter.hasNext()){
				barray[i]=iter.next();
				i++;
			}
			for(int j=0;j<barray.length;j++){
				root=this.removeFromSubtree(root, barray[j]);
				}
			this.balanceHelper(barray, this, 0, barray.length-1);
			*///
			this.balance();
			upperBound=this.size();
		}
		}
		return done;
	}

}
