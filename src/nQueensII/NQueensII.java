package nQueensII;
public class NQueensII{
	private int n = 0;
    private int[] col = null;
    private int totalSolution = 0;
	public int totalNQueens(int n){
        if(n<=0) return 0;
        this.n = n;
        this.col = new int[n];//queen in ith row is in col[i]
        helper(0);
        return totalSolution; 
	}
    private void helper(int row){
		if(row >= n){
        	totalSolution++;
		}
        for(int j=0;j<n;j++){
			col[row] = j;
            boolean isValid = true;
            for(int k=0;k<row;k++){
				if(col[row] == col[k] ||
						 (row-k) == Math.abs(col[row] - col[k])){
					isValid = false;
                    break;
				}
			}
            if(isValid) helper(row+1);
         }     
    }
}
