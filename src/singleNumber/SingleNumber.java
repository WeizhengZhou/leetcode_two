package singleNumber;
public class SingleNumber{
	public int singleNumber(int[] A){
		if(A == null) return -1;
        int value = 0;
        for(int i=0;i<A.length;i++)
			value ^= A[i];
        return value;
	}
}
