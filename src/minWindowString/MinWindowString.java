package minWindowString;

import java.util.*;

public class MinWindowString {
	
	public String minWindow(String S, String T) {
        if(S == null || T == null) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for(int i=0;i<T.length();i++){
            if(!dict.containsKey(T.charAt(i)))
                dict.put(T.charAt(i),1);
            else
                dict.put(T.charAt(i),dict.get(T.charAt(i))+1);
        }
        
        int remCharToSee = T.length();
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        String res = "";
        System.out.println(dict);
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            
            if(!dict.containsKey(c)) continue;
            if(dict.get(c) > 0) remCharToSee--;
            dict.put(c,dict.get(c)-1);
            
            if(remCharToSee == 0){
                while(l<i){
                    char z = S.charAt(l);
                    if(!dict.containsKey(z)){
                    	l++;
                    	continue;
                    }
                    else if(dict.get(z) < 0)
                        dict.put(z,dict.get(z)+1);
                    else
                        break;
                    l++;
                }
                if(i-l+1 < minLen){
                    minLen = i-l+1;
                    res = S.substring(l,i+1);
                }
            }
            System.out.println("i = " + i + ", remChar = " + remCharToSee + ", dict = " + dict);
        }
        return res;
    }
	public static void main(String[] args){
		
//		String S = "ADOBECODEBANC";
//		String T = "ABC";
		String S = "a";
		String T = "aa";
		MinWindowString solu = new MinWindowString();
		System.out.println(solu.minWindow(S, T));
		
	}

}
