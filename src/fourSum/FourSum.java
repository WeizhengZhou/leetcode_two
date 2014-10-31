package fourSum;

import java.util.*;
import util.*;
public class FourSum{
	public List<List<Integer>> fourSum(int[] A, int target){
		if(A == null || A.length < 4) return new ArrayList<List<Integer>>();
		Arrays.sort(A);
		List<List<Integer>> res = new ArrayList<List<Integer>>();	
		for(int i=0;i<A.length;i++){
 			for(int j=i+1;j<A.length;j++){
				int l = j+1;
				int r = A.length-1;
				while(l<r){
					int sum = A[i] + A[j] + A[l] + A[r];
					if(sum == target){
						List<Integer> list = new ArrayList<>();
						list.add(A[i]);
						list.add(A[j]);
						list.add(A[l]);
						list.add(A[r]);
						res.add(list);
						while(l<r && A[l] == A[l+1]) l++;
                   		while(r>l && A[r] == A[r-1]) r--;	
						l++;
						r--;
					}
					else if(sum < target) l++;
					else r--;
				}
		    	while(j<A.length-1 && A[j] == A[j+1]) j++;
            }	
			while(i < A.length-1 && A[i] == A[i+1]) i++;
		}
        return res;
	}
	public static void main(String[] args){
		int[] A = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		FourSum solu = new FourSum();
		List<List<Integer>> res = solu.fourSum(A,target);
		Util.printLists(res);

	}
}
