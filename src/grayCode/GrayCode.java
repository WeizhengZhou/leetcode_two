package grayCode;
import java.util.*;
public class GrayCode{
	public List<Integer> grayCode(int n) {

        if(n < 0) return new LinkedList<Integer>();
        if(n == 0) return new LinkedList<Integer>(){{add(0);}};
    	List<Integer> curLevel = new LinkedList<>();
        List<Integer> nextLevel = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        curLevel.add(0);
        curLevel.add(1);
        for(int i=2;i<=n;i++){
			for(int j=0;j<curLevel.size();j++){
                nextLevel.add(curLevel.get(j));
                stack.push(curLevel.get(j));
            }
            while(!stack.isEmpty()){
            	nextLevel.add(stack.pop() | (1<<(i-1))); 
            }
            curLevel = new LinkedList<>(nextLevel);
            nextLevel.clear();
        } 
        return curLevel; 
    }
    public static void main(String[] args){
    	GrayCode solution = new GrayCode();
        int n = Integer.parseInt(args[0]);
        List<Integer> res = solution.grayCode(n);
        for(Integer e:res)
           System.out.println(e+",");
        System.out.println();
    }
}
