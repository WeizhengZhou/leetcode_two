package lengthLastWord;
public class LengthLastWord{
	public int lengthOfLastWord(String s){
		if(s == null) return 0;
        s = s.trim().replaceAll(" +"," ");
        String[] strs = s.split(" ");
        if(strs == null || strs.length == 0) return 0;
        return strs[strs.length-1].length();
	}

}
