import java.util.Scanner;
public class mahoa{
	public static String FormatKey(String P, String K){
		int l = K.length();
		if(l >= P.length()){
			return K;
		} else{
			for(int i = 0; i < P.length() - l; i++){
				K += P.charAt(i);
			}
			return K;
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//Nhap PlainText:
		String P;
		System.out.print("Nhap PlainText (Day chu cai in hoa khong dau): ");
		P = input.nextLine();
		//Nhap Key:
		String K;
		System.out.print("Nhap Key (Day chu cai in hoa khong dau) voi Key <= Plaintext: ");
		K = input.nextLine();
		input.close();
		//Do dai key:
		int m = K.length();
		//Format key de co do dai = P:
		K = FormatKey(P, K);
		//Ma hoa:
		String C = "";
		int i = 0;
		while(i < m){
			int ch = (((int)P.charAt(i) - 65) + (((int)K.charAt(i % m)) - 65)) % 26;
			if(ch < 0){
				ch += 26;
			}
			C += (char)(ch + 65);
			i++;
		}
		if(P.length() > m){
			i = m;
			while(i < P.length()){
				int ch = (((int)P.charAt(i) - 65) + (((int)K.charAt(i)) - 65)) % 26;
				if(ch < 0){
					ch += 26;
				}
				C += (char)(ch + 65);
				i++;
			}
		}
		//
		System.out.println("-> CipherText: " + C);
	}
}