/*
The two-pointer technique, also known as the "pointer collision" or "slow and fast pointers" approach, is a popular algorithmic strategy used to solve problems involving arrays or linked lists. It involves using two pointers that traverse the array or list at different speeds, allowing us to efficiently search, sort, or manipulate elements.

Simple Explanation:
Imagine you have two pointers, one starting at the beginning of the array or list (the "slow" pointer) and the other starting at the end (the "fast" pointer). These pointers move through the data structure according to the problem requirements.

Example:
Let's understand the two-pointer approach with an example:

Problem: Given a sorted array of integers, find two numbers that sum up to a specific target value.

In this example, the twoSum method searches for two numbers in the array that sum up to the target value. 
We use two pointers, left and right, initialized to the beginning and end of the array, respectively. 
We move the pointers towards each other until they meet, checking the sum of the elements pointed to by left and right. 
If the sum is equal to the target, we return the indices of the two numbers. 
If the sum is less than the target, we move the left pointer forward to increase the sum, and if the sum is greater, we move the right pointer backward.


*/

public class TwoPointerExample {
    public int[] twoSum(int[] nums, int target) {
        int left = 0; // Pointer starting from the beginning
        int right = nums.length - 1; // Pointer starting from the end
        
        while (left < right) { // Continue until the two pointers meet
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return indices of the two numbers
            } else if (sum < target) {
                left++; // Move the left pointer forward
            } else {
                right--; // Move the right pointer backward
            }
        }
        
        return new int[]{-1, -1}; // If no such pair exists, return [-1, -1]
    }
    
    public static void main(String[] args) {
        TwoPointerExample example = new TwoPointerExample();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = example.twoSum(nums, target);
        System.out.println("Indices of the two numbers: [" + result[0] + ", " + result[1] + "]");
    }
}