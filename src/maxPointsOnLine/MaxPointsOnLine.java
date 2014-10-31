package maxPointsOnLine;


import java.util.*;



public class MaxPointsOnLine{
	public int maxPoints(Point[] points){
		if(points == null) return 0;
        if(points.length < 3) return points.length;
        Map<Line,Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
        	for(int j=1;j<points.length;j++){
        		Line line = line(points[i],points[j]);
        		if(!map.containsKey(line))
        			map.put(line,1);
        		else
        			map.put(line, map.get(line)+1);
        	}
        }
        int maxCount = 0;
        Line maxLine = null;
        Set<Line> lineSet = map.keySet();
        for(Line line : lineSet){
        	if(map.get(line) > maxCount){
        		maxCount = map.get(line);
        		maxLine = line;
        	}
        }
        int maxPoints = 0;
        for(int i=0;i<points.length;i++){
        	if(isOnLine(points[i],maxLine))
        		maxPoints++;
        	
        }
        return maxPoints;

	}
	private Line line(Point a, Point b){
		double slope = (a.x == b.x) ? Double.POSITIVE_INFINITY:(b.y-a.y)/(b.x-a.x);
		double inter = (a.x == b.x) ? a.x : (b.x * a.y - a.x * b.y)/(b.x - a.x);
		return new Line(slope,inter);
	}
	private boolean isOnLine(Point p, Line l){
		double epsilon = p.y - l.slope * p.x - l.inter;
		if(Math.abs(epsilon) < 1E-20)
			return true;
		else 
			return false;
	}
	public static void main(String[] args){
		MaxPointsOnLine s = new MaxPointsOnLine();	
		s.test();		
	}
    public void test(){
//    	Point[] points = new Point[3];
//    	for(int i=0;i<points.length;i++){
//			points[i] = new Point(i,i);
//		}
    	
//    	Point[] points = new Point[4];
//    	points[0] = new Point(1,1);
//    	points[1] = new Point(1,1);
//    	points[2] = new Point(2,2);
//    	points[3] = new Point(2,2);
//    	
//    	Point[] points = new Point[3];
//    	points[0] = new Point(1,0);
//    	points[1] = new Point(1,-1);
//    	points[2] = new Point(1,1);
    	
    	Point[] points = new Point[21];
		points[0] = new Point(0,9);
		points[1] = new Point(138,429);
		points[2] = new Point(115,359);
		points[3] = new Point (115,359);
		points[4] = new Point (-30,-102);
		points[5] = new Point (230,709);
		points[6] = new Point (-150,-686);
		points[7] = new Point (-135,-613);
		points[8] = new Point (-60,-248);
		points[9] = new Point (-161,-481);
		points[10] = new Point (207,639);
		points[11] = new Point (23,79);
		points[12] = new Point(-230,-691);
		points[13] = new Point (-115,-341);
		points[14] = new Point (92,289);
		points[15] = new Point(60,336);
		points[16] = new Point(-105,-467);
		points[17] = new Point(135,701);
		points[18] = new Point(-90,-394);
		points[19] = new Point(-184,-551);
		points[20] = new Point(150,774);



		System.out.println(maxPoints(points));
    }
}

class Line{
	double slope = 0.;
    double inter = 0.;
    Line(double slope, double inter){
		this.slope = slope;
        this.inter = inter;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(inter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(slope);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (Double.doubleToLongBits(inter) != Double
				.doubleToLongBits(other.inter))
			return false;
		if (Double.doubleToLongBits(slope) != Double
				.doubleToLongBits(other.slope))
			return false;
		return true;
	}
}
class Point{
	int x = 0;
    int y = 0;
    Point(int x, int y){
   		this.x = x;
	    this.y = y;
	}
    public String toString(){
	    return "(" + x + "," + y  + ")"; 	
	}
}
