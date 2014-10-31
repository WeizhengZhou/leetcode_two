package nQueens;

import java.util.*;
public class NQueens{
    private int n = 0;
    private int[] col = null;
	List<String[]> res = new ArrayList<String[]>();
	public List<String[]> solveNQueens(int n){
        if(n<=0) return res;
        this.n = n;
        this.col = new int[n];//queen in ith row is in col[i]
        helper(0);
        return res; 
	}
    private void helper(int row){
//    	System.out.println(row + "," +  Arrays.toString(col));
		if(row >= n){
			String[] strs = new String[n];
            for(int i=0;i<n;i++){
				strs[i] = "";
                for(int j=0;j<n;j++){
                    if(col[i] == j) 
						strs[i] += "Q";
                    else 
						strs[i] +=".";
				}
			}
            res.add(strs);
			return;
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
    public static void main(String[] args){
    	List<String[]> list = new ArrayList<String[]>();
    	NQueens solution = new NQueens();
    	list = solution.solveNQueens(4);
    	solution.print(list);
    }

    private void print(List<String[]> list){
    	for(String[] s:list){
    		for(int i=0;i<s.length;i++){
    			System.out.println(s[i]);
    		}
    		System.out.println("-------");
    	}
    }
}
