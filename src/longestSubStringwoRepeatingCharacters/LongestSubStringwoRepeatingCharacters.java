package longestSubStringwoRepeatingCharacters;


import java.util.*;
public class LongestSubStringwoRepeatingCharacters{
	public int lengthOfLongestSubstring(String s){
        if(s == null) return 0;
    	Set<Character> set = new HashSet<>();
        int l = 0;
        int maxL = 0;
        for(int r=0;r<s.length();r++){
        	if(!set.contains(s.charAt(r))){
           		set.add(s.charAt(r));
                maxL = Math.max(maxL,r-l+1);
            }
            else{
			    while(l<r && s.charAt(l) != s.charAt(r)){
                	set.remove(s.charAt(l));
                	l++;
                }	
			    l++;
			}
        }
        return maxL;
    }
	public static void main(String[] args){
		String s = "abcbca";
		LongestSubStringwoRepeatingCharacters solution = new LongestSubStringwoRepeatingCharacters();
		System.out.println(solution.lengthOfLongestSubstring(s));
	}
}
