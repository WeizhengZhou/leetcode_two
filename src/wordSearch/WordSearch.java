package wordSearch;

import java.util.*;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null || word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && bfs(board,word,i,j))
                    return true;
            }
        }
        return false;
    }
    private boolean bfs(char[][] board, String word, int i, int j){
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> row = new LinkedList<Integer>();
        Queue<Integer> col = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        row.add(i);
        col.add(j);
        index.add(0);
        while(!row.isEmpty() && !col.isEmpty()){
            int curRow = row.remove();
            int curCol = col.remove();
            int curInd = index.remove();
            if(curInd >= word.length())
                return true;
            else if(curRow <0 || curRow >= m || curCol<0 || curCol>= n)
                continue;
            else if(visited[curRow][curCol] == true)
                continue;
            else if(board[curRow][curCol] != word.charAt(curInd))
                continue;
            else{
                visited[curRow][curCol] = true;
                row.add(curRow-1);col.add(curCol);index.add(curInd+1);
                row.add(curRow+1);col.add(curCol);index.add(curInd+1);
                row.add(curRow);col.add(curCol-1);index.add(curInd+1);
                row.add(curRow);col.add(curCol+1);index.add(curInd+1);
            }
        }
        return false;
    }
    public static void main(String[] args){
//    	char[][] board = new char[][]{{'A','B','C','E'},
//    			{'S','F','C','S'},
//    			{'A','D','E','E'}};
//    	String word = "SEE";
		char[][] board = new char[][]{{'C','A','A'},
        {'A','A','A'},
        {'B','C','D'}};
String word = "AAE";

    	WordSearch s = new WordSearch();
    	System.out.println(s.exist(board, word));
    	
    }
}