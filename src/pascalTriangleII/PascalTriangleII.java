package pascalTriangleII;
public class PascalTriangleII{
	public List<Integer> getRow(int k){
		List<Integer> curLevel = new ArrayList<>();
		List<Integer> nextLevel = new ArrayList<>();
		if(k < 0) return curLevel;
		curLevel.add(1);
		for(int i=1;i<=k;i++){
			nextLevel.add(1);
			for(int j=0;j<curLevel.size()-1;j++){
				nextLevel.add(curLevel.get(j) + curLevel.get(j+1));
			}
			nextLevel.add(1);
			curLevel = new ArrayList<>(nextLevel);
			nextLevel.clear();
		}
		return curLevel;

	}
	public static void main(String[] args){
		PascalTriangleII solu = new PascalTriangleII();
		for(int i=1;o<=5;i++){
		    List<Integer> res = solu.getRow(1);
			System.out.println("i = " + i + ", list = " + res);
		}
	}
}
