/*
Algorithm Explanation:
Reverse Words:

The algorithm starts by iterating over each word in the array.
For each word, it reverses the characters, effectively reversing the word itself.
This is done using a StringBuilder to reverse each word efficiently.
Sort the Reversed Words:

After reversing all the words, the algorithm sorts the array of reversed words lexicographically.
Sorting is crucial as it helps group rhyming words together. Rhyming words have the same ending when their characters are reversed.
Reverse Back:

Once the array is sorted, the algorithm reverses the characters of each word again.
This step is essential to restore the original order of words while ensuring that rhyming words are grouped together.
Example:
Consider the input array: {"cat", "bat", "act", "tab", "rat"}.

Reverse Words:

"cat" becomes "tac".
"bat" becomes "tab".
"act" becomes "tca".
"tab" remains "bat".
"rat" becomes "tar".
Sort the Reversed Words:

After sorting, the array becomes {"bat", "cat", "act", "tab", "rat"}.
Reverse Back:

"bat" becomes "tab".
"cat" becomes "tac".
"act" remains "act".
"tab" becomes "bat".
"rat" becomes "tar".
So, after executing the algorithm, the resulting array will be {"tab", "tac", "act", "bat", "tar"}, 
where rhyming words "cat", "act", and "tac" are grouped together, as well as rhyming words "bat" and "tab".

*/

import java.util.Arrays;

public class GroupRhymingWordsTogether {
	public static void main(String[] args) {
		String[] arr = new String[] {"google", "apple", "eat", "maple", "beat"};
		groupRhymingWords(arr);
	}

public static void groupRhymingWords(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			arr[i] = sb.reverse().toString();
			sb.delete(0, sb.length());
		}
		Arrays.sort(arr, (a, b) -> a.compareTo(b));
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			arr[i] = sb.reverse().toString();
			sb.delete(0, sb.length());
		}
	}
}