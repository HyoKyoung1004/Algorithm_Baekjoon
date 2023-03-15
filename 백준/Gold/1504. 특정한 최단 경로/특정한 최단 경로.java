import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static int E;

    static ArrayList<Node>[] arr;

    static int minDistance=Integer.MAX_VALUE;
    static int necessary1;
    static int necessary2;

    static boolean[] visited;
    public static int[] distance;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        E= scan.nextInt();
        arr = new ArrayList[N+1];
        distance = new int[N + 1];
        //Arrays.fill(distance, Integer.MAX_VALUE);


        //arr 초기화
        //점 편하게 가져오려고 1부터 한다.
        for(int i=0;i<=N;i++){
            arr[i] = new ArrayList<Node>();
        }

        //점 받아와서 노드로 만들고 저장하자
        for(int i=0;i<E;i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            int d = scan.nextInt();

            arr[s].add(new Node(e,d));
            arr[e].add(new Node(s,d));
        }

        necessary1 = scan.nextInt();
        necessary2 = scan.nextInt();

        //시작점 -> 필수1 -> 필수 2 ->도착
        boolean flag = true;

        int case1 = 0;

        int case11 = dijstra(1, necessary1);
        int case12 = dijstra(necessary1, necessary2);
        int case13 = dijstra(necessary2, N);

        if (case11 != -1 && case12 != -1 && case13 != -1)
            case1 = case11 + case12 + case13;
        else
            flag = false;


        //시작점 -> 필수2 -> 필수 1 ->도착

        int case2 = 0;

        int case21 = dijstra(1, necessary2);

        int case22 = dijstra(necessary2, necessary1);

        int case23 = dijstra(necessary1, N);

        if (case21 != -1 && case22 != -1 && case23 != -1)
            case2 = case21 + case22 + case23;
        else {
            flag = false;
        }

        if(flag) {
            System.out.println(Math.min(case1, case2));
        }else {
            System.out.println(-1);
        }




    }
    static int dijstra(int start, int end) {
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            // 가장 가까운 노드를 꺼내서 확인
            Node node = queue.poll();
            int index = node.getIndex();
            int dis = node.getDistance();

            // 꺼낸 노드 정보가 의미 없음 넘김
            if (distance[index] < dis) {
                continue;
            }

            // 의미가 있는 노드
            // 연결된 간선의 수 만큼 반복
            for (int i = 0; i < arr[index].size(); i++) {
                int cost = distance[index] + arr[index].get(i).getDistance();
                int nIndex = arr[index].get(i).getIndex();

                if (distance[nIndex] > cost) {
                    distance[nIndex] = cost;
                    queue.offer(new Node(nIndex, cost));
                }
            }

        }

        if (distance[end] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[end];

    }


}
class Node implements Comparable {
    private int index;
    private int distance;

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return index + ", " + distance;
    }

    @Override
    public int compareTo(Object o) {
        return this.getDistance() - ((Node)o).getDistance();
    }
}