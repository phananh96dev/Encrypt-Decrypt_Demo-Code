import java.util.Scanner;
public class giaima{
	public static long Plain(long C, long d, long N){
		//C = M^e mod N.
		String b = Long.toBinaryString(d);
		int p = 0, i = 0;
		long f = 1;
		while(i < b.length()){
			if(b.charAt(i) == '1'){
				p = 2 * p + 1;
				f = (f * f * C) % N;
			} else {
				p = 2 * p;
				f = (f * f) % N;
			}			
			i++;
		}
		return f;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long C, d, N;
		System.out.print("Nhap khoa bi mat Kr(d, N): ");
		d = input.nextLong();
		N = input.nextLong();
		System.out.print("Nhap Cipher C = ");
		C = input.nextLong();
		//Ma hoa.
		long P = Plain(C, d, N);
		System.out.println("Plain: " + P);
	}
}