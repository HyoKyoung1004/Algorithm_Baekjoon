import java.util.Scanner;

public class Main {

	static int N, col[], answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueen(1);
		System.out.println(answer);
		
	}
	
	
	private static void setQueen(int rowNo) { //rowNo : 놓으려고 하는 퀸의 행번호
		
		if(!isAvailable( rowNo-1)) return; //진전까지의 행이 유망한지, 내 자리에서 파생시키기 전에 가능했는지 확인
		
		
		//기저조건
		if(rowNo>N) {
			answer+=1;
			return;
		}
		
		
		for(int c=1; c<=N;c++) {
			col[rowNo] = c;
			setQueen(rowNo+1);
		}
	}
	


	private static boolean isAvailable(int rowNo) {
		
		for(int k=1;k<rowNo;k++) {
			if(col[k] == col[rowNo] || Math.abs(col[k] - col[rowNo]) == rowNo-k) return false; //유망하지 않음  
		}
		
		
		
		return true;
	}

}