import java.util.Scanner;
public class mahoa{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//Khoi tao bang gia tri theo modulo 26:
		char Alpha[] = new char[26];
		int Num[] = new int[26];
		for(char i = 'A'; i <= 'Z'; i++){
			Alpha[i-65] = i;
		}
		for(int i = 0; i <= 25; i++){
			Num[i] = i;
		}
		//Nhap PlainText va Key:
		String P;
		int K;
		System.out.print("Nhap gia tri PlainText: ");
		P = input.nextLine();
		System.out.print("Nhap Key (so nguyen tu 1 den 25): ");
		do{
			try{
				K = input.nextInt();
				if(K < 1 || K > 25){
					System.err.print("Gia tri key khong hop le, nhap lai: ");
					input.nextLine();
				} else{
					input.close();
					break;
				}
			} catch(Exception e){
				System.err.print("Kieu du lieu cua key khong hop le, nhap lai: ");
				input.nextLine();
			}
		} while(true);
		//Xu ly ma:
		String C = ""; //CipherText.
		int i = 0;
		while(i < P.length()){
			int E = -1; //CipherNum.
			for(int j = 0; j < 26; j++){
				if(P.charAt(i) == Alpha[j]){
					E = (Num[j] + K) % 26;
					C += Alpha[E];
					break;
				}
			}
			if(E == -1){
				C += P.charAt(i);
			}
			i++;
		}
		//In ma:
		System.out.println("-> CipherText: " + C);
	}
}