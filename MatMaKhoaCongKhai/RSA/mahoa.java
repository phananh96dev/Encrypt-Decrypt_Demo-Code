import java.util.Scanner;
public class mahoa{
	public static long Cipher(long M, long e, long N){
		//C = M^e mod N.
		String b = Long.toBinaryString(e);
		int c = 0, i = 0;
		long f = 1;
		while(i < b.length()){
			if(b.charAt(i) == '1'){
				c = 2 * c + 1;
				f = (f * f * M) % N;
			} else {
				c = 2 * c;
				f = (f * f) % N;
			}			
			i++;
		}
		return f;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long M, e, N;
		System.out.print("Nhap khoa cong khai Ku(e, N): ");
		e = input.nextLong();
		N = input.nextLong();
		System.out.print("Nhap Plain M (0 < M < N) = ");
		do{
			M = input.nextLong();
			if(M <= 0 || M >= N){
				System.out.print("M khong nam trong khoang gia tri cho phep, nhap lai: ");
				input.nextLine();
			} else{
				break;
			}
		} while(true);
		//Ma hoa.
		long C = Cipher(M, e, N);
		System.out.println("Cipher: " + C);
	}
}