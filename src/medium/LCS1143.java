package medium;

public class LCS1143 {

	public static void main(String[] args) {
		String str1 = "bsbininm";
		String str2 = "jmjkbkjkv";
		LCS1143 obj = new LCS1143();
		System.out.println("LCS = " + obj.longestCommonSubsequence(str1, str2));
	}
	
    public int longestCommonSubsequence(String text1, String text2) {
    	Integer[][] LIS = new Integer[1+text1.length()][1+text2.length()];
    	
    	for(int i=0; i<=text1.length(); i++) {
    		LIS[i][0]= 0;
    	}
    	for(int i=1; i<=text2.length(); i++) {
    		LIS[0][i]= 0;
    	}
    	for(int i=1; i<=text1.length(); i++) {
    		for (int j=1; j<=text2.length(); j++) {
    			if(text1.charAt(i-1) == text2.charAt(j-1)) {
    				LIS[i][j] = 1 + LIS[i-1][j-1];
    			}
    			else {
    				LIS[i][j] = Math.max(LIS[i-1][j], LIS[i][j-1]);
    			}
    		}
    	}
        return LIS[text1.length()][text2.length()];
    }
}
