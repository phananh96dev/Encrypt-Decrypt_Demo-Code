import java.util.Scanner;
public class DSSoNgTo{
	public static boolean NgTo(long x){
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
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n;
		System.out.print("Ban muon hien thi bao nhieu so nguyen to dau tien? -> ");
		n = input.nextInt();
		long i = 2, count = 0, cot = 0;
		System.out.println("\n");
		System.out.print("\t");
		while(count < n){			
			if(cot == 10){
				System.out.print("\n\n\t");
				cot = 0;
			} else{
				if(NgTo(i) == true){
					System.out.print(i + "\t");
					cot++;
					count++;
				}
			}
			i++;
		}
		System.out.println("\n");
	}
}