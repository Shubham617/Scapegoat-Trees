
public class Display {

	int currSum=0;
	
	public int[][] genMaze(int m, int n){
	
		int[][] arr=new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=(int)((Math.random()*8.99)+1.0);
			}
			
		}
		
		return arr;
	}
	
	public int sum(int i, int j, int[][] arr){
		currSum+=arr[i][j];
		return currSum;
	}
	
	public boolean isValid(String s, int a, int b, int[][] arr ){
		int m=-1;
		int n=-1;
		if(s.equals("up")){
			m=a-1;
			n=b;
		}
		
		if(s.equals("down")){
			m=a+1;
			n=b;
		}
		if(s.equals("right")){
			m=a;
			n=b+1;
		}
		
		if(m>=0 && m<arr.length && n>=0 && n<arr[0].length){
			return true;
		}
		else
			return false;
	}
	
	
	public int[] next(String s, int a, int b){
		int[] mov=new int[2];
		        int m=-1;
				int n=-1;
				if(s.equals("up")){
					m=a-1;
					n=b;
				}
				
				if(s.equals("down")){
					m=a+1;
					n=b;
				}
				if(s.equals("right")){
					m=a;
					n=b+1;
				}
				
		mov[0]=m;
		mov[1]=n;
		return mov;
	}
	
}
