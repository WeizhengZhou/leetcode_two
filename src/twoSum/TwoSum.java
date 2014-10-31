package twoSum;
import java.util.*;
public class TwoSum{
	public int[] twoSum(int[] A, int target){
        if(A == null) return null;
    	Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            map.put(target-A[i],i);
        }
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i]) && map.get(A[i]) < i)
                  return new int[]{map.get(A[i])+1,i+1}; 
        }
        return new int[]{-1,-1};
    }
    public int[] twoSum_doublePointer(int[] A, int target){
        //after sorting, the indecies are changed, therefore, cannot reflect the original indicies of the array.
        if(A == null) return null;
        Arrays.sort(A);
        int l = 0;
        int r = A.length-1;
        while(l<r){
            int value = A[l] + A[r];
            if(value == target) return new int[]{l+1,r+1};
            else if(value < target) l++;
            else r--;
        }
        return new int[]{-1,-1};
    }	
    public static void main(String[] args){
		int[] numbers = new int[]{7, 6, 11, 0};
		int target = 6;
		int[] indexes = new TwoSum().twoSum_doublePointer(numbers,target);
		System.out.println(Arrays.toString(indexes));	
	}
}

