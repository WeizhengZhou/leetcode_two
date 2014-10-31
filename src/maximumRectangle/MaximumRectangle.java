package maximumRectangle;

import java.util.*;
public class MaximumRectangle{
	public int maximalRectangle(char[][] A){
		if(A == null || A.length == 0) return 0;
        int m = A.length;
 		int n = A[0].length;
        int[][] height = new int[m][n];
        for(int j=0;j<n;j++){
			if(A[0][j] == '1') height[0][j] = 1;
            else 			   height[0][j] = 0;
		}
        for(int i=1;i<m;i++){
			for(int j=0;j<n;j++){
				if(A[i][j] == '1') height[i][j] = height[i-1][j]+1;
                else               height[i][j] = 0;
			}
		}
        int maxArea = 0;
        for(int i=0;i<m;i++){
			int area = histMaxArea(height[i]);
            maxArea = Math.max(maxArea,area);
		}
        return maxArea;
	}
    private int histMaxArea(int[] A){
    	if(A == null || A.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i<A.length){
			if(stack.isEmpty() || A[i] > A[stack.peek()]) 
				stack.push(i++);
            else{
                int height = A[stack.pop()];
                int width = stack.isEmpty() ? i:(i- stack.peek()-1); 
			    int area = height*width;
                maxArea = Math.max(maxArea,area); 
			}
		}
        while(!stack.isEmpty()){
			int height = A[stack.pop()];
			int width = stack.isEmpty()?i:(i - stack.peek() - 1);
			int area = height * width;
			maxArea = (area > maxArea) ? area:maxArea;
		}
        return maxArea;
	}
}
