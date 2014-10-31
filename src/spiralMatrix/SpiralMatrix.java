package spiralMatrix;
import java.util.*;
public class SpiralMatrix{
	public List<Integer> spiralOrder(int[][] A){
		if(A == null || A.length == 0) return new ArrayList<Integer>();
        int m = A.length;
        int n = A[0].length;
        List<Integer> list = new LinkedList<Integer>();
        int i=0;
        for( ;i< Math.min(m,n)/2;i++){
        	for(int k=i;k<n-i-1;k++) list.add(A[i][k]);
            for(int k=i;k<m-i-1;k++) list.add(A[k][n-i-1]);
            for(int k=n-i-1;k>i;k--) list.add(A[m-i-1][k]);
            for(int k=m-i-1;k>i;k--) list.add(A[k][i]);	
		}
        if(m==n && m%2 == 1)//e.g. 3*3 matrix
            list.add(A[m/2][n/2]);
        else if(m < n && m%2 == 1){//e.g. 3*4 matrix
			for(int k=i;k<n-i;k++)
            	list.add(A[i][k]);
		}
        else if(n < m && n%2 == 1){//e.g. 4*3 matrix
            for(int k=i;k<m-i;k++)
      			list.add(A[k][i]);
        }
        return list;
	}
    public static void main(String[] ags){
    	int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
   // 	int[][] matrix = new int[][]{{1,2},{3,4},{5,6}};
    	SpiralMatrix solution = new SpiralMatrix();
    	System.out.println(solution.spiralOrder(matrix));    	
    }
}
