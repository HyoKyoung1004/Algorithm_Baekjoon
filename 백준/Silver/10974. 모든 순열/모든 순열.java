import java.util.Scanner;

public class Main {

	static int n;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan= new Scanner(System.in);
		n= scan.nextInt();
		numbers = new int[n];
		isSelected = new boolean[n+1];
		
		perm(0);
		
	}
	private static void perm(int count) {
		
		
		if(count==n) {
			for(int k : numbers)
				System.out.print(k+" ");
			System.out.println();
		}
		// TODO Auto-generated method stub
		
		for(int i=1;i<=n;i++) {
			if(isSelected[i]) continue;
				
			numbers[count] =i;
			isSelected[i]=true;
			perm(count+1);
			isSelected[i]=false;
			
		}
	}

}