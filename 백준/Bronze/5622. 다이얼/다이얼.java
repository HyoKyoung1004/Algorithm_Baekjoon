
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		//char dial[] = new char[input.length()];

		char dialAlpha;
		int result = 0;
		for (int i = 0; i < input.length(); i++) {
			//dial[i] = input.charAt(i);
			dialAlpha = input.charAt(i);

			switch (dialAlpha) {
			case 'A':
			case 'B':
			case 'C':
				result += 3;
				break;
			case 'D':
			case 'E':
			case 'F':
				result += 4;
				break;
			case 'G':
			case 'H':
			case 'I':
				result += 5;
				break;
			case 'J':
			case 'K':
			case 'L':
				result += 6;
				break;
			case 'M':
			case 'N':
			case 'O':
				result += 7;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				result += 8;
				break;
			case 'T':
			case 'U':
			case 'V':
				result += 9;
				break;
			case 'X':
			case 'W':
			case 'Y':
			case 'Z':
				result += 10;
				break;
			}

		}
		System.out.println(result);

	}

}
