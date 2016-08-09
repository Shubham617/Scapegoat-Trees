package structures;

public class LLNode<T> {
	
	private T data;
	private LLNode<T> link;


	public LLNode(T info){
		data=info;
		link=null;
	}
	public T getInfo(){
		return data;
	}
	public void setLink(LLNode<T> lk){
		link=lk;
	}
	public LLNode<T> getLink(){
		return link;
	}
	public void setInfo(T info){
		data=info;
	}

}
