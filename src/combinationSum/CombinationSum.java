package combinationSum;

import java.util.*;
import util.Util;
public class CombinationSum{
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null) return null;
		Arrays.sort(candidates);
    	helper(candidates,target,new ArrayList<Integer>(),0);
    	return res;
    }
    private void helper(int[] cand, int target, List<Integer> list, int index){
        if(target < 0 || index >= cand.length){//exhausted all cand, target still nonzero
            return;
        }
        else if(target == 0){//target equals zero, 
        	res.add(new ArrayList<Integer>(list));
        }
        else{
        	for(int i=index;i<cand.length;i++){
        		list.add(cand[i]);
        		helper(cand,target-cand[i],list,i);
        		list.remove(list.size()-1);
        	}
        }
    }
    public static void main(String[] args){
    	int[] cand = new int[]{3,6};
    	int target = 6;
    	CombinationSum  solution = new CombinationSum ();
    	List<List<Integer>> lists = solution.combinationSum(cand, target);
    	Util.printLists(lists);
    }
}
