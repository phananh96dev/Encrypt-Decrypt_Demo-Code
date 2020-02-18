import java.util.Scanner;
public class giaima{
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
		//Nhap CipherText va Key:
		String C;
		int K;
		System.out.print("Nhap gia tri CipherText: ");
		C = input.nextLine();
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
		//Giai ma:
		String P = ""; //PlainText.
		int i = 0;
		while(i < C.length()){
			int E = 30, I = 0; //CipherNum.
			for(int j = 0; j < 26; j++){
				if(C.charAt(i) == Alpha[j]){
					I = Num[j] - K;
					if(I < 0){
						I += 26;
					}
					E = I % 26;
					P += Alpha[E];
					break;
				}
			}
			if(E == 30){
				P += C.charAt(i);
			}
			i++;
		}
		//In ma:
		System.out.println("-> PlainText: " + P);
	}
}