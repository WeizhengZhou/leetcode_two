package nextPermutation;

import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1) return;
        int index = num.length-1;
        while(index > 0 && num[index] <= num[index-1]){
            index--;
        }
        if(index < 0){
            Arrays.sort(num);
            return;
        }
        index--;
        int nextIntIndex = num.length-1;
        int k = num.length-1;
        while(k > index){
            if(num[k] > num[index] && num[k] < num[nextIntIndex]){
                nextIntIndex = k;
            }
            k--;
        }
        int temp = num[index];
        num[index] = num[nextIntIndex];
        num[nextIntIndex] = temp;
        
        Arrays.sort(num,index+1,num.length);
    }
	public static void main(String[] args){
		int[] num = new int[]{3,1,2};
		NextPermutation solu = new NextPermutation();
		solu.nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
	}

}
