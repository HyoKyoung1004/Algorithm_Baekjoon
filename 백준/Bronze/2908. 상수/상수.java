
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] num = input.split(" ");
		
		
		StringBuffer sb = new StringBuffer(num[0]);
	    String streverseNum1 = sb.reverse().toString();
	    
	    sb = new StringBuffer(num[1]);
	    String streverseNum2 = sb.reverse().toString();
		
		int revernum1 = Integer.parseInt(streverseNum1);
		int revernum2 = Integer.parseInt(streverseNum2);
		
		if(revernum1>revernum2) {
			System.out.println(revernum1);
		}else {
			System.out.println(revernum2);
		}
		
		
		
		
		
	}

}
