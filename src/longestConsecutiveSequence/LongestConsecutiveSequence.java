package longestConsecutiveSequence;
import java.util.*;
public class LongestConsecutiveSequence{
	public int longestConsecutive(int[] A){
		if(A == null) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<A.length;i++){
			if(!map.containsKey(A[i]))
				map.put(A[i],1);
			else
				map.put(A[i],map.get(A[i])+1);
		}
		int maxL = 0;
		for(int i=0;i<A.length;i++){
			if(map.containsKey(A[i])){
				int cur = A[i];
				int length = 0;
				while(map.containsKey(cur)){
					length += map.get(cur);
					map.remove(cur);
					cur--;
				}
				cur = A[i]+1;
				while(map.containsKey(cur)){
					length += map.get(cur);
					map.remove(cur);
					cur++;
				}
				maxL = Math.max(maxL,length);
			}
		}
		return maxL;
	}
	public static void main(String[] args){
		LongestConsecutiveSequence solu = new LongestConsecutiveSequence();		
		int[] A = new int[]{100,1,3,200,4,2};
		System.out.println(solu.longestConsecutive(A));
	}
}
