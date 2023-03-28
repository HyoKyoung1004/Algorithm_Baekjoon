import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] arr = new String[251];
		arr[0]="1";
		arr[1]="1";
		arr[2]="3";
		
		for(int i=3;i<=250;i++) {
			BigInteger bigNumber1 = new BigInteger(arr[i-1]);
			BigInteger bigNumber2 = new BigInteger(arr[i-2]);
			BigInteger bigNumber3 = bigNumber1.add(bigNumber2.multiply(new BigInteger("2")));
			arr[i] = bigNumber3.toString();
		}
		while(scan.hasNext()) {
			
			int n= scan.nextInt();
			System.out.println(arr[n]);
		}
	}

}