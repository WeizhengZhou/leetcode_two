package permutations;

import java.util.*;
import util.*;
public class Permutations{
    List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> permute(int[] num){
		if(num == null) return res;
        Arrays.sort(num);
        helper(num,0);
        return res;		
	}
    private void helper(int[] num, int index){
		if(index >= num.length){
			List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<num.length;i++)
				list.add(num[i]);
			res.add(list);
 			return;
		}
        int previous = num[index]-1;//previous number at location index
        for(int i=index;i<num.length;i++){//try each possible number at location index
			if(num[i] != previous){//only generate non-duplicate result
                previous = num[i];
				swap(num,index,i);
                helper(num,index+1);
                swap(num,index,i);
			}	
		}
	}
    private void swap(int[] A, int i, int j){
		int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
	}
    public static void main(String[] args){
		Permutations solu = new Permutations();
        int[] num = new int[]{1,2,2};
        List<List<Integer>> res = solu.permute(num);
        Util.printLists(res);
	}
}
