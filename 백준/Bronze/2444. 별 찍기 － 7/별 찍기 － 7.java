import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int k = i; k<n-1;k++)
				System.out.print(" ");
			
			for(int k=0 ; k<2*i+1 ;k++)
				System.out.print("*");
			
			System.out.println();
		}
		
		for(int i=1;i<n;i++) {
			
			for(int k = 0; k<i;k++)
				System.out.print(" ");
			
			for(int k=0 ; k<(n-i)*2-1 ;k++)
				System.out.print("*");

			System.out.println();
		}
		
		
	
	}

}