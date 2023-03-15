import java.util.*;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer> cards = new ArrayList<>();
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static int length;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N= scan.nextInt();
        M= scan.nextInt();

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            int tmp = scan.nextInt();
            if(!set.contains(tmp)){
                set.add(tmp);
                cards.add(tmp);
            }
        }
        result = new int[M];
        Collections.sort(cards);
        length = cards.size();
        combination(0,0);

        System.out.println(sb);
    }

    private static void combination(int cnt, int start) {

        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<length;i++){
            result[cnt] = cards.get(i);
            combination(cnt+1,i);
        }
    }
}