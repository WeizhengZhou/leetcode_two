package rotateImage;

public class RotateImage {
	public void rotate(int[][] A) {
        if(A == null || A.length != A[0].length) return;
        int n = A.length;
        for(int i=0;i<n/2;i++){
            for(int k=0;k<n-2*i-1;k++){
                int temp = A[i][i+k];
                A[i][i+k] = A[n-i-1-k][i];
                A[n-i-1-k][i] = A[n-i-1][n-i-1-k];
                A[n-i-1][n-i-1-k] = A[i+k][n-i-1];
                A[i+k][n-i-1] = temp;
            }
        }
    }
	public static void main(String[] args){
		int[][] A = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		RotateImage solu = new RotateImage();
		solu.rotate(A);
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
}
