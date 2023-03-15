import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int setNum = Integer.parseInt(str.split(" ")[0]);
        int strNum = Integer.parseInt(str.split(" ")[1]);

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<setNum;i++){
            String setstr = scan.nextLine();
            set.add(setstr);
        }
        int count=0;
        for(int i=0;i<strNum;i++){
            String setstr = scan.nextLine();
            if(set.contains(setstr))count++;
        }

        System.out.println(count);

    }
}