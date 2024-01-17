import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        
        
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        for(int i=0;i<skill.length;i++){
            int r1 = skill[i][1];
            
            if(skill[i][0]==1){
                sum[skill[i][1]][skill[i][2]] -= skill[i][5];
                sum[skill[i][3]+1][skill[i][4]+1] -= skill[i][5];
                sum[skill[i][1]][skill[i][4]+1] += skill[i][5];
                sum[skill[i][3]+1][skill[i][2]] += skill[i][5];
            }else{
                sum[skill[i][1]][skill[i][2]] += skill[i][5];
                sum[skill[i][3]+1][skill[i][4]+1] += skill[i][5];
                sum[skill[i][1]][skill[i][4]+1] -= skill[i][5];
                sum[skill[i][3]+1][skill[i][2]] -= skill[i][5];
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(i==0 && j==0) continue;
                else if(i==0) sum[i][j] += sum[i][j-1];
                else if(j==0) sum[i][j] += sum[i-1][j];
                else sum[i][j] =  sum[i][j] + sum[i-1][j] + sum[i][j-1]- sum[i-1][j-1];
            }
        }
        
        
        
        // System.out.println(Arrays.deepToString(sum));

        
        int answer = 0;
        
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j] + sum[i][j] >0) answer++;
            }
        }
        
        
            
        return answer;
    }
}