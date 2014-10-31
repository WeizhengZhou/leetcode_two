package strStr;

public class StrStr{
	public String strStr(String haystack, String needle){
    	if(haystack == null || needle == null) return null;
        for(int i=0;i<=haystack.length() - needle.length(); i++){
			if(haystack.substring(i,i+needle.length()).equals(needle))
                return haystack.substring(i,i+needle.length());
        }
		return null;
    }
}
