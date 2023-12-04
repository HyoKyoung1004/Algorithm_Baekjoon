import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String,Integer> reportCount =new HashMap<>();
        Map<String,Set<String>> reportName =new HashMap<>();
        Map<String,Integer> mailCount =new HashMap<>();

        for(int i=0;i<id_list.length;i++){
             reportCount.put(id_list[i],0);
             mailCount.put(id_list[i],0);
            reportName.put(id_list[i], new HashSet<String>());
        }
        
        for(int i=0;i<report.length;i++){
            String[] name = report[i].split(" ");
            
            //내가 이미 같은 사람을 신고했으면 신고횟수가 1회라는 거잖아.
            if(reportName.get(name[0]).contains(name[1])) continue;
            reportName.get(name[0]).add(name[1]); 
            reportCount.put(name[1], reportCount.get(name[1])+1);
        }
        // System.out.println(reportCount);
        // System.out.println(reportName);

        int[] answer = new int[id_list.length];

        for(int i=0;i<id_list.length;i++){
            int sum=0;
            for(String str : reportName.get(id_list[i])){
                if(reportCount.get(str)>=k) sum++;
            }
            answer[i]= sum;
        }
        
        
        return answer;
    }
}