package surroundedRegions;


import java.util.*;
public class SurroundedRegions{
    private char[][] board = null;
    private boolean[][] rescue = null;  
    private int m = 0;
    private int n = 0;

	public void solve(char[][] board){
		if(board==null || board[0] == null) return;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        //set true, if board[i][j] = 'O', and is not captured
        this.rescue = new boolean[m][n];	
        for(int i=0;i<m;i++){//rescue the first and last column
			if(board[i][0] == 'O')
            	bfs(i,0);
           if(board[i][n-1] == 'O')
                bfs(i,n-1);
		}
        for(int j=0;j<n;j++){//rescue the first and last row
	        if(board[0][j] == 'O')
                bfs(0,j);
            if(board[m-1][j] == 'O')
                bfs(m-1,j);
		}
        for(int i=0;i<m;i++){//flip each NOT beed rescued 'O' to 'X'
        	for(int j=0;j<n;j++){
				if(board[i][j] == 'O' && rescue[i][j] == false)
                	board[i][j] = 'X';
			}
		}
        print(rescue);
     
    }
    //bfs start from board[x][y], only 'O' and 'O' are connected
    private void bfs(int x, int y){
    	Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        row.add(x);
        col.add(y);
        while(!row.isEmpty()){
             x = row.remove();
             y = col.remove();
             if(x<0 || x>=m || y<0 || y>=n || rescue[x][y] == true)
 				continue;
             if(board[x][y] == 'O'){//there is an 'O' path from boundary to this 'O', it is rescued. 
		     	 rescue[x][y] = true;
                 //add its neighbors int queue
                 row.add(x-1);col.add(y);
                 row.add(x+1);col.add(y);
                 row.add(x);  col.add(y-1);
                 row.add(x);  col.add(y+1);
             }
		}
    }
    
    public static void main(String[] args){

		char[][] board = new char[][]{{'X','O','X','O','X','O'},
                                      {'O','X','O','X','O','X'},
                                      {'X','O','X','O','X','O'},
                                      {'O','X','O','X','O','X'}};
//		char[][] board = new char[][]{{'O','X'},{'X','X'}};
		SurroundedRegions  s = new SurroundedRegions ();
		s.solve(board);
		s.print(board);
		
	}
	private void print(boolean[][] A){
		for(boolean[] row:A){
			for(boolean b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
	private void print(char[][] A){
		for(char[] row:A){
			for(char b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
}
