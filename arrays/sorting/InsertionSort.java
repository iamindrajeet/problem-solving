/*

Insertion Sort works by iterating through the array from the second element to the last.
For each element, it considers it as a "key" and compares it with the elements before it, shifting the larger elements one position to the right until it finds the correct position for the key.
It repeats this process until the entire array is sorted.
In the implementation:
The insertionSort method sorts the array in ascending order.
The outer loop iterates over each element of the array except the first one (since a single element is already sorted).
Inside the loop, the current element is stored in the variable key.
The inner loop compares key with the elements before it (starting from j which is one less than the current index i).
If the element at position j is greater than key, it shifts it one position to the right.
This shifting continues until either the element at j is not greater than key or j becomes less than 0.
Once the correct position for key is found, it is placed at that position.
Finally, the sorted array is printed out.
Insertion Sort has an average and worst-case time complexity of O(n^2), making it inefficient for large datasets. However, it is efficient for small datasets or nearly sorted datasets due to its simplicity and low overhead.


*/


public class InsertionSort {

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i], j = i;
			while(j > 0 && arr[j - 1] > key) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = key;
		}
	}

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}