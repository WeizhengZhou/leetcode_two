package subsetsII;

import java.util.*;
import util.*;
public class SubsetsII{
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> subsetsWithDup(int[] A){
		if(A == null) return res;
		Arrays.sort(A);
		helper(A,0,new ArrayList<Integer>());
		return res;
	}
	private void helper(int[] A, int index, List<Integer> list){
		if(index >= A.length){
			res.add(new ArrayList<>(list));
			return;
		}	
		int value = A[index];
		int count = 0;
		for(int i=index;i<A.length;i++){
			if(A[i] != value) break;
			count++;
		}
		helper(A,index+count,list);//add 0 value
        for(int i=1;i<=count;i++){//add i values 
			list.add(value);
			helper(A,index+count,list);//consider next possible value
		}
		for(int i=1;i<=count;i++)
			list.remove(list.size()-1);
	}
    public static void main(String[] args){
		SubsetsII solu = new SubsetsII();
		int[] A = new int[]{1,1,2};
		List<List<Integer>> res = solu.subsetsWithDup(A);
        Util.printLists(res);
	}
}
