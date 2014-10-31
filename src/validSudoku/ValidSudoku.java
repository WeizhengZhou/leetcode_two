package validSudoku;


import java.util.BitSet;
public class ValidSudoku{
	public boolean isValidSudoku(char[][] board){
		if(board == null || board.length != 9 || board[0].length != 9) return false;
		return isRowValid(board) && isColumnValid(board) && isBlockValid(board);	
	}
	private boolean isRowValid(char[][] board){
		for(int i=0;i<9;i++){
			BitSet bt = new BitSet(9);
			for(int j=0;j<9;j++){
				if(board[i][j] != '.'){
				
					int value = board[i][j] - '0';
					if(bt.get(value-1)) return false;
					bt.set(value-1);
				}
			}
        }

		return true;
	}
	private boolean isColumnValid(char[][] board){
		for(int j=0;j<9;j++){
            BitSet bt = new BitSet(9);
            for(int i=0;i<9;i++){
                if(board[i][j] != '.'){
                    int value = board[i][j] - '0';
                    if(bt.get(value-1)) return false;
                    bt.set(value-1);
                }
            }
        }
        return true;
	}
	private boolean isBlockValid(char[][] board){
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				if(isSubBlockValid(board,x,y) == false)
					return false;
			}
		}
		return true;
	}
	private boolean isSubBlockValid(char[][] board, int x, int y){
		BitSet bt = new BitSet(9);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[3*x+i][3*y+j] != '.'){
				    int value = board[3*x+i][3*y+j] - '0';
				    if(bt.get(value-1) == true) return false;
				    bt.set(value-1);
				}
			}	
		}
		return true;
	}
	   public static void main(String[] args){
	    	char[][] board = {{'.','8','7','6','5','4','3','2','1'},
	    			          {'2','.','.','.','.','.','.','.','.'},
	    			          {'3','.','.','.','.','.','.','.','.'},
	    			          {'4','.','.','.','.','.','.','.','.'},
	    			          {'5','.','.','.','.','.','.','.','.'},
	    			          {'6','.','.','.','.','.','.','.','.'},
	    			          {'7','.','.','.','.','.','.','.','.'},
	    			          {'8','.','.','.','.','.','.','.','.'},
	    			          {'1','.','.','.','.','.','.','.','.'}};

	    	ValidSudoku solution = new ValidSudoku();
	    	System.out.println(solution.isValidSudoku(board));
	    }
}
