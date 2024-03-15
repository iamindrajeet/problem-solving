/*
Merge sort is another popular sorting algorithm that follows the divide-and-conquer approach to sort elements in an array. Here's a simple explanation along with an example:

Divide: Divide the array into two halves.

Conquer: Recursively sort each half.

Combine (Merge): Merge the sorted halves to produce a single sorted array.

Here's an example to illustrate how Merge sort works:

Consider an array: [38, 27, 43, 3, 9, 82, 10]

Divide: Divide the array into two halves: [38, 27, 43, 3] and [9, 82, 10].

Conquer: Recursively sort each half.

For the first half: [38, 27, 43, 3]
Divide: [38, 27] and [43, 3]
Conquer: [27, 38] and [3, 43]
For the second half: [9, 82, 10]
Divide: [9] and [82, 10]
Conquer: [9] and [10, 82]
Combine (Merge): Merge the sorted halves back together.

Merge [27, 38] and [3, 43] to get [3, 27, 38, 43]
Merge [9] and [10, 82] to get [9, 10, 82]
Now, merge [3, 27, 38, 43] and [9, 10, 82] to get the final sorted array: [3, 9, 10, 27, 38, 43, 82].

Merge sort has a time complexity of O(n log n) in all cases (average, worst, and best), making it more efficient than other sorting algorithms like bubble sort or insertion sort for large datasets. It's also a stable sorting algorithm, meaning it preserves the relative order of equal elements.



*/


public class MergeSort {

	public void mergeSort(int[] arr, int n) {
		if(n < 2)
			return;
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for(int i = mid; i < n; i++) {
			right[i - mid] = arr[i];
		}
		
		merge(arr, left, right, mid, n - mid);
		mergeSort(left, mid);
		mergeSort(right, n - mid);
	}

	private void merge(int[] arr, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while(i < left && j < right) {
			if(l[i] < r[j]) {
				arr[k++] = l[i++];
			}else {
				arr[k++] = r[j++];
			}
		}
		while(i < left) {
			arr[k++] = l[i++];
		}
		while(j < right) {
			arr[k++] = r[j++];
		}
	}
	
	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
