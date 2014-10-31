package reverseWordsString;
import java.util.Arrays;
public class ReverseWordsString{
	public String reverseWords(String s){
    	if(s == null) return "";
        s = s.trim().replaceAll(" +", " ");//trim leading and tailing spaces, then replace multiple spaces with one space  
        String[] strs = s.split(" ");//split string, sepearted by space
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
        	sb.append(strs[i].trim());
            if(i != 0) 
 				sb.append(" ");
         }
        return sb.toString();
	}
    public static void main(String[] args){
    	ReverseWordsString solution = new ReverseWordsString();
//        String s = "the sky is blue";
//        System.out.println("String = " + "[" + s + "]" + ", reversed = [" + solution.reverseWords(s) + "]");
        String s = " 1  b ";    
        System.out.println("String = " + "[" + s + "]" + ", reversed = [" + solution.reverseWords(s) + "]");
    	
    	
    }
}
