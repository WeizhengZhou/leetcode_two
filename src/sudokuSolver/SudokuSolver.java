package sudokuSolver;

import java.util.*;
public class SudokuSolver{
	public void solveSudoku(char[][] board){
		if(board == null || board.length == 0) return; 
        if(board.length != 9 || board[0].length != 9) return; 
        helper(board,0,0);
	}
    private boolean helper(char[][] board, int i, int j){
        if(i >= 9) return true;//solved 
        if(j >= 9) return helper(board,i+1,0);//move to the first element of next row
      
        
        assert (i>=0 && i<9 && j>=0 && j<9);
        if(board[i][j] != '.') 
			return helper(board,i,j+1);//solve next location

        System.out.println("Solving " + " i = " + i + ", j = " + j);
    	for(char c='1';c<='9';c++){//try all possible solution
           board[i][j] = c;
           if(isValid(board,i,j) && helper(board,i,j+1))//solved at this level
 				return true;
        } 
    	board[i][j] = '.';
         return false;
	}
    public boolean isValid(char[][] board, int i, int j){
    
		BitSet row = new BitSet(9);
       
        for(int k=0;k<9;k++){
        	if(board[i][k] != '.'){
        		 int r = Integer.valueOf(board[i][k]); 
        		 if(row.get(r-1)) return false;
                 row.set(r-1);
        	}
		}
        
        BitSet col = new BitSet(9);
        for(int k=0;k<9;k++){
        	if(board[k][j] != '.'){
        		 int c = Integer.valueOf(board[i][k]); 
        		 if(col.get(c-1)) return false;
                 col.set(c-1);
        	}
		}
        BitSet block = new BitSet(9);
        for(int s=0;s<3;s++){
			for(int t=0;t<3;t++){
				if(board[3*(i/3) + s][3*(j/3) + t] != '.'){
				    int value = Integer.valueOf(board[3*(i/3) + s][3*(j/3) + t]);
                    if(block.get(value-1))
                   	    return false;
                    block.set(value-1);
				}
			}	
		}
        return true;
	}
    public static void main(String[] args){
    	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
    			{'6','.','.','1','9','5','.','.','.'},
    			{'.','9','8','.','.','.','.','6','.'},
    			{'8','.','.','.','6','.','.','.','3'},
    			{'4','.','.','8','.','3','.','.','1'},
    			{'7','.','.','.','2','.','.','.','6'},
    			{'.','6','.','.','.','.','2','8','.'},
    			{'.','.','.','4','1','9','.','.','5'},
    			{'.','.','.','.','8','.','.','7','9'}};
//    	System.out.println(Character.getNumericValue(boad[0][1])); 
    	SudokuSolver solution = new SudokuSolver();
    	solution.solveSudoku(board);;
    	solution.print(board);    	
    }
    private void print(char[][] board){
    	for(char[] row : board){
    		for(char c : row){
    			System.out.print(c + ", ");
    		}
    		System.out.println();
    	}
    }
}
