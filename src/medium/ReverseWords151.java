package medium;

import java.util.Stack;

public class ReverseWords151 {

	public static void main(String[] args) {
		ReverseWords151 obj = new ReverseWords151();
		String s = "he   llo     w   orld";
		System.out.println(s + " => <" + obj.reverseWords(s) + ">");
	}
/*
    public String reverseWords(String s) {
    	String[] strAry = s.split(" ");
    	Stack<String> stk = new Stack<String>();
    	for (String w : strAry) {
			String nw = w.trim();
			if (nw.length() > 0) {
				stk.push(nw);
			}
		}
    	String res = "";
    	while(!stk.isEmpty()) {
    		if (res.length() == 0) {
    			res = stk.pop();
    		}
    		else {
    			res += " " + stk.pop();
    		}
    	}
		return res; 
    }
    */
	/* in the O(1) space */
	public String reverseWords(String s) {
		String res = "";
		String tmp = "";
		
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (tmp.length() > 0) {
					res = tmp + " " + res;
					tmp = "";
				}
			}
			else {
				tmp += s.charAt(i);
			}
		}
		if (tmp.length() > 0) {
			res = tmp + " " + res;
		}
		return res.trim();
	}
}
