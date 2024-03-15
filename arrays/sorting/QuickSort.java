/*
Quicksort is a popular sorting algorithm that uses a divide-and-conquer strategy to sort elements in an array. Here's a simple explanation along with an example:

Choose a Pivot: First, select a "pivot" element from the array. The pivot can be any element from the array, but for simplicity, let's choose the last element.

Partitioning: Rearrange the array so that all elements smaller than the pivot are moved to its left, and all elements greater than the pivot are moved to its right. The pivot itself will be placed in its final sorted position.

Recursion: Recursively apply the same process to the subarrays on the left and right of the pivot until the entire array is sorted.

Here's an example to illustrate how Quicksort works:

Consider an array: [7, 2, 1, 6, 8, 5, 3, 4]

Choose Pivot: Let's choose the last element, which is 4, as the pivot.

Partitioning: Rearrange the array so that elements smaller than 4 are on the left, and elements greater than 4 are on the right. After partitioning, the array might look like this: [2, 1, 3, 4, 8, 5, 7, 6]. Now, the pivot (4) is in its sorted position.

Recursion: Apply Quicksort recursively to the subarrays on the left and right of the pivot.

For the left subarray [2, 1, 3], choose 3 as the pivot, partition the array, and recursively sort the subarrays.
For the right subarray [8, 5, 7, 6], choose 6 as the pivot, partition the array, and recursively sort the subarrays.
Continue this process until all subarrays are sorted.

Completion: Once all subarrays are sorted, the entire array will be sorted.

The sorted array will look like this: [1, 2, 3, 4, 5, 6, 7, 8].

Quicksort has an average-case time complexity of O(n log n) and a worst-case time complexity of O(n^2), but it is widely used due to its efficiency for most datasets and its relatively simple implementation.

*/


public class QuickSort {
	public void quickSort(int[] arr, int low, int high) {
		if(low >= high)
			return;
		int partitonIndex = partition(arr, low, high);
		quickSort(arr, low, partitonIndex - 1);
		quickSort(arr, partitonIndex + 1, high);
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low, j = 0;
		for(j = low; j < high; j++) {
			if(arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, j);
		return i;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
