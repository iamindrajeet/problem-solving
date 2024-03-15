/*
Sure! Selection sort is a simple sorting algorithm that repeatedly finds the minimum element from the unsorted part of the array and puts it at the beginning. Here's a simple explanation with an example:

Imagine you have a deck of cards, and you want to arrange them in ascending order from smallest to largest. Here's how selection sort works:

Selection: You start by finding the smallest card in the deck and placing it at the beginning.

Exchange: Then, you take the next smallest card from the remaining unsorted cards and swap it with the card in the second position.

Repeat: You continue this process, each time finding the smallest card from the unsorted portion and placing it at the next position.

Completion: You repeat this process until all cards are sorted.

Let's see this in action with an example:

Consider an array: [5, 2, 4, 6, 1, 3]

First Pass: Find the smallest element in the array, which is 1. Swap it with the first element. Now, the array becomes [1, 2, 4, 6, 5, 3].

Second Pass: Find the smallest element in the remaining unsorted part, which is 2. Swap it with the second element. Now, the array becomes [1, 2, 4, 6, 5, 3].

Third Pass: Find the smallest element in the remaining unsorted part, which is 3. Swap it with the third element. Now, the array becomes [1, 2, 3, 6, 5, 4].

Fourth Pass: Find the smallest element in the remaining unsorted part, which is 4. Swap it with the fourth element. Now, the array becomes [1, 2, 3, 4, 5, 6].

Fifth Pass: Find the smallest element in the remaining unsorted part, which is 5. Swap it with the fifth element. Now, the array becomes [1, 2, 3, 4, 5, 6].

Sixth Pass: There's only one element left, which is 6, and it's already in its correct position.

Now, the array is sorted in ascending order.

Selection sort has a time complexity of O(n^2), making it inefficient for large datasets. However, it's simple to understand and implement, making it suitable for small datasets or situations where simplicity is more important than efficiency.


*/


public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minimumIndex])
					minimumIndex = j;
			}
			if (minimumIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minimumIndex];
				arr[minimumIndex] = temp;
			}
		}
	}

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
