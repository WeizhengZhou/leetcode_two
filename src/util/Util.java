package util;
import java.util.List;
public class Util{
	public static <T> void printLists(List<List<T>> lists){
    	for(List<T> list:lists){
			for(T t:list){
                System.out.print(t+",");
            }
            System.out.println();
        }
    }
}
