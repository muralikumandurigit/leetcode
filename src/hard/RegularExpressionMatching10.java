package hard;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching10 obj = new RegularExpressionMatching10();
//		System.out.println(obj.isMatch("mississippi", "mis*is*p*."));
//		System.out.println(obj.isMatch("aab", "b.*"));
		System.out.println(obj.isMatch("ab", ".*"));
	}

    public boolean isMatch(String s, String p) {
    	
    	if (p.length() ==0 && s.length() == 0) 
    		return true;
    	if (p.length() == 0 && s.length() > 0)
    		return false;
    	
    	boolean mat[][] = new boolean[1+p.length()][];
        
    	for(int i=0; i<=p.length(); i++) {
    		mat[i] = new boolean[1+s.length()];
    		for(int j=0; j<=s.length(); j++) {
    			if (i==0 && j==0) {
    				mat[i][j] = true;
    			}
    			else if (i==0) {
    				mat[i][j] = false;
    			}
    			else if (j==0) {
    				if(p.charAt(i-1) != '*') {
    					mat[i][j] = false;
    				}
    				else {
    					mat[i][j] = mat[i-2][j];
    				}
    			}
    			else {
    				
    				if (p.charAt(i-1) == '*') {
    					mat[i][j] = mat[i-2][j];
    					if (p.charAt(i-2) == '.' || p.charAt(i-2) == s.charAt(j-1)) {
    						mat[i][j] = mat[i][j] || mat[i][j-1];
    					}
    				}
    				else if (p.charAt(i-1) == '.') {
    					mat[i][j] = mat[i-1][j-1];
    				}
    				else if (p.charAt(i-1) == s.charAt(j-1)) {
    					mat[i][j] = mat[i-1][j-1];
    				}
    				else {
    					mat[i][j] = false;
    				}
    			}
    		}
    	}
    	
/*     	for (int i=0; i<=p.length(); i++) {
    		
    		for (int j=0; j<=s.length(); j++) {
    			System.out.print("  " + mat[i][j]);
    		}
    		System.out.println();
    	} */
    	return mat[p.length()][s.length()];
    }
}
