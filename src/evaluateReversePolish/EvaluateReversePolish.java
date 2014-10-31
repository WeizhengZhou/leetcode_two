package evaluateReversePolish;
import java.util.*;
public class EvaluateReversePolish{
	public int evalRPN(String[] strs){
		if(strs == null) return 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<strs.length;i++){
			if(strs[i].equals("+") || strs[i].equals("-") || strs[i].equals("*") || strs[i].equals("/")){
				if(stack.size() < 2) return -1;
				if(strs[i].equals("+")){
                    stack.push(stack.pop()+stack.pop());
                 }
                 else if(strs[i].equals("-")){
                    stack.push(-stack.pop()+stack.pop());
                 }
                 else if(strs[i].equals("*")){
                    stack.push(stack.pop() * stack.pop());
                 }
                 else if(strs[i].equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                 }
			}
			else{
				stack.push(Integer.parseInt(strs[i]));
			}
		}
		return stack.pop();	
	}
}
