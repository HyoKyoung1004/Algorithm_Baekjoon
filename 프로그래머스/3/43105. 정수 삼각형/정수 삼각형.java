class Solution {
    public int solution(int[][] triangle) {
        
        int leng = triangle.length;
        int[][] dp = new int[leng][];
        dp[0] = new int[]{triangle[0][0]};
        

        for(int i=1;i<leng;i++){
            int size = triangle[i].length;
            dp[i] = new int[size];
            for(int j=0;j<size;j++){
                if(j==0) dp[i][j] = triangle[i][j] + dp[i-1][j];
                else if(i==j) dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        int answer = 0;        
        for(int i=0;i<dp[leng-1].length;i++){
            if(dp[leng-1][i] > answer) answer = dp[leng-1][i];
        }
        return answer;
    }
}