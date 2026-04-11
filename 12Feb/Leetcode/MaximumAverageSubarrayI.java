package Leetcode;

//643. Maximum Average Subarray I
public class MaximumAverageSubarrayI {
	class Solution {
	    public double findMaxAverage(int[] nums, int k) {
	        int sum=0;
	        for(int i=0; i<k;i++){
	            sum+=nums[i];
	        }
	        double maxavg=(double)sum/k;
	        int start=0;
	        int end=k;
	        while(end<nums.length){
	            sum+=nums[end]-nums[start];
	            maxavg=Math.max(maxavg,(double)sum/k);
	            end+=1;
	            start+=1;
	        }
	        return maxavg;
	    }
	}
}
