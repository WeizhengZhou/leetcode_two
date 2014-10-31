package simplifyPath;
import java.util.*;
public class SimplifyPath{
	public String simplifyPath(String path){
    	if(path == null) return null;
        
        String[] strs = path.split("/");
        System.out.println(Arrays.toString(strs));
        List<String> list = new LinkedList<>(); 
        for(int i=0;i<strs.length;i++){
           
        	if(strs[i].equals("") ||strs[i].equals("."))
 				continue;
            else if(strs[i].equals("..")){
        		if(!list.isEmpty())
     				list.remove(list.size()-1);
            }
            
            else
                list.add(strs[i]);
        }
        if(list.size() == 0) 
            return "/";
        else{
      	     StringBuilder sb = new StringBuilder();
             for(String s : list)
         	    sb.append("/"+s);
             return sb.toString(); 
        }	
    }
    public static void main(String[] agrs){
    	SimplifyPath solution = new SimplifyPath();
//        String path = "/a/./b/../../c/";
    	String path = "/...";
        System.out.println("Path = " + path + ", after simplification = " + solution.simplifyPath(path));
        path = "/../";
        System.out.println("Path = " + path + ", after simplification = " + solution.simplifyPath(path));
    }

}
