package validParentheses;

public class ValidParentheses{
	public boolean isValid(String s){
		if(s == null || s.length() == 0) return true;
		if(s.length() % 2 == 1) return false;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if(c == ')' || c == ']' || c == '}'){
				if(stack.isEmpty())
					return false;
				if(c == ')' && stack.pop() == '(')
					continue;
				if(c == ']' && stack.pop() == '[')
					continue;
				if(c == '}' && stack.pop() == '{')
					continue;
				
				return false;
			}
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
}
