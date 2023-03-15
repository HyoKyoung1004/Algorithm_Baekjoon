import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[1001];
		
		
		int max =0;
		int maxIndex=0;
		for(int i=0;i<n;i++) {
			int index = scan.nextInt();
			int value = scan.nextInt();
			arr[index] = value;
			
			if(max<value) {
				max= value;
				maxIndex = index;
			}
			
		}
		
		int sum=0;
		int previous = 0;
		for(int i=1;i<=maxIndex;i++) {
			previous = Math.max(arr[i], previous);
			sum+=previous;
		}
		
		previous = 0;
		for(int i=1000;i>maxIndex;i--) {
			previous = Math.max(arr[i], previous);
			sum+=previous;
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		
		
	}

}