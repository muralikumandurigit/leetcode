package outside;

public class MaximizeMicrosoft {

	 /* 
	  * Question 2 ) Given an array of integers maximize num1 + num2 – distance.
distance between ‘5’ and ’10’ in the array 5 4 89 25 10 is (4).
if not possible return 0
https://www.geeksforgeeks.org/microsoft-on-campus-placement-and-interview-questions/


*/
	public static void main(String[] args) {
		int a[] = {5, 4, 89, 25, 10};
		MaximizeMicrosoft obj = new MaximizeMicrosoft();
		System.out.println(obj.miximize(a));
	}

	public int miximize(int a[]) {
		if (a.length<=1) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				int l = j-i;
				max = Math.max(a[i]+a[j] - l, max);
			}
		}
		return max;
	}
}

