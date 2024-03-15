/*
Counting sort is a non-comparison based sorting algorithm that sorts elements based on their frequency in the array. It's particularly efficient when the range of elements in the array is limited. Here's how it works, explained simply with an example:

Counting Frequencies: First, count the frequency of each distinct element in the array.

Calculate Positions: Then, calculate the positions of each element in the sorted array based on their frequencies.

Sorted Array Construction: Finally, construct the sorted array using the calculated positions.

Here's an example to illustrate counting sort:

Consider an array: [4, 2, 2, 8, 3, 3, 1]

Counting Frequencies: Count the frequency of each distinct element in the array.

Frequency of 1: 1
Frequency of 2: 2
Frequency of 3: 2
Frequency of 4: 1
Frequency of 8: 1
Calculate Positions: Calculate the positions of each element in the sorted array based on their frequencies.

Position of 1: 0 (no elements before it)
Position of 2: 1 (1 element before it)
Position of 3: 3 (1 element before 2, and 1 element before 2)
Position of 4: 5 (1 element before 2, 1 element before 2, and 2 elements before 3)
Position of 8: 6 (1 element before 2, 1 element before 2, 2 elements before 3, and 1 element before 4)
Sorted Array Construction: Construct the sorted array using the calculated positions.

Sorted array: [1, 2, 2, 3, 3, 4, 8]
In this example, counting sort efficiently sorts the array in ascending order based on the frequency of elements. It works particularly well when the range of elements is not significantly greater than the number of elements in the array.

Counting sort has a time complexity of O(n + k), where n is the number of elements in the array and k is the range of the elements. 
It's efficient for sorting arrays with a small range of elements but becomes inefficient for larger ranges due to the need for additional memory to store counts.

Counting sort doesn't work for arrays having negative elements in them.

*/


package sort;

public class CountingSort {
	public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

   public static void countingSort(int[] arr) {
	   int max = findMax(arr);
	   int[] count = new int[max + 1];
	   // Count the frequency of each element
       for (int num : arr) {
           count[num]++;
       }

       // Modify the count array to store the position of each element in the sorted array
       for (int i = 1; i < count.length; i++) {
           count[i] += count[i - 1];
       }
	   
       int[] sortedArray = new int[arr.length];

       // Construct the sorted array
       for (int i = arr.length - 1; i >= 0; i--) {
           sortedArray[count[arr[i]] - 1] = arr[i];
           count[arr[i]]--;
       }

       // Copy the sorted array back to the original array
       System.arraycopy(sortedArray, 0, arr, 0, arr.length);
   }
   
   public static int findMax(int[] arr) {
	   int maxElement = Integer.MIN_VALUE;
	   for(int i : arr) {
		   if(i > maxElement) {
			   maxElement = i;
		   }
	   }
	   return maxElement;
   }
}
