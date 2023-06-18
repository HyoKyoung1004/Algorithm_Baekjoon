import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=10;tc++){

            int N = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M =  Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){

                char c = st.nextToken().charAt(0);

                if(c=='I'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int k=0;k<y;k++){
                        list.add(x+k, Integer.parseInt(st.nextToken()));
                    }
                }else if(c=='D'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int k=0;k<y;k++){
                        list.remove(x);
                    }
                }else if(c=='A'){
                    int y = Integer.parseInt(st.nextToken());
                    for(int k=0;k<y;k++){
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            sb.append("#"+tc+" ");
            for(int i=0;i<10;i++){
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}