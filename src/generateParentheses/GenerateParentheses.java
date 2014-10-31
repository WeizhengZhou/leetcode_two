package generateParentheses;

import java.util.*;
public class GenerateParentheses{
    
    List<String> res = new ArrayList<String>();
	public List<String> generateParenthesis(int n){
		if(n <= 0) return res;
        int leftRem = n;
        int rightRem = n;
        int index = 0;
        char[] charArr = new char[2*n];
        helper(leftRem,rightRem,index,charArr);
        return res;
	}
    private void helper(int leftRem, int rightRem, int index, char[] charArr){
        if(leftRem<0 || rightRem<0 || rightRem < leftRem) return;
		if(index >= charArr.length){
			StringBuilder sb = new StringBuilder();
            for(int i=0;i<charArr.length;i++){
				sb.append(charArr[i]);
			}
            res.add(sb.toString());
            return;
		}
        if(leftRem < rightRem){
			charArr[index] = ')';
            helper(leftRem,rightRem-1,index+1,charArr);	
		}
        charArr[index] = '(';
        helper(leftRem-1,rightRem,index+1,charArr);	
	}
    public static void main(String[] args){
		GenerateParentheses s = new GenerateParentheses();
        int n = 3;
        List<String> res = s.generateParenthesis(n);
        for(String str : res){
			System.out.println(str);
		}
	}

}
