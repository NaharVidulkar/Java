public static int rob(int[] nums) {
        int n = nums.length;
  
        if(n == 1) return nums[0];
  
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for(int i = 0;i < n;i++){
            if(i != 0) arr1[i - 1] = nums[i];
            if(i != n - 1) arr2[i] = nums[i];
        }
        return Math.max(NonAdjacentMaxSumTAB2(arr1),NonAdjacentMaxSumTAB2(arr2));
    }

    public static int NonAdjacentMaxSumTAB2(int[] arr){
        int prev2 = 0;
        int prev = arr[0];
        
        for(int i = 1; i < arr.length;i++){
            int pick = arr[i];
            if(i > 1) pick += prev2;
            int not_pick = prev;

            int curr = Math.max(pick,not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
