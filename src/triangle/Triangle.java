package triangle;

import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
   		if(triangle == null) return 0;
        int minSum = triangle.get(0).get(0);
        List<Integer> curSum = new ArrayList<>();
        List<Integer> nextSum = new ArrayList<>();
        curSum.add(minSum);
        for(int i=1;i<triangle.size();i++){
    		List<Integer> level = triangle.get(i);
            nextSum.add(curSum.get(0) + level.get(0));//left most path sum
            for(int j=1;j<level.size()-1;j++){
	        	nextSum.add(Math.min(curSum.get(j-1),curSum.get(j)) + level.get(j));//
			}
            nextSum.add(curSum.get(curSum.size()-1) + level.get(level.size()-1));//right most path sum
            curSum = new ArrayList<>(nextSum);
            nextSum.clear();
		}
        return Collections.min(curSum);
    }
    public static void main(String[] args){
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		List<Integer> l0 = new ArrayList<>();
		l0.add(2);
		t.add(l0);
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(3);
		l1.add(4);
		t.add(l1);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(6);
		l2.add(5);
		l2.add(7);
		t.add(l2);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(4);
		l3.add(1);
		l3.add(8);
		l3.add(3);
		t.add(l3);
		
		Triangle s = new Triangle();
		System.out.println(s.minimumTotal(t));
			
	}
}
