package letterCombinationPhoneNumber;

import java.util.*;
public class LetterCombinationPhoneNumber{
	//mapping from digits to letters     0  1   2     3    4     4      6    7       8     9
	private String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits){
		if(digits == null || digits.length() == 0) return new ArrayList<>();
		int n  = digits.length();
		char[] charArr = new char[n];
		List<String> res = new ArrayList<>();
		helper(digits,0,charArr,res);
		return res;
	}
	private void helper(String digits, int index, char[] charArr, List<String> res){
		if(index >= digits.length()){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<charArr.length;i++){
				sb.append(charArr[i]);
			}
			res.add(sb.toString());
			return;
		}
		if(digits.charAt(index) < '0' || digits.charAt(index) > '9') return;//should throw invalid inputs exception
		int digit = Integer.parseInt(digits.substring(index,index+1));
		String letters = map[digit];
		for(int i=0;i<letters.length();i++){
			charArr[index] = letters.charAt(i);
			helper(digits,index+1,charArr,res);
		}	
	}
	public static void main(String[] args){
		String s = "23";
		LetterCombinationPhoneNumber solu = new LetterCombinationPhoneNumber();
		List<String> res = solu.letterCombinations(s);
		System.out.println(res);
	}
}
