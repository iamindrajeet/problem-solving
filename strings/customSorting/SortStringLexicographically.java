/*

Lexicographical Sorting in Descending Order:

Lexicographical sorting arranges strings in alphabetical order, much like how words are listed in a dictionary. When sorting in descending order, 
we want to arrange the strings from Z to A instead of A to Z.

Example:
Consider a list of words: "apple", "banana", "orange", "grape", "kiwi".

Comparing First Characters:

We start by comparing the first character of each word. In descending order, we compare from Z to A.
So, in this case, we'll compare 'z' with 'a', 'b', 'o', 'g', 'k'.
Ordering Words:

'z' comes after all other letters in the alphabet, so "kiwi" comes first.
'g' comes before 'o', 'b', and 'a', so "grape" comes next.
'b' comes before 'o' and 'a', so "banana" is next.
'a' comes before 'o', so "apple" follows.
'a' is the first character in "orange", so "orange" comes next.
Continuing with Remaining Characters:

If two words start with the same character, we compare the next characters.
For example, if we have "apple" and "apricot", we'll compare 'p' and 'r'.
In descending order, 'p' comes after 'r', so "apricot" will come before "apple".
Resulting Order:

After comparing all characters, we get the sorted list in descending lexicographical order: "orange", "kiwi", "grape", "banana", "apple".
So, lexicographical sorting in descending order arranges words from Z to A, following the same principles as sorting in ascending order but 
starting from the end of the alphabet.

*/

public class SortLexicographically {
	public static void main(String[] args) {
		String[] arr = new String[] {"google", "apple", "eat", "maple", "beat"};
		sortLexicographically(arr);
	}

	public static void sortLexicographically(String[] arr) {	
		Arrays.sort(arr, (a, b) -> b.compareTo(a));
	}
}