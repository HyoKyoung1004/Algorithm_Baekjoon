import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[] result;
	static boolean[] used; //숫자라서 1번 index부터 사용하려고
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan= new Scanner(System.in);
		n= scan.nextInt();
		m=scan.nextInt();
		result = new int[m];
		used = new boolean[n+1];
		
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int idx) {
		
		
		if(idx==m) {
			for(int tmp : result )
				sb.append(tmp+" ");
			sb.append("\n");
			return;
		}

		for(int i=1;i<=n;i++) {
			
			if(used[i]) continue;
			
			result[idx] =i;
			used[i]=true;
			
			permutation(idx+1);
			used[i]=false;
			
		}
		
		
	}

}