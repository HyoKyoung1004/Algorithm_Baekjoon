import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=str.length();i++){

            for(int j=0;j<str.length()-i;j++){
                String s = str.substring(j,j+i+1);
                //System.out.println(s);
                set.add(s);
            }
        }

        //System.out.println(set);
        System.out.println(set.size());
    }
}
