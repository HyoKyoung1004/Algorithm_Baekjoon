import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		long[] arr = new long[101];
		arr[1]=arr[2]=arr[3] = 1;
		
		for(int i=4;i<=100;i++) {
			arr[i] = arr[i-2]+arr[i-3];
		}
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println(arr[scan.nextInt()]);
		}
	}

}
