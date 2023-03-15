import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m=scan.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
		}
		
		
		
		//CombinationRecur(0,0,0);
		combinationFor();
		System.out.println(max);
		
	}

	private static void combinationFor() {
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int sum = arr[i]+arr[j]+arr[k];
					if(sum<=m && max<sum) {
						max =sum;
					}
				}
			}
		}
		
	}


	
	

}