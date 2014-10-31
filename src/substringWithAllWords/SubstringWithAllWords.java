package  substringWithAllWords;
import java.util.*;
public class  SubstringWithAllWords{
	List<Integer> res = new ArrayList<>();
    public List<Integer> findSubstring(String S, String[] L){
        if(S == null || L == null) return res;
        Map<String,Integer> dict = new HashMap<String,Integer>();
	    for(String t:L){
	        if(!dict.containsKey(t))
	            dict.put(t,1);
	        else
	            dict.put(t,dict.get(t) + 1);
	    }
	    for(int i=0;i<=S.length()-L[0].length()*L.length;i++){
	        helper(S,i,L,new HashMap<>(dict));
	    }
	    return res;
	}
	private void helper(String S, int startInd, String[] L, Map<String,Integer> dict){
	    if(S.length()-startInd < L[0].length() * L.length) return;
	    boolean found = true;
	    for(int i=startInd;i<startInd+L[0].length() * L.length; i=i+L[0].length()){
	        String word = S.substring(i,i+L[0].length());
	        if(!dict.containsKey(word)){
	            found = false;
	            break;
	        }
	        else if(dict.get(word) == 1){
	            dict.remove(word);
	        }
	        else{
	            dict.put(word,dict.get(word)-1);
	        }
	    }
	    if(found == true) res.add(startInd);
	}
	public static void main(String[] args){
		String S =  "barfoothefoobarman";
		String[] L = new String[]{"foo", "bar"};
        SubstringWithAllWords solu = new SubstringWithAllWords();
		System.out.println(solu.findSubstring(S, L));


	}
}
