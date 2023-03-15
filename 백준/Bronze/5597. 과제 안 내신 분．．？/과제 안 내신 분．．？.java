import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		boolean[] arr = new boolean[31];
		
		for(int i=0;i<28;i++) {
			arr[scan.nextInt()]=true;
		}
		
		for(int i=1;i<31;i++) {
			if(arr[i]==false)
				System.out.println(i);
		}
		
		
	}

}