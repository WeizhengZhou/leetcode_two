package spiralMatrixII;
import java.util.Arrays;

public class SpiralMatrixII{
	public int[][] generateMatrix(int n){
		if(n <= 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int count = 1;
        for(int i=0;i<n/2;i++){
			for(int k=i;k<n-i-1;k++) matrix[i][k] = count++;
            for(int k=i;k<n-i-1;k++) matrix[k][n-i-1] = count++;
            for(int k=n-i-1;k>i;k--) matrix[n-i-1][k] = count++;
            for(int k=n-i-1;k>i;k--) matrix[k][i] = count++;
		}
        if(n%2 == 1)
			matrix[n/2][n/2] = count; 
        return matrix;
	}
    public static void main(String[] args){
		int n = 3;
        SpiralMatrixII solu = new SpiralMatrixII();
		int[][] matrix = solu.generateMatrix(n);
        System.out.println(Arrays.deepToString(matrix));
	}
}
