package removeDuplicatesSortedArray;

public class RemoveDuplicatesSortedArray{
	public int removeDuplicates(int[] A){
    	if(A == null) return 0;
        if(A.length < 2) return A.length;
        int p = 0;//end index of result array without duplicates 
        int i = 1;//cur index considering
        while(i<A.length){//loop cur index to A.length-1
			while(i<A.length && A[i] == A[p])//loop until find A[i] != A[p]
            	i++;
            if(i == A.length) break;//if out of boundary
            A[++p] = A[i++];//p++;A[p] = A[i];i++;
        }
        return p+1;
	}
    public static void main(String[] ags){
		int[] A = new int[]{1,2,2,3,3};
        RemoveDuplicatesSortedArray s = new RemoveDuplicatesSortedArray();
        System.out.println(s.removeDuplicates(A));
	}
}



