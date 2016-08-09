import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solver {

	ArrayList<Integer> save=new ArrayList<Integer>();
	
	
	public int CalMin(int[][] arr){
	
		Queue<ArrayList<Integer>> q=new LinkedList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		
		int fin1=arr.length-1;
		int fin2=arr[0].length-1;
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(arr[0][0]);
		list.add(0);
		list.add(0);
		
		q.add(list);
		
		while(!q.isEmpty()){
			ArrayList<Integer> l=q.remove();
			int n=l.remove(l.size()-1);
			int m=l.remove(l.size()-1);
			
	//		int u1=m-1;
	//		int u2=n;
					
			int r1=m;
			int r2=n+1;
			
			int d1=m+1;
			int d2=n;
			
			
			if(m==fin1 && n==fin2){
				res.add(l);
			}
			else
			{
	/*			if(u1>=0 && u1<fin1+1 && u2>=0 && u2<fin2+1){
				l.add(arr[u1][u2]);
				l.add(u1);
				l.add(u2);
				q.add(new ArrayList<Integer>(l));
				l.remove(l.size()-1);
				l.remove(l.size()-1);
				l.remove(l.size()-1);

				}
	*/			
				if(r1>=0 && r1<fin1+1 && r2>=0 && r2<fin2+1){
					l.add(arr[r1][r2]);
					l.add(r1);
					l.add(r2);
					q.add(new ArrayList<Integer>(l));
					l.remove(l.size()-1);
					l.remove(l.size()-1);
					l.remove(l.size()-1);

				}

				if(d1>=0 && d1<fin1+1 && d2>=0 && d2<fin2+1){
	
					l.add(arr[d1][d2]);
					l.add(d1);
					l.add(d2);
					q.add(new ArrayList<Integer>(l));
					l.remove(l.size()-1);
					l.remove(l.size()-1);
					l.remove(l.size()-1);

				}

				
			}
			
		}
		
		int min=Integer.MAX_VALUE;
		
		
		for(int i=0;i<res.size();i++){
			ArrayList<Integer> cal=res.get(i);
			int sum=0;
			
			for(int j=0;j<cal.size();j++){
				sum+=cal.get(j);
			}
			
			if(sum<min){
				min=sum;
				save=cal;
			}
		}
		
		
		return min;
		
	}
	
	public int[] retList(){
		int[] s=new int[save.size()];
		for(int i=0;i<save.size();i++){
			s[i]=save.get(i);
			
		}
		
		return s;
	}
	
}
