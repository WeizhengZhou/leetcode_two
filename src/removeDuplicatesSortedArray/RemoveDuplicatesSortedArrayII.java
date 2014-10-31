package removeDuplicatesSortedArray;

public class RemoveDuplicatesSortedArray{
	public int removeDuplicates(int[] A){
		if(A == null) return 0;
        if(A.length < 3) return A.length;
        
        int end = 0;//end index of result array
        int count = 1;//number of duplicates of A[end]
        for(int i=1;i<A.length;i++){
			if(A[i] != A[end]){//new element
				A[++end] = A[i];//copy new element to A[end+1], end++
                count = 1;//new element only has one count
			}
            else if(count == 1){//duplicated element, but count is equal to one
                A[++end] = A[i];
				count++;			
			}
            //else duplicated element, count >= 2, does not copy 
		}
        return end+1;
	}
}
