package anagrams;

import java.util.*;
public class Anagrams{
	public List<String> anagrams(String[] strs){
    	if(strs == null || strs.length == 0) return new LinkedList<String>();
        Map<String, Integer> map = new HashMap<>();//map from sorted string to frequency in strs[]
        for(int i=0;i<strs.length;i++){//count the frequency of anagrams 
			String sorted = sortString(strs[i]);//convert to anagrams in sorted order
            if(!map.containsKey(sorted))//newly anagram
            	map.put(sorted,1);
            else
                map.put(sorted,map.get(sorted)+1);//discovered anagram
		}
        List<String> res = new LinkedList<>();//final result
		for(int i=0;i<strs.length;i++){
             if(map.get(sortString(strs[i])) > 1)//frequency is larger than 1
             	res.add(strs[i]);
		}
        return res;
    }
    private String sortString(String s){
    	if(s == null) return null; 
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);

   }	
}
