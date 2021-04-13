package hard;

public class EditDistance72 {

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
