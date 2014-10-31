package subsets;

import java.util.*;
import util.*;
public class Subsets{
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> subsets(int[] A){
		if(A == null) return res;
		Arrays.sort(A);
		helper(A,0,new ArrayList<Integer>());
		return this.res;
	}
	private void helper(int[] A, int index, List<Integer> list){
		if(index >= A.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		helper(A,A.length,list);//does not include anything
		for(int i=index;i<A.length;i++){//include A[index] to A[end]
			list.add(A[i]);
			helper(A,i+1,list);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args){
		Subsets solu = new Subsets();
		List<List<Integer>> res = solu.subsets(new int[]{1,2,3});
		Util.printLists(res);
	}
}
