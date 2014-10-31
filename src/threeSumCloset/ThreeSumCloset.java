package threeSumCloset;
import java.util.Arrays;
public class ThreeSumCloset{
	public int threeSum(int[] A, int target){
		if(A == null || A.length < 3) return 0;
        Arrays.sort(A);
        int closet = A[0]+A[1]+A[2];
        for(int i=0;i<A.length-2;i++){//first number = A[i]
            int l = i+1;//second number
            int r = A.length -1;//third number
            int sum = 0;//sum of three
            while(l<r){
				sum = A[i] + A[l] + A[r];
                if(Math.abs(sum-target) < Math.abs(closet - target))//closer threeSum, may overflow 
					closet = sum;
                if(sum < target) l++;//l++ makes sum larger
                else if(sum > target) r--;//r-- makes sum smaller
                else return target;//exactly sum = target, can return 
			}
		}
        return closet;
	
	}
}
