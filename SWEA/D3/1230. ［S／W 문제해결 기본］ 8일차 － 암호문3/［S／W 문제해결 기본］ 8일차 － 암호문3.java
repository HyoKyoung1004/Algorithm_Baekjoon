import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node(int data, Node n){
            this.data = data;
            this.next = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static class LinkedList{

        Node head, tail;
        Node[] nodeArr;
        int nodeCnt;

        public LinkedList() {
            this.head = null;
            this.nodeArr = new Node[5000];
            this.nodeCnt = 0;
        }

        //노드를 생성해서 반환
        Node getNewNode(int data){
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        //idx개 이후에 nums추가
        void insert(int idx, int[] nums){
            int numsIdx=0;
            //맨앞에 추가
            if(idx==0){
                if(head!=null){
                    Node  newNode = getNewNode(nums[0]);
                    newNode.next = head; //원래 head가 내 다음이 됨
                    head = newNode;
                }else{
                    head = getNewNode(nums[0]);
                    tail= head;
                }
                //남은 수들 head뒤에 이어 넣으면 됨
                idx=1;
                numsIdx=1;
            }

            Node cur = head;
            //내가 옮길 위치까지 이동
            for(int i=0;i<idx-1;i++){
                cur = cur.next;
            }

            for(int i=numsIdx;i<nums.length;i++){
                 Node newNode = getNewNode(nums[i]);
                 newNode.next= cur.next;
                 cur.next= newNode;
                 if(cur==tail) tail = newNode;
                 cur = newNode;
            }
           // System.out.println(head);
        }

        void delete(int x, int y){

            //일단 순회해서 x를 알아야해
            Node cur = head;
            for(int i=0;i<x-1;i++){
                cur = cur.next;
            }
            Node startNoce = cur;
            for(int i=0;i<y;i++){
                if(cur.next!=tail)
                    cur.next= cur.next.next;
                else {
                    cur.next = null;
                    tail = cur;
                    break;
                }
            }
           // System.out.println(head);
        }

        //마지막에 붙이는 것
        void add(int data){
            Node last= new Node(data);
            tail.next = last;
            tail = last;
        }

        String print(){

            Node cur = head;
            int i=0;
            String str="";
            while(cur!=tail && i<10 ){
                str+= cur.data+" ";
                cur = cur.next;
                i++;
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=10;tc++){

            int N = Integer.parseInt(br.readLine());
            LinkedList list = new LinkedList();

            int[] arr= new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] =  Integer.parseInt(st.nextToken());
            }

            list.insert(0, arr);

            int M =  Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){

                char c = st.nextToken().charAt(0);

                if(c=='I'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    arr = new int[y];
                    for(int k=0;k<y;k++){
                        arr[k] = Integer.parseInt(st.nextToken());
                    }
                    list.insert(x, arr);

                }else if(c=='D'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                     list.delete(x,y);

                }else if(c=='A'){
                    int y = Integer.parseInt(st.nextToken());
                    for(int k=0;k<y;k++){
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                    //System.out.println(list.head);
                }
            }
            sb.append("#"+tc+" ");
            sb.append(list.print()+"\n");
        }
        System.out.println(sb);
    }
}
