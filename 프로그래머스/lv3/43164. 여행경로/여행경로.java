import java.util.*;
class Solution {
    
    static Map<String, Integer> map;
    static ArrayList<ArrayList<Integer>> al;
    static boolean[][] visit;
    static ArrayList<String> ans;
    static String[] airport, result;
    static int size;
    
    public String[] solution(String[][] tickets) {

               map = new HashMap<>();
        size = tickets.length;
        int n=0;

        al = new ArrayList<>();
        for(int i=0;i<size;i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], n++);
                al.add(map.get(tickets[i][0]), new ArrayList<Integer>());
            }
            if(!map.containsKey(tickets[i][1])){
                map.put(tickets[i][1], n++);
                al.add(map.get(tickets[i][1]), new ArrayList<Integer>());
            }
            al.get(map.get(tickets[i][0])).add(map.get(tickets[i][1]));
        }

        airport = new String[n];
        for(String key: map.keySet()){
            airport[map.get(key)] = key;
        }

       visit= new boolean[al.size()][];
        for(int i=0;i<al.size();i++){
            Collections.sort(al.get(i), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return airport[o1].compareTo(airport[o2]);
                }
            });
            visit[i] = new boolean[al.get(i).size()];
        }

        System.out.println(al);

        ans= new ArrayList<>();
        dfs(map.get("ICN"),0);

        //System.out.println(ans);

        System.out.println(Arrays.toString(result));
        return result;
    }
    
    private static boolean dfs(int now, int n) {

        ans.add(airport[now]);
        //System.out.println(ans);
        if(n==size){
            result = ans.toArray(new String[size+1]);
            return true;
        }
        for(int i=0;i<al.get(now).size();i++){
            if(!visit[now][i]){
                visit[now][i]=true;
                boolean re =dfs(al.get(now).get(i),n+1);
                if(re) return true;
                visit[now][i]=false;
            }
        }


        ans.remove(n);
        return false;
    }
}