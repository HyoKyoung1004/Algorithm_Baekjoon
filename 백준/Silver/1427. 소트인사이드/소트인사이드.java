import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        //선택정렬 사용하여 풀기

        String number = scan.next();
        int[] num = new int[number.length()];

        for(int i=0;i<number.length();i++){
            num[i] = Integer.parseInt(number.substring(i,i+1));
        }

        //내림차순 정렬, 최대값 찾기
        for(int i=0;i<num.length-1;i++){
            int max= num[i];
            int maxIndex =i;
            for(int j=i+1;j<num.length;j++){
                if(max<num[j]){
                    max= num[j];
                    maxIndex=j;
                }
            }
            int tmp= num[i];
            num[i]= num[maxIndex];
            num[maxIndex] = tmp;
        }

        String result="";
        for(int i=0;i<num.length;i++){
           result+= num[i] +"";
       }

        System.out.println(result);



//
//        char[] num =  scan.next().toCharArray();
//       Arrays.sort(num);
//
//       String result ="";
//       for(int i=num.length-1;i>=0;i--){
//           result+= num[i] +"";
//       }
//
//        System.out.println(result);

    


    }
}
