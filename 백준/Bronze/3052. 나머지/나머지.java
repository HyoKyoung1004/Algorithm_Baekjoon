import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			set.add(scan.nextInt()%42);
		}
		
		System.out.println(set.size());
	}

}