package sortColors;
import java.util.*;
public class SortColors{
	public void sortColors(int[] A){
    	if(A == null) return;
        int n = A.length;
        int l = -1;
        int r = n;
        int i = 0;
        while(i<r){//i<r not i<n
            if(A[i] == 0) 
                swap(A,++l,i++);
            else if(A[i] == 1)
                i++;
            else if(A[i] == 2)
                swap(A,--r,i);
            else
                return;
        } 
    }
    private void swap(int[] A, int p, int q){
 		int t = A[p];
        A[p] = A[q];
        A[q] = t;
    }
    public static void main(String[] args){
    	int[] A = new int[]{0,1,1,2,0,1,2};
        SortColors solution = new SortColors();
        solution.sortColors(A);
        System.out.println(Arrays.toString(A));
    }
}
