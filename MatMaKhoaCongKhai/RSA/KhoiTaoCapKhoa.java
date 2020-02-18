import java.util.Scanner;
public class KhoiTaoCapKhoa{
	public static boolean IsPrimeNumber(long x){
		if(x <= 1){
			return false;
		} else if(x == 2 || x == 3){
			return true;
		} else{
			int i = 2;
			while(i <= x/2){
				if(x % i == 0){
					return false;
				}
				i++;
			}
			return true;
		}
	}
	public static long GCD(long a, long b){
		long i = b;
		while(i >= 1){
			if(a % i == 0 && b % i == 0){
				return i;
			}
			i--;
		}
		return i;
	}
	public static long Get_InverseNumber(long e, long phi){ //Ham tinh nghich dao e^(-1) mod phi(N).
		//Khoi tao gia tri.
		long g1 = phi, g2 = e;
		long v1 = 0, v2 = 1;
		//Thuc hien vong lap.
		long y = 0, v = 0;
		long g = g1 % g2;
		while(true){
			y = g1 / g2;			
			g = g1 % g2;
			v = v1 - (v2 * y);
			if(g == 1){
				break;
			}
			g1 = g2;
			g2 = g;
			v1 = v2;
			v2 = v;
		}
		if(v < 0){
			v += phi;
		}
		return v;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//Chon 2 so nguyen to ngau nhien p va q.
		long p, q;
		System.out.print("Nhap so nguyen to p: ");
		do{
			p = input.nextLong();
			if(IsPrimeNumber(p) == false){
				System.out.print("p khong phai la so nguyen to, nhap lai: ");
				input.nextLine();
			} else{
				System.out.println("\t-> Hop le.");
				break;
			}
		} while(true);
		System.out.print("Nhap so nguyen to q (q != p): ");
		do{
			q = input.nextLong();
			if(IsPrimeNumber(q) == false){
				System.out.print("q khong phai la so nguyen to, nhap lai: ");
				input.nextLine();
			}else if(q == p){
				System.out.print("q bang voi p roi, nhap lai: ");
				input.nextLine();
			} else{
				System.out.println("\t-> Hop le.");
				break;
			}
		} while(true);
		//Tinh N, Phi(N);
		long N = p * q, Phi_N = (p - 1) * (q - 1);
		System.out.println("N = " + N + "; Phi(N) = " + Phi_N + ".");
		//Chon e sao cho 0 < e < Phi(N) va GCD(Phi(N), e) = 1.
		long e;
		System.out.print("Chon so nguyen e sao cho 0 < e < Phi(N) va GCD(Phi(N), e) = 1	-> ");
		do{
			e = input.nextLong();
			if(e <= 0 || e >= Phi_N){
				System.out.print("e khong hop le do khong nam trong khoang cho phep, nhap lai: ");
				input.nextLine();
			} else if(GCD(Phi_N, e) != 1){
				System.out.print("e khong hop le do GCD(Phi(N), e) != 1, nhap lai: ");
				input.nextLine();
			} else{
				System.out.println("\t-> Hop le.");
				break;
			}
		} while(true);
		//Tinh d = e^(-1) mod Phi(N).
		long d = Get_InverseNumber(e, Phi_N);
		System.out.println("d = " + d);
		//Khoa cong khai Ku = {e, N}.
		long Ku[] = new long[2];
		Ku[0] = e;
		Ku[1] = N;
		//Khoa ca nhan (bi mat) Kr = {d, N}.
		long Kr[] = new long[2];
		Kr[0] = d;
		Kr[1] = N;
		//Ket qua.
		System.out.println("Khoa cong khai Ku = {" + Ku[0] + ", " + Ku[1] + "}.");
		System.out.println("Khoa ca nhan Kr = {" + Kr[0] + ", " + Kr[1] + "}.");
	}
}