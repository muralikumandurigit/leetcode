package hard;

public class EditDistance72 {

	/*
	 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
	 */
	public static void main(String[] args) {
		EditDistance72 obj = new EditDistance72();
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(obj.minDistance(word1, word2));
	}

	public int minDistance(String word1, String word2) {
		int[][] mat = new int[1 + word2.length()][];
		for (int i = 0; i <= word2.length(); i++) {
			mat[i] = new int[1 + word1.length()];

			for (int j = 0; j <= word1.length(); j++) {
				if (i == 0) {
					mat[i][j] = j;
				}
				else if (j==0) {
					mat[i][j] = i;
				}
				else {
					if (word1.charAt(j-1) == word2.charAt(i-1)) {
						mat[i][j] = mat[i-1][j-1];
					} else {
						mat[i][j] = 1 + Math.min(mat[i-1][j-1], Math.min(mat[i-1][j], mat[i][j-1]));
					}
				}
			}
		}
		return mat[word2.length()][word1.length()];
	}

}
