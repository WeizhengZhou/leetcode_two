package threeSum;
import util.*;
import java.util.*;

public class ThreeSum{
	public List<List<Integer>> threeSum(int[] A){
		if(A == null) return new ArrayList<List<Integer>>();
        Arrays.sort(A);

        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i=0;i<A.length;i++){
        	map.put(-A[i],i);
		}
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int value = A[i] + A[j];
            	if(map.containsKey(value) && map.get(value) > j){
                     List<Integer> list = new ArrayList<>(); 
					 list.add(A[i]);
                     list.add(A[j]);
                     list.add(-value);
                     res.add(list);
                }
                while(j<A.length-1 && A[j] == A[j+1]) j++;
            }
            while(i<A.length-1 && A[i] == A[i+1]) i++;
        }
        return res;
    }
    public static void main(String[] args){
   	    int[] num = new int[]{-1,-1, 0, 1, 2,2};
    	Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    	ThreeSum solution = new ThreeSum();
        Util.printLists(solution.threeSum(num));
    }
}
