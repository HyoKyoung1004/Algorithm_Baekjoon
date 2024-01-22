import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> list;
    static int last=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0] ==o2[0]) return o1[1] -o2[1];
                        return o1[0] -o2[0];
                    }
                }
        );

        for(int n=0;n<N;n++){
            search(arr[n][0],arr[n][1]);
//            System.out.println(list);
        }
        System.out.println(list.size());

    }
    static void search(int s, int e){

        int left = 0;
        int right = list.size()-1;
        int maxIdx =-1;
        while(left<=right){

            int mid =(left+right)/2;
            if(list.get(mid) <=s){
                left = mid+1;
                maxIdx = mid;
            }else{
                right=mid-1;
            }
        }
        //넣을 자리가 없음, 제일 뒤에 넣어
        if(maxIdx==-1){
//            list.add(e);
        }else{
            list.remove(maxIdx);
//            list.set(maxIdx,e);
//            Collections.sort(list);
        }
        searchIndex(e);

    }
    static void searchIndex(int target){
        int left = 0;
        int right = list.size()-1;
        int maxIdx =-1;
        while(left<=right){

            int mid =(left+right)/2;
            if(list.get(mid) <=target){
                left = mid+1;
                maxIdx = mid;
            }else{
                right=mid-1;
            }
        }
        if(maxIdx==-1){
            list.add(0,target);
        }else{
            list.add(maxIdx+1, target);
        }
//        System.out.println(list);
    }


}