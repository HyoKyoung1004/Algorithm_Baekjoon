import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan= new Scanner(System.in);
		int n = scan.nextInt();
		
		HashMap<Integer,Integer> map= new HashMap<>();
		
		for(int i=0;i<n;i++) {
			int tmp = scan.nextInt();
			map.put(tmp,map.getOrDefault(tmp, 0)+1);
		}
		
		
		int v= scan.nextInt();
		System.out.println(map.getOrDefault(v, 0));
		
		
	}

}