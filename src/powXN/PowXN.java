package powXN;
public class PowXN{
	public double pow(double x, int n){
        if(n == 0) return 1;//x^0 = 1
        if(x == 0) return 0;//0^n = 0
		double[] xpow2i = new double[32];
        xpow2i[0] = x;
        for(int i=1;i<32;i++){
			xpow2i[i] = xpow2i[i-1]*xpow2i[i-1];
		}
        if(n==Integer.MIN_VALUE) 
			return xpow2i[31];
        int m = Math.abs(n);
        double res = 1;
        int count = 0;
        for(int i=0;i<31;i++){
			if((m & 1<<i) != 0)
            	res *= xpow2i[i];
		} 
        return (n>0)?res:1/res;
	}
    public static void main(String[] ags){
		double x = 1.5;
        int n = 4;
        PowXN s = new PowXN();
        
        System.out.println("x = " + x + ", n = " + n + ", pow(x,n) = " + s.pow(x,n) + ", exp " + Math.pow(x,n));
        x = 2;n=2;
        System.out.println("x = " + x + ", n = " + n + ", pow(x,n) = " + s.pow(x,n) + ", exp " + Math.pow(x,n));
        x = 2;n = -2;
        System.out.println("x = " + x + ", n = " + n + ", pow(x,n) = " + s.pow(x,n) + ", exp " + Math.pow(x,n));
        x = 1.12;n=3;
        System.out.println("x = " + x + ", n = " + n + ", pow(x,n) = " + s.pow(x,n) + ", exp " + Math.pow(x,n));
       
       
       
       
  	
	}
}
