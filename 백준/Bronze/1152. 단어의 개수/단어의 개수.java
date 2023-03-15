import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine().trim();
		sc.close();
		
		if(input == null || input.length()==0)
			System.out.println(0);
		else {
		String[] sarry = input.split(" ");
		
		System.out.println(sarry.length);
		}
	}

}
