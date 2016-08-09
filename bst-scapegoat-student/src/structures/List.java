package structures;

public class List<T> {
	LLNode<T> head;
	LLNode<T> tail;
	public void add(T element){
		LLNode<T> newNode=new LLNode<T>(element);
/*		if(tail==null){
			head=newNode;
			tail=newNode;
		}
		else{
			tail.setLink(newNode);
			tail=newNode;
	}*/
	newNode.setLink(head);
	head=newNode;
	}


}
