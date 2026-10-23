import java.util.Arrays;
class Lec_5_NonAdjacentMaxSum {
    public static void main(String[] args) {
        int[] arr = {2,4,10,1,5,5};
        int[] dp = new int[arr.length + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(NonAdjacentMaxSumTAB2(arr.length - 1, arr));
        // System.out.println(NonAdjacentMaxSumTAB2(arr.length - 1, arr,dp));

        // System.out.println(NonAdjacentMaxSumTAB2(arr.length - 1, arr,dp));

        System.out.println(NonAdjacentMaxSumTAB2(arr.length - 1, arr));

    }
    //                  Recursion
    public static int NonAdjacentMaxSum(int idx, int[] arr){
        if(idx <= 0) return arr[0];
        int pick = arr[idx] + NonAdjacentMaxSum(idx - 2,arr);
        int not_pick = 0 + NonAdjacentMaxSum(idx - 1,arr);

        return Math.max(pick,not_pick);
    }
    //                  Memoization
    public static int NonAdjacentMaxSum(int idx, int[] arr, int[] dp){
        if(idx <= 0) return arr[0];
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + NonAdjacentMaxSum(idx - 2,arr);
        int not_pick = 0 + NonAdjacentMaxSum(idx - 1,arr);

        return dp[idx] = Math.max(pick,not_pick);
    }
    //                  Tabulation
    public static int NonAdjacentMaxSumTAB(int idx, int[] arr, int[] dp){
        dp[0] = arr[0];
        
        for(int i = 1; i <= idx;i++){
            int pick = arr[i];
            if(i - 2 >= 0) pick += dp[i - 2];
            int not_pick = 0 + dp[i - 1];
    
            dp[i] = Math.max(pick,not_pick);
        }
        return dp[idx];
    } 
    //                  Tabulation + Space Optimization
    public static int NonAdjacentMaxSumTAB2(int idx, int[] arr){
        int prev2 = 0;
        int prev = arr[0];

        for(int i = 1; i < idx;i++){
            int pick = arr[i];
            if(i > 1) pick += prev2;
            int not_pick = 0 + prev;
            prev2 = prev;
            int curr = Math.max(pick,not_pick);
            prev = curr;
        }
        return prev;
    }
}
