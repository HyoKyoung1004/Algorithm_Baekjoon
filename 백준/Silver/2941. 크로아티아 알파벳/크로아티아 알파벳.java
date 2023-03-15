
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		
		for (int i = 0; i < str.length() ; i++) {

			if (str.indexOf("c=") > -1) {
				str = str.replace("c=", "0");
			}
			if (str.indexOf("c-") > -1) {
				str = str.replace("c-", "0");
			}
			if (str.indexOf("dz=") > -1) {
				str = str.replace("dz=", "0");
			}
			if (str.indexOf("d-") > -1) {
				str = str.replace("d-", "0");
			}
			if (str.indexOf("lj") > -1) {
				str = str.replace("lj", "0");
			}
			if (str.indexOf("nj") > -1) {
				str = str.replace("nj", "0");
			}
			if (str.indexOf("s=") > -1) {
				str = str.replace("s=", "0");
			}
			if (str.indexOf("z=") > -1) {
				str = str.replace("z=", "0");
			}
		}
		
		System.out.println(str.length());
		

	}

}
