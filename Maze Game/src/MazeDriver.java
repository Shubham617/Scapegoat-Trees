import java.util.Scanner;

public class MazeDriver {

public static void main(String[] args){

	System.out.println("Welcome to the MazeGame");
	System.out.println("The Objective of the game is to reach the finish point with the smallest path sum possible");
	System.out.println("You can move up, down or right");
	System.out.println();
	System.out.println();
	System.out.println();
	char c='y';
	Solver solve=new Solver();
	//while(c=='y'){
	int c1=0;
	int c2=0;
	int currSum=0;
	Display d=new Display();
	int[][] arr=new int[6][6];
	arr=d.genMaze(6, 6);
	while(c=='y'){
		System.out.println();
		System.out.println();
		System.out.println();
		
	
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[0].length;j++){
			if(i==c1 && j==c2){
				currSum+=arr[i][j];
				System.out.print(arr[i][j] + "  You are here " + "|  ");
			}
			else if(i==arr.length-1 && j==arr[0].length-1){
				System.out.print(arr[i][j] + "  Finish Point " + "|  ");

			}
			else
			System.out.print(arr[i][j] + "               " + "|  ");
		}
		System.out.println();
	//	System.out.println("___________________________________");
	}
	
	System.out.println("Your current sum is: --> " + currSum);
	int flag1=0;
	if(c1==arr.length-1 && c2==arr[0].length-1){
//	System.out.println("EXEC");
		int min=solve.CalMin(arr);
	//	System.out.println(min);
		if(currSum<=min){
			System.out.println("The least path sum possible was --> " + min );
			System.out.println("Congrats! You did it!");
		}
		else if(currSum>min){
			System.out.println("The least path sum possible was --> " + min );
			int[] solved=solve.retList();
			System.out.println("The path to obtain it was: --");
			for(int k=0;k<solved.length;k++){
				if(k==solved.length-1){
					System.out.println(solved[k] + "   " );
				}
				else {
				System.out.print(solved[k] + "  +  ");
				}
				}
			System.out.println();
			System.out.println("Sorry! Better luck next time!");
		}
		
		System.out.println("Would you like to play again(y/n)??");
		Scanner s=new Scanner(System.in);
		String v=s.next();
		if(v.equals("y")){
			arr=d.genMaze(6, 6);
			currSum=0;
			c='y';
			flag1=1;
			c1=0;
			c2=0;
			System.out.println("-------------- NEW GAME ----------------");
		}
		else if(!v.equals("y")) {
		c='n';
		break;
		}
	}
	
	char h='y';
	while(h=='y' && flag1==0){
		System.out.println("Would you like to move up, down or right?    ");
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		
		if(d.isValid(s, c1, c2, arr)){
			h='n';
			int[] move=new int[2];
			move=d.next(s, c1, c2);
			c1=move[0];
			c2=move[1];
			//System.out.println("c1" + c1);
			//System.out.println("c2" + c2);
		}
		else{
			System.out.println("Not a valid move ..... Try Again");
		}
		
	}
	
	
}
}
}
