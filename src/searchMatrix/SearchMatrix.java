package searchMatrix;
public class SearchMatrix{
    private int[][] A = null;
    private int m = 0;
    private int n = 0;
    private int target = 0;
	public boolean searchMatrix(int[][] A, int target){
		if(A == null || A.length ==0) return false;
        this.A = A;
        this.m = A.length;//m Rows
        this.n = A[0].length;//n Columns
        this.target = target;
        return searchRow(0,m-1);
	}
    private boolean searchRow(int u, int d){//search which the row the target locates 
		if(u < 0 || d >= m || u > d)//out of range
            return false;
		int m = u + (d-u)/2;//middle row
        if(target < A[m][0])//target in upper plane
            return  searchRow(u,m-1);
        else if(target > A[m][n-1])//target in lowwer plane
            return searchRow(m+1,d);
        else 
            return searchColumn(m,0,n-1);//target in this row, use 1D search
    }
    private boolean searchColumn(int row, int l, int r){
        if(l<0 || r>=n || l>r) //out of bounds
			return false;
        int m = l + (r-l)/2;//middle column
        if(target == A[row][m]) //found the target
 			return true; 
        else if(target < A[row][m])//left half
            return searchColumn(row, l, m-1);
        else 
            return searchColumn(row, m+1, r);//right half
    }
}
