package removeElement;

public class RemoveElement{
	public int removeElement(int[] A, int target){
		if(A == null) return 0;
		int end = -1;
		int i = 0;
        while(i<A.length){
			if(A[i] != target) 
				A[++end] = A[i];
			i++;
		}
		return end+1;		
	}
}
